package com.nosql.controller;

import com.nosql.delegate.EmailGroupDelegate;
import com.nosql.domain.EmailGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/email/group")
public class EmailGroupController {

    @Autowired
    private EmailGroupDelegate emailGroupDelegate;

    @PostMapping("/get-all-emails")
    public List<EmailGroup> getAllEmails(){
        return emailGroupDelegate.getAllEmails();
    }

    @PostMapping("/save-emails")
    public List<EmailGroup> saveOrUpdateEmails(@RequestBody List<EmailGroup> emails){
        return emailGroupDelegate.saveOrUpdateEmail(emails);
    }
}
