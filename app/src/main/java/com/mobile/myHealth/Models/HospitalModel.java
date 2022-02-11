package com.mobile.myHealth.Models;

public class HospitalModel {
	String HospitalName;
	String HospitalLocation;
	String NoReviews;
	int HospitalImage;
	String Ratings;

public HospitalModel(String hospitalName, String hospitalLocation, String noReviews, int hospitalImage, String ratings) {
	HospitalName = hospitalName;
	HospitalLocation = hospitalLocation;
	NoReviews = noReviews;
	HospitalImage = hospitalImage;
	Ratings = ratings;
}

public String getHospitalName() {
	return HospitalName;
}

public void setHospitalName(String hospitalName) {
	HospitalName = hospitalName;
}

public String getHospitalLocation() {
	return HospitalLocation;
}

public void setHospitalLocation(String hospitalLocation) {
	HospitalLocation = hospitalLocation;
}

public String getNoReviews() {
	return NoReviews;
}

public void setNoReviews(String noReviews) {
	NoReviews = noReviews;
}

public int getHospitalImage() {
	return HospitalImage;
}

public void setHospitalImage(int hospitalImage) {
	HospitalImage = hospitalImage;
}

public String getRatings() {
	return Ratings;
}

public void setRatings(String ratings) {
	Ratings = ratings;
}
}
