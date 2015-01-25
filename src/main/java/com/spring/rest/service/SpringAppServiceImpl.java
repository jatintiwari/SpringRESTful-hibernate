package com.spring.rest.service;



import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.rest.dao.SpringAppDAO;
import com.spring.rest.model.PcPartsModel;

@Service
public class SpringAppServiceImpl implements SpringAppService {

	@Autowired
	SpringAppDAO springAppDAO;


	@Transactional
	public int post(PcPartsModel pcPartsModel) {

		int success=springAppDAO.post(pcPartsModel);
		if (success !=0) {
			return pcPartsModel.getPcPartsId();
		} else {
			return 0;
		}
	}

//	@Transactional(value="transactionManager", readOnly=true)
	@Transactional	
	public JSONObject get(int id) {

		JSONObject json= new JSONObject();
		try {
			PcPartsModel pcPartsModel=springAppDAO.get(id);
			json.put("pcPartsId", pcPartsModel.getPcPartsId());
			json.put("pcPartsTitle", pcPartsModel.getPcPartsTitle());
			json.put("pcPartsCode", pcPartsModel.getPcPartsCode());
			json.put("pcPartsMaker", pcPartsModel.getPcPartsMaker());
			json.put("pcPartsAvail", pcPartsModel.getPcPartsAvail());
		} catch (Exception e) {
			System.out.println("Invalid GET request: Service");
		}
		return json;

	}

	public void delete(int id) {
		springAppDAO.delete(id);
	}
}