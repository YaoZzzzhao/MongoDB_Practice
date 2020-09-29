package com.nosql.repository;

import com.nosql.domain.EmailGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface EmailGroupRep extends MongoRepository<EmailGroup, String> {
    @Query("{'status': true}")
    Page<EmailGroup> findActiveRecordsInPage(PageRequest pageRequest);

    List<EmailGroup> findByStatusIsTrue();
}
