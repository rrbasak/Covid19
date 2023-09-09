package com.rajdeep.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.rajdeep.entity.UserDetailsEntity;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetailsEntity, String>{
//	@Query(value = "delete from USERDETAILSENTITY where addharno=:v_addharno",nativeQuery = true)
//	public void delete(String v_addharno);

}
