package cs544.bank;

import java.util.Collection;

import cs544.bank.domain.Account;
import cs544.bank.domain.Customer;
import cs544.bank.domain.AccountEntry;
import cs544.bank.service.AccountService;
import cs544.bank.service.IAccountService;
import jakarta.persistence.EntityManager;


public class App {
	public static void main(String[] args) {
		EntityManager em = EntityManagerHelper.getCurrent();
		em.getTransaction().begin();
		IAccountService accountService = new AccountService();
		// create 2 accounts;
		Account account1 = accountService.createAccount(1263862, "Frank Brown");
		Account account2 = accountService.createAccount(4253892, "John Doe");
		//use account 1;
		accountService.deposit(1263862, 240);
		accountService.deposit(1263862, 529);
		accountService.withdrawEuros(1263862, 230);
		//use account 2;
		accountService.deposit(4253892, 12450);
		accountService.depositEuros(4253892, 200);
		accountService.transferFunds(4253892, 1263862, 100, "payment of invoice 10232");
		// show balances
		em.getTransaction().commit();
		em.close();



		Collection<Account> accountlist = accountService.getAllAccounts();



//		Customer customer = null;
//		for (Account account : accountlist) {
//			customer = account.getCustomer();
//			System.out.println("Statement for Account: " + account.getAccountnumber());
//			System.out.println("Account Holder: " + customer.getName());
//			System.out.println("-Date-------------------------"
//							+ "-Description------------------"
//							+ "-Amount-------------");
//
//			EntityManager em = EntityManagerHelper.getCurrent();
//			em.getTransaction().begin();
//
//			for (AccountEntry entry : account.getEntryList()) {
//
//				System.out.printf("%30s%30s%20.2f\n", entry.getDate()
//						.toString(), entry.getDescription(), entry.getAmount());
//			}
//
//			em.getTransaction().commit();
//			em.close();
//
//			System.out.println("----------------------------------------"
//					+ "----------------------------------------");
//			System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:",
//					account.getBalance());
//		}


	}

}


