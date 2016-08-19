package com.developera.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.developera.model.Uyeler;

public class UyelerDAO implements UyelerDaoInterface<Uyeler, String>
{
	private Session currentSession;
	private Transaction currentTransaction;
	
	public UyelerDAO()
	{
		
	} 
	
	public Session openCurrentSession()
	{
		currentSession.getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	public void commit()
	{
		currentTransaction.commit();
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	private static SessionFactory getSessionFactory()
	{	 
		SessionFactory sessionFactory =  new Configuration().configure().buildSessionFactory();
		return sessionFactory ; 
	}
	
	
	public void insert(Uyeler uye) 
	{
		getCurrentSession().save(uye);
	}

	public void update(Uyeler uye)
	{
		getCurrentSession().save(uye);
	}

	public Uyeler findById(String id) 
	{
		Uyeler uye = (Uyeler) getCurrentSession().get(Uyeler.class,Integer.parseInt(id));
		return uye;
	}

	public void delete(Uyeler uye)
	{
		getCurrentSession().delete(uye);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Uyeler> findAll() 
	{ 
		List<Uyeler> uyeler = (List<Uyeler>) getCurrentSession().createQuery("from Uyeler order by uyeId").list();
		return uyeler;
	}

	public void deleteAll()
	{
		List<Uyeler> uyeList = findAll();
		for (Uyeler uye : uyeList) {
			delete(uye);
		}
	}

}
