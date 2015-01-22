package com.spring.rest;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.rest.dao.SpringAppDAO;
import com.spring.rest.model.PcPartsModel;
import com.spring.rest.service.SpringAppService;


@Controller
public class HomeController {
	
	@Autowired
	PcPartsModel pcPartsModel;
	
	@Autowired
	SpringAppService springAppService;

	@RequestMapping("/{type}")
	public String index(@PathVariable("type") String type){
		System.out.println(type);
		if(type.equalsIgnoreCase("postit")){
			return "postit";
		}
		return "postit";
	}
	
	@POST
	@RequestMapping(value="/v1/inventory")
	@Consumes(MediaType.APPLICATION_JSON)
	public String post(String incomingdata){
		System.out.println(incomingdata);
		
		ObjectMapper mapper= new ObjectMapper();
		try {
			pcPartsModel=mapper.readValue(incomingdata,PcPartsModel.class);
			springAppService.post(pcPartsModel);
			System.out.println(pcPartsModel.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}
	
}
