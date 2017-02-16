package com.ytzys.demo.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/2/15.
 */

public class HomePageResult {

    private MetaBean meta;
    private List<RecommendLiveBean> data;

    public MetaBean getMeta() {
        return meta;
    }

    public void setMeta(MetaBean meta) {
        this.meta = meta;
    }

    public List<RecommendLiveBean> getData() {
        return data;
    }

    public void setData(List<RecommendLiveBean> data) {
        this.data = data;
    }

    public static class MetaBean {
        /**
         * pagination : {"total":253,"count":10,"per_page":10,"current_page":1,"total_pages":26,"links":{"next":"http://liveapi.9ddm.com/api/streams?page=2"}}
         */

        private PaginationBean pagination;

        public PaginationBean getPagination() {
            return pagination;
        }

        public void setPagination(PaginationBean pagination) {
            this.pagination = pagination;
        }

        public static class PaginationBean {
            /**
             * total : 253
             * count : 10
             * per_page : 10
             * current_page : 1
             * total_pages : 26
             * links : {"next":"http://liveapi.9ddm.com/api/streams?page=2"}
             */

            private int total;
            private int count;
            private int per_page;
            private int current_page;
            private int total_pages;
            private LinksBean links;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getPer_page() {
                return per_page;
            }

            public void setPer_page(int per_page) {
                this.per_page = per_page;
            }

            public int getCurrent_page() {
                return current_page;
            }

            public void setCurrent_page(int current_page) {
                this.current_page = current_page;
            }

            public int getTotal_pages() {
                return total_pages;
            }

            public void setTotal_pages(int total_pages) {
                this.total_pages = total_pages;
            }

            public LinksBean getLinks() {
                return links;
            }

            public void setLinks(LinksBean links) {
                this.links = links;
            }

            public static class LinksBean {
                /**
                 * next : http://liveapi.9ddm.com/api/streams?page=2
                 */

                private String next;

                public String getNext() {
                    return next;
                }

                public void setNext(String next) {
                    this.next = next;
                }
            }
        }
    }

    public static class RecommendLiveBean {
        /**
         * id : 478
         * user_group_id : 1
         * name : 数码视讯年会1号机位
         * email : rerum_porro@gmail.com
         * phone_number : 11111111111
         * is_password : 0
         * description :
         * gender : 1
         * province :
         * city :
         * sign : 鸡年大吉！鸡，鸡鸡，鸡鸡鸡
         * birthday : 0000-00-00
         * avatar : http://ofyi6j5qg.bkt.clouddn.com/FvX5AWJHBKyaB1kFGXidgQ0TsIuM?imageView2/1/w/800/h/800
         * avatar_small : http://ofyi6j5qg.bkt.clouddn.com/FvX5AWJHBKyaB1kFGXidgQ0TsIuM?imageView2/1/w/200/h/200
         * user_number : 910889132
         * created_at : 2017-01-21 16:37:59
         * updated_at : 2017-01-21 17:07:23
         * deleted_at : null
         * user_id : 1
         * stream_id : z1.suma.58831de7818c6242ee18b4ea
         * stream_title : 58831de7818c6242ee18b4ea
         * disabled : 0
         * stream_json : {"id":"z1.suma.58831de7818c6242ee18b4ea","createdAt":"2017-01-21T16:37:59.252+08:00","updatedAt":"2017-01-21T16:37:59.252+08:00","expireAt":"0001-01-01T00:00:00Z","title":"58831de7818c6242ee18b4ea","hub":"suma","disabledTill":0,"disabled":false,"publishKey":"f1b423df8dc3151e","publishSecurity":"static","nonce":0,"hosts":{"publish":{"rtmp":"pili-publish.9ddm.com"},"live":{"hdl":"pili-live-hdl.9ddm.com","hls":"pili-live-hls.9ddm.com","http":"pili-live-hls.9ddm.com","rtmp":"pili-live-rtmp.9ddm.com","snapshot":"100002r.live1-snapshot.z1.pili.qiniucdn.com"},"playback":{"hls":"pili-playback.9ddm.com","http":"pili-playback.9ddm.com"},"play":{"http":"pili-live-hls.9ddm.com","rtmp":"pili-live-rtmp.9ddm.com"}},"nropEnable":null}
         * subject :
         * address : 北京市
         * cover_pic :
         * topic :
         * favour_nums : 0
         * watched_nums : 0
         * status : 1
         * room_id : 148498787971640
         * level : 81
         * rtmp_publish_url : rtmp://pili-publish.9ddm.com/suma/58831de7818c6242ee18b4ea?key=f1b423df8dc3151e
         * rtmp_live_urls : rtmp://pili-live-rtmp.9ddm.com/suma/58831de7818c6242ee18b4ea
         * hls_live_urls : http://pili-live-hls.9ddm.com/suma/58831de7818c6242ee18b4ea.m3u8
         * http_flv_live_urls : http://pili-live-hdl.9ddm.com/suma/58831de7818c6242ee18b4ea.flv
         * hls_playback_urls : http://pili-media.9ddm.com/recordings/z1.suma.58831de7818c6242ee18b4ea/1484989643.m3u8
         */

