package com.softgen.apawebapp.model;
import java.util.List;

import javax.persistence.*;
@Entity
@Table(name = "roles")
public class Role{

	

	@Id
    @GeneratedValue(generator = "roles_generator")
    @SequenceGenerator(
            name = "roles_generator",
            sequenceName = "users_generator",
            initialValue = 1000
    )
    private Long id;
	
	
    private String name;
	
	
    private String permessions;
	
	@OneToMany(fetch = FetchType.EAGER )
	@JoinColumn( name = "roleId")
	public List<User> users;
	
	
	public Role() {
		super();
	}
	public Role(String role, String permissions) {
		// TODO Auto-generated constructor stub
		this.name=role;
		this.permessions =permissions;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPermessions() {
		return permessions;
	}
	public void setPermessions(String permessions) {
		this.permessions = permessions;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
}
