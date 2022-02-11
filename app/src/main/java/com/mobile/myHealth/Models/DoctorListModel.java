package com.mobile.myHealth.Models;

public class DoctorListModel {
	int doctorAvatar;
	String doctorName;
	String doctorTitle;

public DoctorListModel(int doctorAvatar, String doctorName, String doctorTitle) {
	this.doctorAvatar = doctorAvatar;
	this.doctorName = doctorName;
	this.doctorTitle = doctorTitle;
}

public int getDoctorAvatar() {
	return doctorAvatar;
}

public void setDoctorAvatar(int doctorAvatar) {
	this.doctorAvatar = doctorAvatar;
}

public String getDoctorName() {
	return doctorName;
}

public void setDoctorName(String doctorName) {
	this.doctorName = doctorName;
}

public String getDoctorTitle() {
	return doctorTitle;
}

public void setDoctorTitle(String doctorTitle) {
	this.doctorTitle = doctorTitle;
}
}
