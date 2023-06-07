package cs544.bank.dao;

import cs544.bank.EntityManagerHelper;
import cs544.bank.domain.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Collection;
import java.util.List;

public class JPAAccountDAO implements IAccountDAO{
    public void saveAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.persist(account);
    }
    public void updateAccount(Account account) {
        EntityManager em = EntityManagerHelper.getCurrent();
        em.merge(account);
    }
    public Account loadAccount(long accountnumber) {
        EntityManager em = EntityManagerHelper.getCurrent();
        return em.find(Account.class, accountnumber);
    }
    public Collection<Account> getAccounts() {
        EntityManager em = EntityManagerHelper.getCurrent();

        TypedQuery<Account> query = em.createQuery("from Account ", Account.class);
        return query.getResultList();
    }
}
