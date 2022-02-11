package com.mobile.myHealth.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VerifyOTP {

@SerializedName("username")
@Expose
private String username;
@SerializedName("status")
@Expose
private String status;
@SerializedName("phone")
@Expose
private String phone;


public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public String getStatus() { return status; }

public void setStatus(String status) {
	this.status = status;
}

}