        private int id;
        private int user_group_id;
        private String name;
        private String email;
        private String phone_number;
        private int is_password;
        private String description;
        private int gender;
        private String province;
        private String city;
        private String sign;
        private String birthday;
        private String avatar;
        private String avatar_small;
        private int user_number;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private int user_id;
        private String stream_id;
        private String stream_title;
        private int disabled;
        private String stream_json;
        private String subject;
        private String address;
        private String cover_pic;
        private String topic;
        private int favour_nums;
        private int watched_nums;
        private int status;
        private long room_id;
        private int level;
        private String rtmp_publish_url;
        private String rtmp_live_urls;
        private String hls_live_urls;
        private String http_flv_live_urls;
        private String hls_playback_urls;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_group_id() {
            return user_group_id;
        }

        public void setUser_group_id(int user_group_id) {
            this.user_group_id = user_group_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone_number() {
            return phone_number;
        }

        public void setPhone_number(String phone_number) {
            this.phone_number = phone_number;
        }

        public int getIs_password() {
            return is_password;
        }

        public void setIs_password(int is_password) {
            this.is_password = is_password;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getAvatar_small() {
            return avatar_small;
        }

        public void setAvatar_small(String avatar_small) {
            this.avatar_small = avatar_small;
        }

        public int getUser_number() {
            return user_number;
        }

        public void setUser_number(int user_number) {
            this.user_number = user_number;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getStream_id() {
            return stream_id;
        }

        public void setStream_id(String stream_id) {
            this.stream_id = stream_id;
        }

        public String getStream_title() {
            return stream_title;
        }

        public void setStream_title(String stream_title) {
            this.stream_title = stream_title;
        }

        public int getDisabled() {
            return disabled;
        }

        public void setDisabled(int disabled) {
            this.disabled = disabled;
        }

        public String getStream_json() {
            return stream_json;
        }

        public void setStream_json(String stream_json) {
            this.stream_json = stream_json;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCover_pic() {
            return cover_pic;
        }

        public void setCover_pic(String cover_pic) {
            this.cover_pic = cover_pic;
        }

        public String getTopic() {
            return topic;
        }

        public void setTopic(String topic) {
            this.topic = topic;
        }

        public int getFavour_nums() {
            return favour_nums;
        }

        public void setFavour_nums(int favour_nums) {
            this.favour_nums = favour_nums;
        }

        public int getWatched_nums() {
            return watched_nums;
        }

        public void setWatched_nums(int watched_nums) {
            this.watched_nums = watched_nums;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public long getRoom_id() {
            return room_id;
        }

        public void setRoom_id(long room_id) {
            this.room_id = room_id;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public String getRtmp_publish_url() {
            return rtmp_publish_url;
        }

        public void setRtmp_publish_url(String rtmp_publish_url) {
            this.rtmp_publish_url = rtmp_publish_url;
        }

        public String getRtmp_live_urls() {
            return rtmp_live_urls;
        }

        public void setRtmp_live_urls(String rtmp_live_urls) {
            this.rtmp_live_urls = rtmp_live_urls;
        }

        public String getHls_live_urls() {
            return hls_live_urls;
        }

        public void setHls_live_urls(String hls_live_urls) {
            this.hls_live_urls = hls_live_urls;
        }

        public String getHttp_flv_live_urls() {
            return http_flv_live_urls;
        }

        public void setHttp_flv_live_urls(String http_flv_live_urls) {
            this.http_flv_live_urls = http_flv_live_urls;
        }

        public String getHls_playback_urls() {
            return hls_playback_urls;
        }

        public void setHls_playback_urls(String hls_playback_urls) {
            this.hls_playback_urls = hls_playback_urls;
        }
    }
}
