package com.nosql.controller;

import com.nosql.delegate.EmailImageDelegate;
import com.nosql.domain.EmailImage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/email/image")
public class EmailImageController {
    private static final Logger LOG = LoggerFactory.getLogger(EmailImageController.class);

    @Autowired
    private EmailImageDelegate emailImageDelegate;

    @GetMapping(value = "/get-all-images")
    List<EmailImage> getAllImages(){
        return emailImageDelegate.getAllImages();
    }

    @PostMapping(value="/save-image")
    List<EmailImage> saveImage(@RequestBody EmailImage image){
        return emailImageDelegate.saveOrUpdateImage(image);
    }

    @PostMapping(value="save-image-from-local")
    ResponseEntity<List<EmailImage>> saveImageLocally(@RequestBody MultipartFile file){
        EmailImage image = new EmailImage();
        List<EmailImage> resultList = new ArrayList<>();
        HttpStatus httpStatus;
        try {
            image.setImageFile(file.getBytes());
            image.setImageName(file.getOriginalFilename());
            image.setStatus(true);
            image.setCreatedTime(new Date());
            image.setLastUpdatedTime(new Date());

            resultList = emailImageDelegate.saveOrUpdateImage(image);
            httpStatus = HttpStatus.OK;
        }catch(IOException e){
            LOG.info(e.getMessage());
            httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return new ResponseEntity<>(resultList, httpStatus);
    }
}
