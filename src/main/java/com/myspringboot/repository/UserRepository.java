package com.myspringboot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myspringboot.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity>, Serializable{

	@Query(value = "select * from user where name = ?", nativeQuery = true)
	public List<UserEntity> findUserByName(String name);
	
	@Modifying
	@Query(value = "delete from user where id = ?", nativeQuery = true)
	public void deleteUserById(String id);

}
