package com.abbas.JobSearchAPI;

import java.util.Arrays;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Job")
public class Job {

	private String desc;
	private String exp;
	private String skills[];
	Job(){
		
	}
	@Override
	public String toString() {
		return "Job [desc=" + desc + ", exp=" + exp + ", skills=" + Arrays.toString(skills) + "]";
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getExp() {
		return exp;
	}
	public void setExp(String exp) {
		this.exp = exp;
	}
	public String[] getSkills() {
		return skills;
	}
	public void setSkills(String[] skills) {
		this.skills = skills;
	}
	
	
}
