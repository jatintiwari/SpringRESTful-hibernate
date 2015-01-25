package com.spring.rest.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class PcPartsModel {
	
	@Id
	private int pcPartsId;
	private String pcPartsTitle;
	private String pcPartsCode;
	private String pcPartsMaker;
	private String pcPartsAvail;
	
	
	public int getPcPartsId() {
		return pcPartsId;
	}
	public void setPcPartsId(int pcPartsId) {
		this.pcPartsId = pcPartsId;
	}
	public String getPcPartsTitle() {
		return pcPartsTitle;
	}
	public void setPcPartsTitle(String pcPartsTitle) {
		this.pcPartsTitle = pcPartsTitle;
	}
	public String getPcPartsCode() {
		return pcPartsCode;
	}
	public void setPcPartsCode(String pcPartsCode) {
		this.pcPartsCode = pcPartsCode;
	}
	public String getPcPartsMaker() {
		return pcPartsMaker;
	}
	public void setPcPartsMaker(String pcPartsMaker) {
		this.pcPartsMaker = pcPartsMaker;
	}
	public String getPcPartsAvail() {
		return pcPartsAvail;
	}
	public void setPcPartsAvail(String pcPartsAvail) {
		this.pcPartsAvail = pcPartsAvail;
	}
	@Override
	public String toString(){
		return "Id:"+getPcPartsId()+" Maker: "+getPcPartsMaker();
	}
	
	}
