package com.rajdeep.service;

import java.util.List;

import com.rajdeep.vo.Admin;
import com.rajdeep.vo.User;
import com.rajdeep.vo.UserDetails;


public interface UserRegistrationService {
	public void insertdatauser(User u);
	public void insertdatauserDetails(UserDetails ud);
	public List<UserDetails> getAllUser();
	public int checker(User u);
	public Boolean deleteUser(String addharno);
	public UserDetails findUserId(String addharno);
	public void setVacDate(UserDetails ud);
	public int checker2(Admin a);
	public List<Object[]> getAllUserforadmin();
	public List<Object[]> findUserIdforadmin(String userid);
	
}
