package com.spring.rest.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.rest.dao.SpringAppDAO;
import com.spring.rest.model.PcPartsModel;

@Service
public class SpringAppServiceImpl implements SpringAppService {

	@Autowired
	SpringAppDAO springAppDAO;

	@Transactional
	public int post(PcPartsModel pcPartsModel) {

		int success=springAppDAO.post(pcPartsModel);
		if (pcPartsModel.getPcPartsId()==success) {
			return 1;
		} else {
			return 0;
		}
	}
}