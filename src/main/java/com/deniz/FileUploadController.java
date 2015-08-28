package com.deniz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;

@Controller
public class FileUploadController {

    private static final int IMG_WIDTH = 40;
    private static final int IMG_HEIGHT = 40;
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
                    Date now = new Date();
                    BufferedOutputStream stream =
                            new BufferedOutputStream(new FileOutputStream(new File("pics/" + now.getTime() + "_" + name)));
                    stream.write(bytes);
                    stream.close();

                    BufferedImage originalImage = ImageIO.read(new File("pics/" + now.getTime() + "_" + name));
                    int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizeImageJpg = resizeImage(originalImage, type);
                    ImageIO.write(resizeImageJpg, "jpg", new File("pics_s/" + now.getTime() + "_" + name));

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

    private static BufferedImage resizeImage(BufferedImage originalImage, int type){
        BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
        g.dispose();

        return resizedImage;
    }

    public static BufferedImage resize(BufferedImage img, int newW, int newH) {
        int w = img.getWidth();
        int h = img.getHeight();
        BufferedImage dimg = dimg = new BufferedImage(newW, newH, img.getType());
        Graphics2D g = dimg.createGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(img, 0, 0, newW, newH, 0, 0, w, h, null);
        g.dispose();
        return dimg;
    }

}