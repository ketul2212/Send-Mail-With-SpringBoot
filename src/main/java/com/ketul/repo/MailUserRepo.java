package com.ketul.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ketul.module.MailUser;

public interface MailUserRepo extends MongoRepository<MailUser, Integer> {

}
