package com.rajdeep.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajdeep.entity.AdminEntity;
@Repository
public interface AdminRepo extends JpaRepository<AdminEntity, String>{

}
