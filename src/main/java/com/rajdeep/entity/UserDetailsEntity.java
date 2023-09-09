package com.rajdeep.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USERDETAILSENTITY")
public class UserDetailsEntity {
	@Id
	@Column(length = 10)
	private String addharno;
	@Column(length = 25)
	private String name;
	@Column(length = 10)
	private String age;
	@Column(length = 10)
	private String gender;
	private LocalDate vacdate;
	@Column(length = 15)
	private String state;
	

}
