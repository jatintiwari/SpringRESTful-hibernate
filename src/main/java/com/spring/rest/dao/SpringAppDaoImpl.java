package com.spring.rest.dao;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.rest.model.PcPartsModel;

@Repository
public class SpringAppDaoImpl implements SpringAppDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public int post(PcPartsModel pcPartsModel) {
		  sessionFactory.openSession().save(pcPartsModel);
		  System.out.println("dao");
		return 1;
		
	}

}
