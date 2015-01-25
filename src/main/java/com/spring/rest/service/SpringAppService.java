package com.spring.rest.service;


import org.json.JSONObject;

import com.spring.rest.model.PcPartsModel;

public interface SpringAppService {

	public int post(PcPartsModel pcPartsModel);
	public JSONObject get(int id);
	public void delete(int id);
}
