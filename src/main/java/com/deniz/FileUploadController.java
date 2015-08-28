package com.deniz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;

@Controller
public class FileUploadController {

    final String[] supportedMimeTypes = {"image/bmp", "image/gif", "image/jpeg", "image/png"};

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public
    @ResponseBody
    String provideUploadInfo() {
        return "You can upload a file by posting to this same URL.";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public
    @ResponseBody
    String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (!file.isEmpty()) {
            if (Arrays.asList(supportedMimeTypes).contains(file.getContentType())) {
                String name = file.getOriginalFilename();
                try {
                    byte[] bytes = file.getBytes();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File("pics/" + new Date().getTime() + "_" + name)));
                    stream.write(bytes);
                    stream.close();
                    return "You successfully uploaded " + name + "!";
                } catch (Exception e) {
                    return "You failed to upload " + name + " => " + e.getMessage();
                }
            } else {
                return "Not supported image type!";
            }
        } else {
            return "You failed to upload file because it was empty.";
        }
    }

}