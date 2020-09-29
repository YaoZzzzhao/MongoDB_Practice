package com.nosql.repository;

import com.nosql.domain.EmailGroup;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EmailGroupRep extends MongoRepository<EmailGroup, String> {
    List<EmailGroup> findByStatusIsTrue();
}
