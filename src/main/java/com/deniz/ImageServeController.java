package com.deniz;

import com.deniz.json.ImageJson;
import com.deniz.json.ImageListJson;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

/**
 * author: TRYavasU
 * date: 27/08/2015
 */
@Controller
public class ImageServeController {


    @RequestMapping(value = "/image", method = RequestMethod.GET, produces = "image/png")
    public ResponseEntity<InputStreamResource> downloadImageFile(@RequestParam("name") String name)
            throws IOException {

        File image = new File("pics/" + name);

        return ResponseEntity
                .ok()
                .contentLength(image.length())
                .contentType(
                        MediaType.parseMediaType("image/png"))
                .body(new InputStreamResource(new FileInputStream(image)));
    }

}
