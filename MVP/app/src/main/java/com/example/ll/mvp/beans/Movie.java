package com.example.ll.mvp.beans;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LL on 2017/7/4.
 */

public class Movie implements Serializable{

    /**
     * rating : {"max":10,"average":4.8,"stars":"25","min":0}
     * genres : ["动作","科幻"]
     * title : 变形金刚5：最后的骑士
     * casts : [{"alt":"https://movie.douban.com/celebrity/1035674/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/1407766093.88.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1407766093.88.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1407766093.88.jpg"},"name":"马克·沃尔伯格","id":"1035674"},{"alt":"https://movie.douban.com/celebrity/1356047/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1497256004.65.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1497256004.65.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1497256004.65.jpg"},"name":"伊莎贝拉·莫奈","id":"1356047"},{"alt":"https://movie.douban.com/celebrity/1324587/","avatars":{"small":"https://img3.doubanio.com/img/celebrity/small/1358578638.44.jpg","large":"https://img3.doubanio.com/img/celebrity/large/1358578638.44.jpg","medium":"https://img3.doubanio.com/img/celebrity/medium/1358578638.44.jpg"},"name":"劳拉·哈德克","id":"1324587"}]
     * collect_count : 85521
     * original_title : Transformers: The Last Knight
     * subtype : movie
     * directors : [{"alt":"https://movie.douban.com/celebrity/1027776/","avatars":{"small":"https://img1.doubanio.com/img/celebrity/small/319.jpg","large":"https://img1.doubanio.com/img/celebrity/large/319.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/319.jpg"},"name":"迈克尔·贝","id":"1027776"}]
     * year : 2017
     * images : {"small":"https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p2462475058.webp","large":"https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p2462475058.webp","medium":"https://img1.doubanio.com/view/movie_poster_cover/spst/public/p2462475058.webp"}
     * alt : https://movie.douban.com/subject/25824686/
     * id : 25824686
     */

    private RatingBean rating;
    private String title;
    private int collect_count;
    private String original_title;
    private String subtype;
    private String year;
    private ImagesBean images;
    private String alt;
    private String id;
    private List<String> genres;
    private List<CastsBean> casts;
    private List<DirectorsBean> directors;

    public RatingBean getRating() {
        return rating;
    }

    public void setRating(RatingBean rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCollect_count() {
        return collect_count;
    }

    public void setCollect_count(int collect_count) {
        this.collect_count = collect_count;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ImagesBean getImages() {
        return images;
    }

    public void setImages(ImagesBean images) {
        this.images = images;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<CastsBean> getCasts() {
        return casts;
    }

    public void setCasts(List<CastsBean> casts) {
        this.casts = casts;
    }

    public List<DirectorsBean> getDirectors() {
        return directors;
    }

    public void setDirectors(List<DirectorsBean> directors) {
        this.directors = directors;
    }

    public static class RatingBean {
        /**
         * max : 10
         * average : 4.8
         * stars : 25
         * min : 0
         */

        private int max;
        private double average;
        private String stars;
        private int min;

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        public double getAverage() {
            return average;
        }

        public void setAverage(double average) {
            this.average = average;
        }

        public String getStars() {
            return stars;
        }

        public void setStars(String stars) {
            this.stars = stars;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }
    }

    public static class ImagesBean {
        /**
         * small : https://img1.doubanio.com/view/movie_poster_cover/ipst/public/p2462475058.webp
         * large : https://img1.doubanio.com/view/movie_poster_cover/lpst/public/p2462475058.webp
         * medium : https://img1.doubanio.com/view/movie_poster_cover/spst/public/p2462475058.webp
         */

        private String small;
        private String large;
        private String medium;

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }
    }

    public static class CastsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1035674/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/1407766093.88.jpg","large":"https://img1.doubanio.com/img/celebrity/large/1407766093.88.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/1407766093.88.jpg"}
         * name : 马克·沃尔伯格
         * id : 1035674
         */

        private String alt;
        private AvatarsBean avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBean getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBean avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBean {
            /**
             * small : https://img1.doubanio.com/img/celebrity/small/1407766093.88.jpg
             * large : https://img1.doubanio.com/img/celebrity/large/1407766093.88.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/1407766093.88.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }

    public static class DirectorsBean {
        /**
         * alt : https://movie.douban.com/celebrity/1027776/
         * avatars : {"small":"https://img1.doubanio.com/img/celebrity/small/319.jpg","large":"https://img1.doubanio.com/img/celebrity/large/319.jpg","medium":"https://img1.doubanio.com/img/celebrity/medium/319.jpg"}
         * name : 迈克尔·贝
         * id : 1027776
         */

        private String alt;
        private AvatarsBeanX avatars;
        private String name;
        private String id;

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public AvatarsBeanX getAvatars() {
            return avatars;
        }

        public void setAvatars(AvatarsBeanX avatars) {
            this.avatars = avatars;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public static class AvatarsBeanX {
            /**
             * small : https://img1.doubanio.com/img/celebrity/small/319.jpg
             * large : https://img1.doubanio.com/img/celebrity/large/319.jpg
             * medium : https://img1.doubanio.com/img/celebrity/medium/319.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }
    }
}
