package com.bank;

import java.time.LocalDate;

public class Bank {
	private int acno;
	private String name;
	private double bal;
	private LocalDate opdt;
	private AccountType type;
	public static int cnt;
	
	static {
		cnt = 1001;
	}
	
	public Bank( String name, double bal, LocalDate opdt, AccountType type) {
		super();
		this.acno = cnt;
		this.name = name;
		this.bal = bal;
		this.opdt = opdt;
		this.type = type;
		cnt++;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public int getAcno() {
		return acno;
	}

	public String getName() {
		return name;
	}

	public LocalDate getOpdt() {
		return opdt;
	}

	public AccountType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Bank [acno=" + acno + ", name=" + name + ", bal=" + bal + ", opdt=" + opdt + ", type=" + type + "]";
	}
	
	
	
	
	
}
