package com.deniz.json;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * author: TRYavasU
 * date: 27/08/2015
 */
public class ImageJson {
    String smallUrl;
    String largeUrl;
    String dateText;

    public ImageJson(String smallUrl, String largeUrl, Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        this.smallUrl = smallUrl;
        this.largeUrl = largeUrl;
        this.dateText = format.format(date);
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

    public String getDateText() {
        return dateText;
    }

    public void setDateText(String dateText) {
        this.dateText = dateText;
    }
}
