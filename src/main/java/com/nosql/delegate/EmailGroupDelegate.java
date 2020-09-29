package com.nosql.delegate;

import com.nosql.domain.EmailGroup;
import com.nosql.repository.EmailGroupRep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmailGroupDelegate {
    private static final Logger LOG = LoggerFactory.getLogger(EmailGroupDelegate.class);

    @Autowired
    private EmailGroupRep emailGroupRep;

    public List<EmailGroup> saveOrUpdateEmail(List<EmailGroup> emails){

        if(emails.isEmpty()){
            LOG.info("Empty email list to save");
            return new ArrayList<>();
        }else{
            for(EmailGroup email:emails){
                if(email.getCreatedTime() == null){
                    email.setCreatedTime(new Date());
                }
                email.setLastUpdatedTime(new Date());
//                email.setLastUpdatedBy("Admin");
            }
        }

        return emailGroupRep.saveAll(emails);
    }

    public Page<EmailGroup> getAllEmails(){
//        Pageable pageable = new PageRequest(0,10);
        return emailGroupRep.findAll(PageRequest.of(0,5));
    }
}
