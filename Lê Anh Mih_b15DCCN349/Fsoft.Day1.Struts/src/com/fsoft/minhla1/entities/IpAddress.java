package com.fsoft.minhla1.entities;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.HashMap;

public class IpAddress implements Serializable{
	private int id;
	private String ip;
	private LocalTime time;
	private HashMap<String, String> listIP;
	
	public IpAddress() {
		listIP = new HashMap<String,String>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public HashMap<String, String> getListIP() {
		return listIP;
	}

	public void setListIP(HashMap<String, String> listIP) {
		this.listIP = listIP;
	}
	
	public void addIP(String ip, String time) {
		if(listIP.containsKey(ip)) {
			listIP.replace(ip, time);
		}else {
			listIP.put(ip,time);
		}
		this.id+=1;
		System.out.println(id+":"+ip+"---"+time);
	}

	
}
	
