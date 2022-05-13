package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="users1")
public class UserEntity {
	@Id
	private int id;
	private String username;
	private String password;
	private String roles;

}
