package com.rajdeep.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajdeep.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, String>{
	
}
