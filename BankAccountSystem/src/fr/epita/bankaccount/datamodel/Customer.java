package fr.epita.bankaccount.datamodel;

import java.util.List;

public class Customer {

	private String name;
	private String address;
	private List<Account> accounts;
	

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
	public String getName() {
		return name;
	}
	public void setName(String newName) {
		if (newName == null) {
			System.out.println("cannot set null to the customer");
			return;
		}
		name = newName;
	}
	
	
	
	
}
