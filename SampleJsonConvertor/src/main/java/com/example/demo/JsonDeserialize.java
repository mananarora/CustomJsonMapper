package com.example.demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDeserialize {
	String convert()
	{
		Service service = new Service();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootArray = mapper.valueToTree(service.getStarDetails());
		JsonNode assignedTo= rootArray.get(0).path("assignedTo");
		JsonNode teamNode = assignedTo.path("team");
		String teamName = teamNode.path("team_name").asText();
		System.out.println(teamName);
		for(JsonNode root : rootArray){
			JsonNode starId = root.path("id");
			System.out.println(starId);
			JsonNode nameNode = root.path("assignedTo");
			String name = nameNode.path("name").asText();
			System.out.println(name);
		}
		return null;
	}
}
