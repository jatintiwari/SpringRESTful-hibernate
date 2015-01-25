package com.spring.rest.dao;

import com.spring.rest.model.PcPartsModel;

public interface SpringAppDAO {

	public int post(PcPartsModel pcPartsModel);
	public PcPartsModel get(int id);
	public void delete(int id);
}
