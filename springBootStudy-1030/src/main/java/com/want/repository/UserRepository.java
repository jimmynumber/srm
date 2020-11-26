package com.want.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.want.entity.User_2;


 
//@Repository
public interface UserRepository extends ReactiveMongoRepository<User_2,String> {

}
