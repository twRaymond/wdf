package com.wdf.common.model;

import java.util.Date;

public class Users {
	private String keyId;
	private String accountId;
	private String password;
	private String firstName;
	private String middleName;
	private String isValid;
	private String accountState;
	private Date onDate;
	private Date offDate;
	public String getKeyId() {
		return keyId;
	}
	public void setKeyId(String keyId) {
		this.keyId = keyId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getIsValid() {
		return isValid;
	}
	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}
	public String getAccountState() {
		return accountState;
	}
	public void setAccountState(String accountState) {
		this.accountState = accountState;
	}
	public Date getOnDate() {
		return onDate;
	}
	public void setOnDate(Date onDate) {
		this.onDate = onDate;
	}
	public Date getOffDate() {
		return offDate;
	}
	public void setOffDate(Date offDate) {
		this.offDate = offDate;
	}
}
