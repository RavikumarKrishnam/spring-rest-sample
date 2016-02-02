package com.mtp.domain;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Member {
	@Id
	@NotNull
	@Size(max = 64)
	@Column(name = "userName", nullable = false, updatable = false)
	private String userName;
	
	private String firstName;
	private String lastName;
	private long assetsValue;
	private long debtValue;
	private long incomeValue;
	private long expenseValue;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getAssetsValue() {
		return assetsValue;
	}
	public void setAssetsValue(long assetsValue) {
		this.assetsValue = assetsValue;
	}
	public long getDebtValue() {
		return debtValue;
	}
	public void setDebtValue(long debtValue) {
		this.debtValue = debtValue;
	}
	public long getIncomeValue() {
		return incomeValue;
	}
	public void setIncomeValue(long incomeValue) {
		this.incomeValue = incomeValue;
	}
	public long getExpenseValue() {
		return expenseValue;
	}
	public void setExpenseValue(long expenseValue) {
		this.expenseValue = expenseValue;
	}
	@Override
	public String toString() {
		return "Member [firstName=" + firstName + ", lastName=" + lastName + ", userName=" + userName + ", assetsValue="
				+ assetsValue + ", debtValue=" + debtValue + ", incomeValue=" + incomeValue + ", expenseValue="
				+ expenseValue + "]";
	}
	public Member() {
		super();
	}
	public Member(String firstName, String lastName, String userName, long assetsValue, long debtValue,
			long incomeValue, long expenseValue) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.assetsValue = assetsValue;
		this.debtValue = debtValue;
		this.incomeValue = incomeValue;
		this.expenseValue = expenseValue;
	}

}
