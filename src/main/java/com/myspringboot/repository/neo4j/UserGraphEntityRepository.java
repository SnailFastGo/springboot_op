package com.myspringboot.repository.neo4j;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.myspringboot.entity.neo4j.UserGraphEntity;

@Repository
public interface UserGraphEntityRepository extends GraphRepository<UserGraphEntity>{
	
	@Query("match(node) where node.userId = {userId} return node")
	List<UserGraphEntity> findUserByUserId(@Param("userId")String userId);
}
