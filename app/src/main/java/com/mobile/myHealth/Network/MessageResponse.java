package com.mobile.myHealth.Network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessageResponse {

@SerializedName("phone")
@Expose
private String phone;
@SerializedName("username")
@Expose
private String username;
@SerializedName("status")
@Expose
private String status;
@SerializedName("error")
@Expose
private String error;
@SerializedName("message")
@Expose
private String message;
@SerializedName("id")
@Expose
private String id;
@SerializedName("otp_id")
@Expose
private String otp_id;
@SerializedName("email")
@Expose
private String email;
@SerializedName("firstname")
@Expose
private String firstname;
@SerializedName("lastname")
@Expose
private String lastname;
@SerializedName("token")
@Expose
private String token;


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

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getError() {
	return error;
}

public void setError(String error) {
	this.error = error;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getOtp_id() {
	return otp_id;
}

public void setOtp_id(String otp_id) {
	this.otp_id = otp_id;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getFirstname() {
	return firstname;
}

public void setFirstname(String firstname) {
	this.firstname = firstname;
}

public String getLastname() {
	return lastname;
}

public void setLastname(String lastname) {
	this.lastname = lastname;
}

public String getToken() {
	return token;
}

public void setToken(String token) {
	this.token = token;
}
}
