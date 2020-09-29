package com.nosql.controller;

import com.nosql.delegate.EmailGroupDelegate;
import com.nosql.domain.EmailGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/email/group")
public class EmailGroupController {

    @Autowired
    private EmailGroupDelegate emailGroupDelegate;

    @GetMapping("/get-all-emails")
    @ResponseBody
    public Page<EmailGroup> getAllEmails(){
        return emailGroupDelegate.getAllEmails();
    }

    @PostMapping("/save-emails")
    @ResponseBody
    public List<EmailGroup> saveOrUpdateEmails(@RequestBody List<EmailGroup> emails){
        return emailGroupDelegate.saveOrUpdateEmail(emails);
    }
}
