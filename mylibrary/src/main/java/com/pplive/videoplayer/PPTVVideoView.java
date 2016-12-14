package com.pplive.videoplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.pplive.media.player.MediaInfo;
import android.pplive.media.player.MediaPlayer.OnBufferingUpdateListener;
import android.pplive.media.player.MediaPlayer.OnCompletionListener;
import android.pplive.media.player.MediaPlayer.OnErrorListener;
import android.pplive.media.player.MediaPlayer.OnInfoListener;
import android.pplive.media.player.MediaPlayer.OnPreparedListener;
import android.pplive.media.player.MediaPlayer.OnSeekCompleteListener;
import android.pplive.media.player.MediaPlayer.OnVideoSizeChangedListener;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.pplive.sdk.BipHelper;
import com.pplive.sdk.PlayType;
import com.pplive.videoplayer.Vast.AdParam;
import com.pplive.videoplayer.Vast.IAdPlayController;
import com.pplive.videoplayer.Vast.VastAdController;
import com.pplive.videoplayer.Vast.VendorAdUtil.Vast;
import com.pplive.videoplayer.bean.BoxPlay2;
import com.pplive.videoplayer.statistics.DACHelper;
import com.pplive.videoplayer.statistics.DACWatch;
import com.pplive.videoplayer.utils.ConfigUtil;
import com.pplive.videoplayer.utils.LogUtils;
import com.pplive.videoplayer.utils.MediaInfoCache;
import com.pplive.videoplayer.utils.common.DataCommon;
import com.pplive.videoplayer.utils.common.DataCommon.PLATFORM;
import java.io.File;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PPTVVideoView
  extends BaseMeetVideoView
{
  public static final int DETAIL_LIVE_TOTALTIME = 1800000;
  public static final int ERROR_INTERNAL = 0;
  public static final int ERROR_NETWORK = 1;
  public static final int ERROR_PLAY = 2;
  public static final int ERROR_VIRTUAL = 4;
  public static final int ERROR_FILESYSTEM = 2;
  private PPTVPlayerItem a;
  private int b = -1;
  private VastAdController c = null;
  private boolean d = false;
  private boolean e = false;
  private boolean f = true;
  private ImageView g = null;
  private int h = 0;
  private DACHelper i;
  public int liveSeekTime;
  private boolean j = false;
  private int k = 0;
  private BasePlayerStatusListener l;
  private Context m;
  private final int n = 1;
  public BoxPlay2 mBoxPlay = null;
  public long durFromClickToUI = 0L;
  private Handler o = new c(this);
  private MediaPlayer.OnBufferingUpdateListener p = new m(this);
  private MediaPlayer.OnVideoSizeChangedListener q = new n(this);
  private MediaPlayer.OnInfoListener r = new o(this);
  private MediaPlayer.OnCompletionListener s = new p(this);
  private MediaPlayer.OnPreparedListener t = new q(this);
  private MediaPlayer.OnErrorListener u = new r(this);
  private MediaPlayer.OnBufferingUpdateListener v = new s(this);
  private MediaPlayer.OnCompletionListener w = new t(this);
  private MediaPlayer.OnErrorListener x = new d(this);
  private MediaPlayer.OnInfoListener y = new e(this);
  private MediaPlayer.OnPreparedListener z = new f(this);
  private MediaPlayer.OnSeekCompleteListener A = new g(this);
  private MediaPlayer.OnVideoSizeChangedListener B = new h(this);
  private IAdPlayController C = new i(this);
  private Integer D = Integer.valueOf(0);
  private List<Integer> E = new j(this);
  
  public BasePlayerStatusListener getPlayStatusListener()
  {
    return this.l;
  }
  
  public PPTVVideoView(Context paramContext)
  {
    super(paramContext, null);
    this.m = paramContext;
  }
  
  public PPTVVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.m = paramContext;
  }
  
  public PPTVVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.m = paramContext;
  }
  
  public void init(Context paramContext, ImageView paramImageView, DACHelper paramDACHelper)
  {
    LogUtils.error("init");
    this.g = paramImageView;
    this.i = paramDACHelper;
    this.m = paramContext;
    if (this.g != null) {
      this.g.setOnClickListener(new k(this));
    }
    paramDACHelper.init(getContext());
    DataCommon.changePlatform(ConfigUtil.getVideoQualityPref(getContext().getApplicationContext()) == 1 ? DataCommon.PLATFORM.ANDROID3 : DataCommon.PLATFORM.ANDROID_PHONE);
  }
  
  public void uninit()
  {
    this.j = false;
    this.k = 0;
    if (!this.j) {
      this.liveSeekTime = 0;
    }
    PPTVVideoView localPPTVVideoView = this;
    if (this.i != null) {
      localPPTVVideoView.i.resetAllDac();
    }
    a();
    this.i.uninit();
    this.m = null;
  }
  
  public void setStatusListener(BasePlayerStatusListener paramBasePlayerStatusListener)
  {
    this.l = paramBasePlayerStatusListener;
  }
  
  private void a()
  {
    this.d = false;
    this.e = false;
    this.f = true;
  }
  
  public DACHelper getDacHelper()
  {
    return this.i;
  }
  
  private void b()
  {
    long l1 = SystemClock.elapsedRealtime();
    PPTVVideoView localPPTVVideoView = this;
    LogUtils.debug("dacHelper is null: " + (localPPTVVideoView.i == null));
    if (localPPTVVideoView.i != null)
    {
      LogUtils.debug("dacHelper start: " + l1);
      localPPTVVideoView.i.uiInitDacWatch = (localPPTVVideoView.i.uiInitDacWatch == null ? new DACWatch(l1) : localPPTVVideoView.i.uiInitDacWatch);
      localPPTVVideoView.i.playStartDacWatch = (localPPTVVideoView.i.playStartDacWatch == null ? new DACWatch(l1) : localPPTVVideoView.i.playStartDacWatch);
    }
  }
  
  public void onUIInitEnd()
  {
    if ((this.i != null) && (this.i.uiInitDacWatch != null))
    {
      this.i.uiInitDacWatch.stop(true);
      this.i.uiInitDuration = this.i.uiInitDacWatch.getDuration();
    }
  }
  
  private void c()
  {
    this.e = true;
    this.h = getCurrentPosition();
    super.pause();
    LogUtils.error("pauseAd: " + this.h);
    if (this.c != null) {
      this.c.onAdPaused();
    }
  }
  
  public boolean isAdFinish()
  {
    if (this.f) {
      return this.d;
    }
    return true;
  }
  
  public boolean playPlayerAd(IAdPlayController paramIAdPlayController)
  {
    LogUtils.error("playPlayerAd");
    AdParam localAdParam = a(VendorAdUtil.Vast.VAST_PREROLL_AD);
    if (this.c == null)
    {
      this.c = new VastAdController(this.m, this);
      this.c.setPlayStatusListener(this.l);
    }
    a();
    this.c.loadVastAd(localAdParam, paramIAdPlayController);
    return true;
  }
  
  public void playPauseAd(IAdPlayController paramIAdPlayController)
  {
    AdParam localAdParam = a(VendorAdUtil.Vast.VAST_PAUSE_AD);
    if (this.c == null)
    {
      this.c = new VastAdController(this.m, this);
      this.c.setPlayStatusListener(this.l);
    }
    this.c.loadVastAd(localAdParam, paramIAdPlayController);
  }
  
  private AdParam a(String paramString)
  {
    String str1 = this.a.mVid;
    String str2 = BipHelper.s_vvid;
    String str3 = BipHelper.s_cataId;
    AdParam localAdParam;
    (localAdParam = new AdParam(paramString, str2, str1, str3, 1800000L)).setSid(BipHelper.s_sid);
    Uri localUri = Uri.parse(this.a.mRefer);
    File localFile;
    if ((localFile = new File(localUri.getPath())).exists())
    {
      MediaInfoCache.getMediaInfo(localFile.getPath()).getDuration();
      localAdParam.localPlay = true;
    }
    return localAdParam;
  }
  
  public boolean isAdPlaying()
  {
    return (this.f) && (!this.d);
  }
  
  public void setAdExist(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((!paramBoolean1) && (this.a != null) && (this.a.mRefer != null))
    {
      LogUtils.info("videourl:" + this.a.mRefer);
      if ((paramBoolean2) && ((this.b == -1) || (this.b == 10) || (this.b == 5))) {
        a(Uri.parse(this.a.mRefer));
      }
    }
  }
  
  public boolean getEnableAd()
  {
    return this.f;
  }
  
  public void setEnableAd(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public void showVideoAdView()
  {
    if (this.g != null) {
      this.g.setVisibility(8);
    }
  }
  
  public void clickToDetail()
  {
    LogUtils.error("clickToDetail");
    if ((this.f) && (!this.d) && (this.c != null)) {
      this.c.clickToDetail();
    }
  }
  
  public void clickToSkip()
  {
    LogUtils.error("clickToSkip");
    if ((this.f) && (!this.d) && (this.c != null))
    {
      this.c.onAdFinished();
      this.d = true;
    }
  }
  
  public void startPPTVPlayer(PPTVPlayerItem paramPPTVPlayerItem)
  {
    if ((paramPPTVPlayerItem == null) || (TextUtils.isEmpty(paramPPTVPlayerItem.mRefer)))
    {
      this.l.onError(4, 0, 0);
      return;
    }
    this.a = paramPPTVPlayerItem;
    LogUtils.error("startPPTVPlayer: isPlayAd=" + this.f + ", adFinish=" + this.d + ", BipHelper.s_userType=" + BipHelper.s_userType);
    if ((this.f) && (!this.d)) {
      if (((BipHelper.s_userType != null) && (BipHelper.s_userType.equals("1")) ? 1 : 0) == 0) {
        if (playPlayerAd(this.C)) {
          return;
        }
      }
    }
    a(Uri.parse(paramPPTVPlayerItem.mRefer));
  }
  
  private void a(Uri paramUri)
  {
    LogUtils.error("setUri: " + paramUri.toString());
    setEnableAd(false);
    this.d = true;
    b();
    onUIInitEnd();
    this.b = 0;
    if (this.l != null) {
      this.l.onStatus(this.b);
    }
    if (this.i != null)
    {
      this.i.onPrepare(0);
      this.i.setPhase(10);
    }
    super.setOnBufferingUpdateListener(this.v);
    super.setOnVideoSizeChangedListener(this.B);
    super.setOnInfoListener(this.y);
    super.setOnCompletionListener(this.w);
    super.setOnErrorListener(this.x);
    super.setOnPreparedListener(this.z);
    super.setOnSeekCompleteListener(this.A);
    super.setVideoURI(paramUri);
  }
  
  public void resume()
  {
    LogUtils.error("resume: mPlayState=" + this.b);
    if ((this.b == 8) || (this.b == 701) || (this.b == 702))
    {
      if ((this.f) && (!this.d))
      {
        PPTVVideoView localPPTVVideoView = this;
        LogUtils.error("resumeAd");
        if (localPPTVVideoView.c != null)
        {
          if (localPPTVVideoView.c.isAdWebViewShow())
          {
            LogUtils.error("skip isAdWebViewShow");
            return;
          }
          localPPTVVideoView.e = false;
          localPPTVVideoView.c.onAdResumed();
          localPPTVVideoView.start();
        }
        return;
      }
      start();
    }
  }
  
  public void replay()
  {
    LogUtils.error("replay");
    b();
    onUIInitEnd();
    this.b = 0;
    if (this.l != null) {
      this.l.onStatus(this.b);
    }
    if (this.i != null) {
      this.i.onPrepare(0);
    }
    this.d = true;
    super.setVideoURI(Uri.parse(this.a.mRefer));
  }
  
  public void start()
  {
    LogUtils.error("start: mPlayState=" + this.b);
    if (this.b == 7)
    {
      LogUtils.error("skip");
      return;
    }
    if ((this.f) && (!this.d))
    {
      LogUtils.error("skip for ad");
      return;
    }
    super.start();
    this.i.timeBetweenStartAndPrepared += Math.round((float)this.durFromClickToUI / 1000.0F);
    this.b = 7;
    if (this.l != null)
    {
      this.l.onStarted();
      this.l.onStatus(this.b);
    }
    if (this.i != null)
    {
      this.i.onPrepare(this.b);
      if (this.i.getDacViewVideo() != null) {
        this.i.getDacViewVideo().start();
      }
    }
  }
  
  public void pause()
  {
    LogUtils.error("pause: mPlayState=" + this.b);
    if ((this.b == 5) || (this.b == 10))
    {
      LogUtils.error("skip");
      return;
    }
    this.b = 8;
    if (this.l != null)
    {
      this.l.onPaused();
      this.l.onStatus(this.b);
    }
    if (isAdPlaying())
    {
      c();
      return;
    }
    d();
    super.pause();
    if (this.i != null)
    {
      this.i.onPrepare(this.b);
      if (this.i.getDacViewVideo() != null) {
        this.i.getDacViewVideo().pause();
      }
    }
  }
  
  public void stop(boolean paramBoolean1, boolean paramBoolean2)
  {
    LogUtils.error("stop: savePosition=" + paramBoolean1 + ", isComplete=" + paramBoolean2);
    if (!isAdFinish())
    {
      LogUtils.debug("广告还未结束");
      LogUtils.info("saveHistory getCurrentPosition:" + getCurrentPosition() + " getDuration:" + getDuration());
      if (this.c != null) {
        this.c.onAdFinished();
      }
    }
    if (this.i != null)
    {
      this.i.onPrepare(5);
      if (this.i.getDacViewVideo() != null) {
        this.i.getDacViewVideo().pause();
      }
    }
    this.j = paramBoolean1;
    this.k = 0;
    if (paramBoolean1) {
      d();
    }
    this.o.removeMessages(1);
    if (paramBoolean2)
    {
      int i1 = getDuration() / 1000;
      this.b = 5;
      if (this.l != null)
      {
        this.l.onProgressUpdate(i1, i1);
        this.l.onCompletion();
        this.l.onStatus(this.b);
      }
    }
    else
    {
      this.b = 10;
      if (this.l != null)
      {
        this.l.onStoped();
        this.l.onStatus(this.b);
      }
    }
    super.stopPlayback();
    a();
  }
  
  public int getPlayState()
  {
    return this.b;
  }
  
  public void seekTo(int paramInt, boolean paramBoolean)
  {
    LogUtils.error("seekTo: second=" + paramInt / 1000 + ", fromUser=" + paramBoolean + ", BipHelper.s_playType=" + BipHelper.s_playType);
    if (BipHelper.s_playType == PlayType.LIVE)
    {
      this.l.onSeekComplete(super.getCurrentPosition(), super.getDuration());
      return;
    }
    this.b = 701;
    if (this.l != null) {
      this.l.onSeekStartFromUser();
    }
    super.seekTo(paramInt);
    if ((paramBoolean) && (this.i != null)) {
      this.i.addSeekNum();
    }
  }
  
  public void setForceSeekTo(int paramInt)
  {
    this.k = paramInt;
  }
  
  public static boolean isIp(String paramString)
  {
    return Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b").matcher(paramString).matches();
  }
  
  private void d()
  {
    this.j = true;
    this.k = super.getCurrentPosition();
    LogUtils.error("saveSeek: forceSeekTo=" + this.k);
  }
  
  public Integer getCurrentScaleType()
  {
    return this.D;
  }
  
  public List<Integer> getScaleTypeList()
  {
    return this.E;
  }
  
  public void changeScaleType(Integer paramInteger)
  {
    this.D = paramInteger;
    super.setDisplayMode(paramInteger.intValue());
  }
}



/* Location:           F:\工具\apk破解\jd-gui-0.3.6.windows\pptv_sdk.jar

 * Qualified Name:     com.pplive.videoplayer.PPTVVideoView

 * JD-Core Version:    0.7.0.1

 */