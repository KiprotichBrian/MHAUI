package com.mobile.myHealth.Models;

public class ServicesModel {
	int service_img;
	String service_name;

public ServicesModel(int service_img, String service_name) {
	this.service_img = service_img;
	this.service_name = service_name;
}

public int getService_img() {
	return service_img;
}

public void setService_img(int service_img) {
	this.service_img = service_img;
}

public String getService_name() {
	return service_name;
}

public void setService_name(String service_name) {
	this.service_name = service_name;
}
}
