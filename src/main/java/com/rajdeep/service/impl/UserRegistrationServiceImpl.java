package com.rajdeep.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajdeep.entity.AdminEntity;
import com.rajdeep.entity.UserDetailsEntity;
import com.rajdeep.entity.UserEntity;
import com.rajdeep.repo.UserDetailsRepo;
import com.rajdeep.repo.UserRepo;
import com.rajdeep.service.UserRegistrationService;

import com.rajdeep.vo.Admin;
import com.rajdeep.vo.User;
import com.rajdeep.vo.UserDetails;

import com.rajdeep.repo.*;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {
	@Autowired
	UserRepo urepo;
	@Autowired
	UserDetailsRepo udrepo;
	@Autowired
	AdminRepo arepo;

	@Override
	public void insertdatauser(User u) {
		System.out.println("hi");

		UserEntity ue = new UserEntity();
		ue.setUserid(u.getUserid());
		ue.setEmail(u.getEmail());//AllUtils.passwordencoder(u.getPassword())
		ue.setPassword(u.getPassword());
		System.out.println(ue);

		urepo.save(ue);

	}

	@Override
	public List<UserDetails> getAllUser() {
		List<UserDetailsEntity> userde = udrepo.findAll();
		List<UserDetails> uList = new ArrayList<>();

		for (UserDetailsEntity uEntity : userde) {
			UserDetails u = new UserDetails(uEntity.getName(), uEntity.getAge(), uEntity.getGender(),
					uEntity.getAddharno(), uEntity.getVacdate().toString(), uEntity.getState());
			uList.add(u);

		}

		return uList;

	}

	@Override
	public List<Object[]> getAllUserforadmin() {
		List<UserEntity> user = urepo.findAll();
		System.out.println(user);
		List<Object[]> uList = new ArrayList<>();

		for (UserEntity uEntity : user) {
			Object[] u = new Object[] { uEntity.getUserid(), uEntity.getEmail() };
			uList.add(u);

		}
		uList.stream().map(o -> o[0] + "==>" + o[1]).forEach(System.out::println);

		return uList;

	}

	@Override
	public void insertdatauserDetails(UserDetails ud) {
		UserDetailsEntity u = new UserDetailsEntity();

		u.setAge(ud.getAge());
		u.setGender(ud.getGender());
		u.setName(ud.getName());
		u.setAddharno(ud.getAddharno());
		u.setVacdate(LocalDate.parse(ud.getVacdate()));
		u.setState(ud.getState());

		udrepo.save(u);

	}

	// 1-->user,2-->null
	@Override
	public int checker(User u) {
		Optional<UserEntity> userEntityOpt = urepo.findById(u.getUserid());

		if (userEntityOpt.isPresent()) {
			// User found, return 1 or perform additional checks
			return 1;
		} else {
			// User not found, return 2
			return 2;
		}
	}

	@Override
	public Boolean deleteUser(String addharno) {
		udrepo.deleteById(addharno);
		return true;
	}

	@Override
	public UserDetails findUserId(String addharno) {
		UserDetails ud = null;
		Optional<UserDetailsEntity> ude = udrepo.findById(addharno);

		if (!ude.isEmpty()) {
			ud = new UserDetails(ude.get().getName(), ude.get().getAge(), ude.get().getGender(),
					ude.get().getAddharno(), ude.get().getVacdate().toString(), ude.get().getState());

		}

		return ud;
	}

	@Override
	public List<Object[]> findUserIdforadmin(String userid) {

		Optional<UserEntity> ue = urepo.findById(userid);
		List<Object[]> ulist = new ArrayList<>();
		if (!ue.isEmpty()) {

			Object[] u1 = new Object[] { ue.get().getUserid(), ue.get().getEmail() };
			ulist.add(u1);

		}

		return ulist;
	}

	@Override
	public void setVacDate(UserDetails ud) {
		System.out.println("Here4" + ud);
		Optional<UserDetailsEntity> ude = udrepo.findById(ud.getAddharno());
		ude.get().setVacdate(LocalDate.parse(ud.getVacdate()));
		udrepo.save(ude.get());

	}

	@Override
	public int checker2(Admin a) {

		Optional<AdminEntity> adminentity = arepo.findById(a.getId());
		if (adminentity.isPresent()) {
			return 1;
		}

		else {
			return 2;
		}
	}
	
	
	
}
