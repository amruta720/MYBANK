package com.model;

import org.apache.commons.fileupload.FileItem;

public class CreateAccountModel {
	private String Customer_Name;
	private String Customer_Fathers_Name;
	private String Date_Of_Birth;
	private String Gender;
	private String Nationality;
	private String Mobile_No;
	private String Email_Id;
	
	private String Local_Address;
	private String Permanent_Address;
	private String State;
	private String City;		
	private String Pincode;
	
	private String Aadhar_No;
	private String PanCard_No;
	
    FileItem AadharCardDocument ;
    FileItem PanCardDocument ;
    FileItem ElectricityBillDocument ;
    FileItem IncomeCertificateDocument ;
    FileItem PassportphotoDocument ;
    FileItem SignDocument ;
    
	private byte[] image;  
	private String base64AadharCardDocument;
	private String base64PanCardDocument ;
	private String base64ElectricityBillDocument ;
	private String base64IncomeCertificateDocument ;
	private String base64PassportphotoDocument ;
	private String base64SignDocument ;
	

	
	public CreateAccountModel(){
		
	}

	public String getEmail_Id() {
		return Email_Id;
	}

	public void setEmail_Id(String email_Id) {
		Email_Id = email_Id;
	}

	public String getCustomer_Name() {
		return Customer_Name;
	}

	public void setCustomer_Name(String customer_Name) {
		Customer_Name = customer_Name;
	}

	public String getCustomer_Fathers_Name() {
		return Customer_Fathers_Name;
	}

	public void setCustomer_Fathers_Name(String customer_Fathers_Name) {
		Customer_Fathers_Name = customer_Fathers_Name;
	}

	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}

	public void setDate_Of_Birth(String date_Of_Birth) {
		Date_Of_Birth = date_Of_Birth;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getNationality() {
		return Nationality;
	}

	public void setNationality(String nationality) {
		Nationality = nationality;
	}

	public String getAadhar_No() {
		return Aadhar_No;
	}

	public void setAadhar_No(String aadhar_No) {
		Aadhar_No = aadhar_No;
	}

	public String getPanCard_No() {
		return PanCard_No;
	}

	public void setPanCard_No(String panCard_No) {
		PanCard_No = panCard_No;
	}

	public String getLocal_Address() {
		return Local_Address;
	}

	public void setLocal_Address(String local_Address) {
		Local_Address = local_Address;
	}

	public String getPermanent_Address() {
		return Permanent_Address;
	}

	public void setPermanent_Address(String permanent_Address) {
		Permanent_Address = permanent_Address;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public String getPincode() {
		return Pincode;
	}

	public void setPincode(String pincode) {
		Pincode = pincode;
	}

	public String getMobile_No() {
		return Mobile_No;
	}

	public void setMobile_No(String mobile_No) {
		Mobile_No = mobile_No;
	}

	public FileItem getAadharCardDocument() {
		return AadharCardDocument;
	}

	public void setAadharCardDocument(FileItem aadharCardDocument) {
		AadharCardDocument = aadharCardDocument;
	}

	public FileItem getPanCardDocument() {
		return PanCardDocument;
	}

	public void setPanCardDocument(FileItem panCardDocument) {
		PanCardDocument = panCardDocument;
	}

	public FileItem getElectricityBillDocument() {
		return ElectricityBillDocument;
	}

	public void setElectricityBillDocument(FileItem electricityBillDocument) {
		ElectricityBillDocument = electricityBillDocument;
	}

	public FileItem getIncomeCertificateDocument() {
		return IncomeCertificateDocument;
	}

	public void setIncomeCertificateDocument(FileItem incomeCertificateDocument) {
		IncomeCertificateDocument = incomeCertificateDocument;
	}

	public FileItem getPassportphotoDocument() {
		return PassportphotoDocument;
	}

	public void setPassportphotoDocument(FileItem passportphotoDocument) {
		PassportphotoDocument = passportphotoDocument;
	}

	public FileItem getSignDocument() {
		return SignDocument;
	}

	public void setSignDocument(FileItem signDocument) {
		SignDocument = signDocument;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getBase64AadharCardDocument() {
		return base64AadharCardDocument;
	}

	public void setBase64AadharCardDocument(String base64AadharCardDocument) {
		this.base64AadharCardDocument = base64AadharCardDocument;
	}

	public String getBase64PanCardDocument() {
		return base64PanCardDocument;
	}

	public void setBase64PanCardDocument(String base64PanCardDocument) {
		this.base64PanCardDocument = base64PanCardDocument;
	}

	public String getBase64ElectricityBillDocument() {
		return base64ElectricityBillDocument;
	}

	public void setBase64ElectricityBillDocument(String base64ElectricityBillDocument) {
		this.base64ElectricityBillDocument = base64ElectricityBillDocument;
	}

	public String getBase64IncomeCertificateDocument() {
		return base64IncomeCertificateDocument;
	}

	public void setBase64IncomeCertificateDocument(String base64IncomeCertificateDocument) {
		this.base64IncomeCertificateDocument = base64IncomeCertificateDocument;
	}

	public String getBase64PassportphotoDocument() {
		return base64PassportphotoDocument;
	}

	public void setBase64PassportphotoDocument(String base64PassportphotoDocument) {
		this.base64PassportphotoDocument = base64PassportphotoDocument;
	}

	public String getBase64SignDocument() {
		return base64SignDocument;
	}

	public void setBase64SignDocument(String base64SignDocument) {
		this.base64SignDocument = base64SignDocument;
	}

}
