package com.rajdeep.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class AllUtils {
	public static String passwordencoder(String plainPassword) {
		PasswordEncoder passwordencode=new BCryptPasswordEncoder();
		return passwordencode.encode(plainPassword);
		
	}
}
