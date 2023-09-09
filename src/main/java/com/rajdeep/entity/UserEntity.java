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
@Table(name = "USERENTITY")
public class UserEntity {
	@Id
	@Column(length = 10)
	private String userid;

	@Column(length = 50)
	private String password;
	@Column(length = 25)
	private String email;
//	@OneToOne
//	@JoinColumn(name = "AddharNo")
//	UserDetailsEntity userdetailsentity;
}
