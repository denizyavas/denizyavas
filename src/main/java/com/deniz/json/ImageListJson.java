package com.deniz.json;

import java.util.ArrayList;
import java.util.List;

/**
 * author: TRYavasU
 * date: 27/08/2015
 */
public class ImageListJson {
    List<ImageJson> images = new ArrayList<ImageJson>();

    public ImageListJson() {
    }

    public List<ImageJson> getImages() {
        return images;
    }

    public void setImages(List<ImageJson> images) {
        this.images = images;
    }
}
