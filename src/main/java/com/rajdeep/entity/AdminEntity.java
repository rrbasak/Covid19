package com.rajdeep.entity;





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
@Table(name = "ADMIN")
public class AdminEntity {
	@Id
	@Column(length = 10)
	private String id;
	@Column(length = 10)
	private String password;


}
