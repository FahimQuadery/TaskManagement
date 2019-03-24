package com.fahimsoft.demo2.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class User {
	
	@Id
	@Email
	@NotEmpty
	private String email;
	@NotEmpty
	private String name;
	@Size(min=4)
	private String password;
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Task> tasks;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLES", joinColumns= {
			@JoinColumn(name="USER_EMAIL", referencedColumnName="email")
	}, inverseJoinColumns= {
			@JoinColumn(name="ROLE_NAME", referencedColumnName="name")
	})
	private List<Role> roles;

}
