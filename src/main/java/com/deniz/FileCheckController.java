package com.deniz;

import com.deniz.json.ImageJson;
import com.deniz.json.ImageListJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.util.Date;

/**
 * author: TRYavasU
 * date: 27/08/2015
 */
@Controller
public class FileCheckController {

    @RequestMapping("/pics")
    @ResponseBody
    public ImageListJson pics() {
        final File folder = new File("pics");

        ImageListJson imageList = new ImageListJson();
        for (final File fileEntry : folder.listFiles()) {
            String fileName = fileEntry.getName();
            String dateText = fileName.substring(0, fileName.indexOf('_'));
            Date date = new Date(Long.parseLong(dateText));
            imageList.getImages().add(new ImageJson(fileName, fileName, date));
        }
        return imageList;
    }

}
