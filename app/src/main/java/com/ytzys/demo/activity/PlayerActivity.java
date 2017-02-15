package com.ytzys.demo.activity;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.ytzys.demo.R;

public class PlayerActivity extends AppCompatActivity {

    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        videoView = (VideoView) findViewById(R.id.player);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
//                Uri uri = Uri.parse("http://play.g3proxy.lecloud.com/vod/v2/MjQ3LzcvNDIvbGV0di11dHMvMTQvdmVyXzAwXzIyLTEwODE5Mzg0MzItYXZjLTE0NjkxMDQtYWFjLTk2MDAwLTQ0NDU3NjAtODc2NDQ5MDA3LTI0OTZlOGEwZmZmYTkyZjc1OWU2MjNmNTg2YmRmZjg1LTE0ODQ1NDQyMzgzMjQubXA0?b=1577&mmsid=62600109&tm=1484805916&key=69b045a35c8b6e1e347df9dae2b00df9&platid=6&splatid=602&orifrom=aHR0cDovL3R2ZXBnLmxldHYuY29tL2Z0bC9hcGsvZGF0YS9jb21tb24vc2VjdXJpdHkvcGxheXVybC9nZXR1cmwvYnl2aWQ=&orivid=27506445&clientIp01=122.114.152.188&clientIp02=111.206.210.33&playid=0&tss=tvts&vtype=51&cvid=384065246356&payff=0&pip=47ac29f176cfbc686793bde9a547beda");
                videoView.stopPlayback();
                Uri uri = Uri.parse("http://k.youku.com/player/getFlvPath/sid/1484804581055128c9b76_00/st/mp4/fileid/0300200100587DA38B4D4B011BA6A9277C46F3-9505-EE66-9334-21FE9057558D?k=cd886daeb7b818c3261f7794&hd=1&myp=0&ts=5869&ypremium=1&ymovie=1&sign=35a51094a99e0d19d61f7312b3651dec&ypp=0&ctype=12&ev=1&token=0929&oip=712725356&ep=cyacHkGNUssI5CPajT8bb3%2frJnAJXP4J9h%2bHgdJjALshQO%2fL6D3ZtZnESo1CF%2fhrAyR3Gen2rKPjbDYXYflGqW0QqjuuP%2frp%2ffPn5a9SsuUJZhwxd8jfwFSeSjL4");
                videoView.setVideoURI(uri);
                videoView.start();
                videoView.requestFocus();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Uri uri = Uri.parse("http://play.g3proxy.lecloud.com/vod/v2/MjQ3LzcvNDIvbGV0di11dHMvMTQvdmVyXzAwXzIyLTEwODE5Mzg0MzItYXZjLTE0NjkxMDQtYWFjLTk2MDAwLTQ0NDU3NjAtODc2NDQ5MDA3LTI0OTZlOGEwZmZmYTkyZjc1OWU2MjNmNTg2YmRmZjg1LTE0ODQ1NDQyMzgzMjQubXA0?b=1577&mmsid=62600109&tm=1484813305&key=a2e97ecb70aec0413febbaceb37cfa88&platid=6&splatid=602&orifrom=aHR0cDovL3R2ZXBnLmxldHYuY29tL2Z0bC9hcGsvZGF0YS9jb21tb24vc2VjdXJpdHkvcGxheXVybC9nZXR1cmwvYnl2aWQ=&orivid=27506445&clientIp01=122.114.152.188&clientIp02=111.206.210.32&playid=0&tss=tvts&vtype=51&cvid=351388531380&payff=0&pip=4b22d68407afeccd36e7b010e363f6cb");
        Uri uri = Uri.parse("http://42.81.6.101/230/26/110/letv-uts/14/ver_00_22-1081938436-avc-784344-aac-64000-4445760-476482883-820c00e2d96717e76e0d5ed0682f342d-1484541458128.m3u8?crypt=95aa7f2e837&b=857&nlh=4096&nlt=60&bf=78&p2p=1&video_type=mp4&termid=0&tss=ios&platid=3&splatid=347&its=12346171&qos=5&fcheck=0&amltag=19650&mltag=19650&proxy=1032384045,709972185,1786224518&uid=2093671190.rp&keyitem=GOw_33YJAAbXYE-cnQwpfLlv_b2zAkYctFVqe5bsXQpaGNn3T1-vhw..&ntm=1484836200&nkey=4ed3359131a0bba69da90cfb272b6aa3&nkey2=0f1e6f37712c7fabe2a718dbae268c05&geo=CN-1-0-1&mmsid=62600109&tm=1484817949&key=9619f59b37b51df2b88c9d5de7182b8f&playid=0&vtype=22&cvid=180643095812&payff=1&sign=mb&dname=mobile&p1=0&p2=00&p3=003&tag=mobile&pid=10034205&errc=0&gn=830&vrtmcd=109&buss=19650&cips=124.202.227.22");
//        Uri uri = Uri.parse("http://k.youku.com/player/getFlvPath/sid/1484804581055128c9b76_00/st/mp4/fileid/0300200100587DA38B4D4B011BA6A9277C46F3-9505-EE66-9334-21FE9057558D?k=cd886daeb7b818c3261f7794&hd=1&myp=0&ts=5869&ypremium=1&ymovie=1&sign=35a51094a99e0d19d61f7312b3651dec&ypp=0&ctype=12&ev=1&token=0929&oip=712725356&ep=cyacHkGNUssI5CPajT8bb3%2frJnAJXP4J9h%2bHgdJjALshQO%2fL6D3ZtZnESo1CF%2fhrAyR3Gen2rKPjbDYXYflGqW0QqjuuP%2frp%2ffPn5a9SsuUJZhwxd8jfwFSeSjL4");
        videoView.setMediaController(new MediaController(this));
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.requestFocus();
    }
}
