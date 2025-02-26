package com.demo.elasticsearch.repository;

import com.demo.elasticsearch.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends ElasticsearchRepository<User, String > {

    List<User> findByAccount(String account);

}
