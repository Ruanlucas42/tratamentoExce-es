package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.BusinessException;

public class program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner SC = new Scanner(System.in);
	 
		
		System.out.println("Informe os dados da conta");
		System.out.print("Numero:");
		int number = SC.nextInt();
		System.out.print("Titular:");
		SC.nextLine();
		String holder = SC.nextLine();
		System.out.print("Saldo inicial:");
		double balance = SC.nextDouble();
		System.out.println("Limite de saque:");
		double withdrawLimit = SC.nextDouble();
		
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println();
		System.out.print("Informe a quantia para sacar:");
		double amount = SC.nextDouble();
		
		try{
			account.withdraw(amount);
			System.out.printf("Novo saldo:" + String.format("%.2f", account.getBalance()));
		}
		catch(BusinessException e) {
			System.out.println(e.getMessage());
		}
			
		SC.close();
	}
}
