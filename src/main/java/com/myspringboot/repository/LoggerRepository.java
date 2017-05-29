package com.myspringboot.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.myspringboot.entity.LoggerEntity;

@Repository
public interface LoggerRepository extends JpaRepository<LoggerEntity, Long>, JpaSpecificationExecutor<LoggerEntity>, Serializable{

}
