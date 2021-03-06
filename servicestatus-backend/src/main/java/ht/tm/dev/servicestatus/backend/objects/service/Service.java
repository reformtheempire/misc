package ht.tm.dev.servicestatus.backend.objects.service;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Service {

	private int key;
	private String name;
	private String hostname;
	private ServiceType serviceType;	
	
	public Service(int key, String name, String hostname, ServiceType serviceType) {
		super();
		this.key = key;
		this.name = name;
		this.hostname = hostname;
		this.serviceType = serviceType;
	}
	
	public int getKey() {
		return key;
	}
	public String getName() {
		return name;
	}
	public String getHostname() {
		return hostname;
	}
	public int getServiceType() {
		return serviceType.getServiceType();
	}

	@Override
	public String toString() {
		return "Service [key=" + key + ", name=" + name + ", hostname=" + hostname + ", serviceType=" + serviceType
				+ "]";
	}
	
	public String toJson() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
	
}
