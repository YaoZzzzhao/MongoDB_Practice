package com.nosql.repository;

import com.nosql.domain.EmailImage;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmailImageRep extends MongoRepository<EmailImage,String> {
    List<EmailImage> findByStatusIsTrue();
}
