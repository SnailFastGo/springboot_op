package com.myspringboot.entity.neo4j;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
public class UserGraphEntity {

	@GraphId
	private Long id;
	
	private String userId;
	
	private String name;
	
	private String phone;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		int res = 0;
		if(null != id){
			res += id.hashCode();
		}
		if(null != name){
			res += name.hashCode();
		}
		if(null != phone){
			res += phone.hashCode();
		}
	    return res;
	}

	@Override
	public boolean equals( Object o ) {
	    return o instanceof UserGraphEntity && ((UserGraphEntity)o).getId().equals(id);
	}

	@Override
	public String toString() {
	    return "UserGraphEntity[" + "name:" + name  + ", id:" + id + ", phone:" + "phone" + "]";
	}
	
}
