package com.deniz.json;

import java.util.Date;

/**
 * author: TRYavasU
 * date: 27/08/2015
 */
public class ImageJson {
    String smallUrl;
    String largeUrl;
    Date date;

    public ImageJson(String smallUrl, String largeUrl, Date date) {
        this.smallUrl = smallUrl;
        this.largeUrl = largeUrl;
        this.date = date;
    }

    public String getSmallUrl() {
        return smallUrl;
    }

    public void setSmallUrl(String smallUrl) {
        this.smallUrl = smallUrl;
    }

    public String getLargeUrl() {
        return largeUrl;
    }

    public void setLargeUrl(String largeUrl) {
        this.largeUrl = largeUrl;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
