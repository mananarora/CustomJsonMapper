package com.example.demo;

import java.util.LinkedHashMap;
import java.util.List;

public class StarSummary {
	
	private String assignedToId;
	private String assignedToName;
	private List<LinkedHashMap<String, String>> stars;
	
	/**
	 * @return associate id to whom star is assigned
	 */
	public String getAssignedToId() {
		return assignedToId;
	}
	/**
	 * @param assignedTo id is set to the associate who got star
	 */
	public void setAssignedToId(String assignedToId) {
		this.assignedToId = assignedToId;
	}
	/**
	 * @return associate name to whom star is assigned
	 */
	public String getAssignedToName() {
		return assignedToName;
	}
	/**
	 * @param assignedTo name is set to the associate who got star
	 */
	public void setAssignedToName(String assignedToName) {
		this.assignedToName = assignedToName;
	}
	/**
	 * @return ArrayList of HashMap
	 */
	public List<LinkedHashMap<String, String>> getStars() {
		return stars;
	}
	/**
	 * @param ArrayList is assigned
	 */
	public void setStars(List<LinkedHashMap<String, String>> listToStoreAssignedByAndComment) {
		this.stars = listToStoreAssignedByAndComment;
	}
}