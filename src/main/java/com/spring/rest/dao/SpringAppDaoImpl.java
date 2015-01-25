package com.spring.rest.dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.model.PcPartsModel;

@Repository
public class SpringAppDaoImpl implements SpringAppDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public int post(PcPartsModel pcPartsModel) {
//		  Session session =sessionFactory.openSession();
//		  session.beginTransaction();
//		  session.save(pcPartsModel);
//		  session.getTransaction().commit();
//		  session.close();
//		
			sessionFactory.openSession().save(pcPartsModel);
		  System.out.println("Inside dao");
		return 1;
		
	}
	
	public PcPartsModel get(int id) {
		PcPartsModel pcPartsModel=(PcPartsModel) sessionFactory.openSession().get(PcPartsModel.class,id);
		return pcPartsModel;
	}

	public void delete(int id) {
		PcPartsModel pcPartsModel=(PcPartsModel) sessionFactory.openSession().get(PcPartsModel.class,id);
		sessionFactory.openSession().delete(pcPartsModel);
	}

}
