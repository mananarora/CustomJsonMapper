package com.example.demo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	Service service = new Service();
	JsonConversion con = new JsonConversion();
	
	@RequestMapping("/getTeamDetails")
	List<Team> getTeamDetails()
	{
		return service.getTeamDetails();
	}
	
	@RequestMapping("/getAssociateDetails")
	List<Associate> getAssociateDetails()
	{
		return service.getAssociateDetails();
	}
	
	@RequestMapping("/getStarDetails")
	String getStarDetails() throws IOException
	{
		JsonConversion c =  new JsonConversion();
		return c.convert();
		//return service.getStarDetails();
	}
}
