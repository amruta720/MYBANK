package com.model;

public class NEFTModel {
	
	private String Acc_No;
	private String Benef_Name;
	private String BenefAccNo;
	private String IFSCcode;
	private long Amount;
	private String date;

	public NEFTModel(){

}
	public String getIFSCcode() {
		return IFSCcode;
	}
	public void setIFSCcode(String iFSCcode) {
		IFSCcode = iFSCcode;
	}
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	public String getAcc_No() {
		return Acc_No;
	}
	public void setAcc_No(String acc_No) {
		Acc_No = acc_No;
	}
	public String getBenef_Name() {
		return Benef_Name;
	}
	public void setBenef_Name(String benef_Name) {
		Benef_Name = benef_Name;
	}
	public String getBenefAccNo() {
		return BenefAccNo;
	}
	public void setBenefAccNo(String benefAccNo) {
		BenefAccNo = benefAccNo;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}