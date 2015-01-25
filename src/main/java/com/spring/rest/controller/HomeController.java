package com.spring.rest.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.google.gson.Gson;
import com.spring.rest.model.PcPartsModel;
import com.spring.rest.service.SpringAppService;

@Controller
@RequestMapping(value=URIconstructor.INVENTORY)
public class HomeController {

	@Autowired
	SpringAppService springAppService;

	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody String post(String incomingdata) {
		PcPartsModel pcPartsModel=null;
		try {
			pcPartsModel = new Gson().fromJson(incomingdata, PcPartsModel.class);
			int success=springAppService.post(pcPartsModel);
			System.out.println("POST: "+success+" "+ new Gson().toJson(pcPartsModel));
		} catch (Exception e) {
			System.out.println("POST Homecontroller Exception");
			e.printStackTrace();
		}
		return (new Gson().toJson(pcPartsModel));
	}

	@RequestMapping(value=URIconstructor.ID,method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody String get(@PathVariable("id") int id) throws Exception {
		JSONObject jsonReturn= null;
		try {
			jsonReturn=springAppService.get(id);
			System.out.println("GET: " + id);
		} catch (Exception e) {
			System.out.println("Invalid GET request:Controller");
			return jsonReturn.toString();
		}
		System.out.println(jsonReturn);
		return jsonReturn.toString();
		
	}
	
	@RequestMapping(value=URIconstructor.ID,method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	public @ResponseBody void delete(@PathVariable("id") int id) throws Exception {
		try {
			System.out.println("DELETE: " + id);
			springAppService.delete(id);
			System.out.println("Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid Delete request:Controller");
		}
	}

}
