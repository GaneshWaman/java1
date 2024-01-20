package com.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static com.bank.AccountType.*;

public class BankUtil {
	public static List<Bank> getdetails(){
		List <Bank> list = new ArrayList<>();
		
//		String name, double bal, LocalDate opdt, AccountType type
		list.add(new Bank("DDD", 20000, LocalDate.parse("2013-11-12"), CURRENT));
		list.add(new Bank("BBB", 100000, LocalDate.parse("2022-01-12"), SAVING));
		list.add(new Bank("CCC", 100000, LocalDate.parse("2022-01-12"), LOAN));

		return list;
		
	}
}
