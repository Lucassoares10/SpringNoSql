package com.soareslucas.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.soareslucas.workshopmongo.entities.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
