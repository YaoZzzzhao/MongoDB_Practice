package com.nosql.delegate;

import com.nosql.domain.EmailImage;
import com.nosql.repository.EmailImageRep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Date;
import java.util.List;

@Service
public class EmailImageDelegate {

    private static final Logger LOG = LoggerFactory.getLogger(EmailImageDelegate.class);

    @Autowired
    private EmailImageRep emailImageRep;

    public List<EmailImage> saveOrUpdateImage(EmailImage image){
        if(image.getCreatedTime() == null){
            image.setCreatedTime(new Date());
        }
        image.setLastUpdatedTime(new Date());

        emailImageRep.save(image);

        LOG.info("Image saved successfully");

        return getAllImages();
    }

    public List<EmailImage> getAllImages(){
        return emailImageRep.findByStatusIsTrue();
    }
}
