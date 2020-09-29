package com.nosql.delegate;

import com.nosql.domain.EmailGroup;
import com.nosql.repository.EmailGroupRep;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailGroupDelegate {
    private static final Logger LOG = LoggerFactory.getLogger(EmailGroupDelegate.class);

    @Autowired
    private EmailGroupRep emailGroupRep;

    public List<EmailGroup> saveOrUpdateEmail(List<EmailGroup> emails){

        return emailGroupRep.saveAll(emails);
    }

    public List<EmailGroup> getAllEmails(){
        return emailGroupRep.findByStatusIsTrue();
    }
}
