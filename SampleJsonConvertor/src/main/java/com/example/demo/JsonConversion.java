package com.example.demo;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonConversion {
	
	String convert() throws IOException
	{
		Service service = new Service();
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonInString = gson.toJson(service.getStarDetails());
		
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootArray = mapper.valueToTree(service.getStarDetails());
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		JsonFactory jfactory = new JsonFactory();
		JsonGenerator jGenerator = jfactory
		  .createGenerator(stream, JsonEncoding.UTF8);
		jGenerator.writeStartObject();
		JsonNode assignedTo= rootArray.get(0).path("assignedTo");
		JsonNode teamNode = assignedTo.path("team");
		String teamName = teamNode.path("team_name").asText();
		jGenerator.writeStringField("name", teamName);
		jGenerator.writeFieldName("members");
		jGenerator.writeStartArray();
		String prev = null;
		for(JsonNode root : rootArray){
			JsonNode assignedToNode = root.path("assignedTo");
			String assignedToId = assignedToNode.path("id").asText();
			String assignedToName = assignedToNode.path("name").asText();
			JsonNode assignedByNode = root.path("assignedBy");
			String assignedById = assignedByNode.path("id").asText();
			String assignedByName = assignedByNode.path("name").asText();
			String comment = root.path("comment").asText();
			if(prev != assignedToId)
			{
				prev = assignedToId;
				jGenerator.writeStartObject();
				jGenerator.writeStringField("AssignedToId", assignedToId) ;
				jGenerator.writeStringField("assignedToName", assignedToName) ;
				jGenerator.writeFieldName("stars");
				jGenerator.writeStartArray();
				jGenerator.writeStartObject();
				jGenerator.writeStringField("AssignedById", assignedById) ;			
				jGenerator.writeStringField("AssignedByName", assignedByName);
				jGenerator.writeStringField("Comment", comment);
				jGenerator.writeEndObject();
				jGenerator.writeEndArray();
				jGenerator.writeEndObject();
			}
			else
			{
				jGenerator.writeStartObject();
				jGenerator.writeStringField("AssignedById", assignedById) ;			
				jGenerator.writeStringField("AssignedByName", assignedByName);
				jGenerator.writeStringField("Comment", comment);
				jGenerator.writeEndObject();
			}
		}
		jGenerator.writeEndArray();
		jGenerator.writeEndObject();
		jGenerator.close();
		String json = new String(stream.toByteArray(), "UTF-8");
		System.out.println(json);
		return json;
	}
}