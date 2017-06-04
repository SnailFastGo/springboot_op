package com.myspringboot.repository.neo4j;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import com.myspringboot.entity.neo4j.UserGraphEntity;

@Repository
public interface UserGraphEntityRepository extends GraphRepository<UserGraphEntity>{

}
