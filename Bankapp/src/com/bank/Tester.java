package com.bank;

import static com.bank.AccountType.CURRENT;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bank.BankUtil;

public class Tester {

	public static void main(String[] args) {
		
		List<Bank> lst = BankUtil.getdetails();
		boolean exit = false;
		Scanner sc = new Scanner(System.in);
		
		while(!exit){
			System.out.println("\n1.Display Bank Account \n2.Add Account \n3.Show ac under 4000 \n4.Withdraw money \n5.Credit money \n6.Remove Ac \n7. Sort by Name \n8. Exit");
			
			switch(sc.nextInt()) {
			
			case 1: {
				lst.forEach(s-> System.out.println(s));
				break;
			}
			case 2:{
				System.out.println("name,balanace,date,ac type,");
//				String name, double bal, LocalDate opdt, AccountType type
				lst.add(new Bank(sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()), AccountType.valueOf(sc.next().toUpperCase())));
				break;	
			}
			case 3:{
				lst.stream().filter(b->b.getBal()>40000).forEach(System.out::println);
				break;
			}
			case 4:{
				System.out.println("Enter your Account No: ");
				int wd = sc.nextInt();
				System.out.println("Enter Withdraw Amount");
				int wdamt = sc.nextInt();
				Iterator<Bank> bkw = lst.iterator();
				while (bkw.hasNext()) {
					Bank bkw1 = bkw.next();
					if (bkw1.getAcno() == wd) {
						if (bkw1.getBal() > wdamt) {
							bkw1.setBal(bkw1.getBal() - wdamt);
							System.out.printf("Amount %d Debited Successfully.", wdamt);
						}
						else System.out.println("Insufficient Balance.");	
					}
				}
				break;
			}
			case 5:{
				// Credit Amount
				System.out.println("Enter your Account No: ");
				int cr = sc.nextInt();
				System.out.println("Enter Credit Amount");
				int cramt = sc.nextInt();
				Iterator<Bank> bkc = lst.iterator();
				while (bkc.hasNext()) {
					Bank bkc1 = bkc.next();
					if (bkc1.getAcno() == cr) {
						bkc1.setBal(bkc1.getBal() + cramt);
						System.out.printf("Amount %d Credited Successfully.", cramt);
					}
				}
				break;
			}
			case 6://Remove Acc
			{
				System.out.print("Enter Acc no to delete Acc: ");
				int del = sc.nextInt();

				Iterator<Bank> bk = lst.iterator();
				int cnt = 0;
				while (bk.hasNext()) {
					Bank acc = bk.next();
					if (acc.getAcno() == del) {
						bk.remove();
						System.out.println("Account Deleted.");
						cnt++;
					}
				}
				if (cnt == 0) System.err.println("Account Not Present");
				break;
			}
			case 7://sort by Name
			{
				lst.sort(Comparator.comparing(Bank::getName));
				break;
			}
			case 8://exit
				exit = true;
			}
		}
	}

}
