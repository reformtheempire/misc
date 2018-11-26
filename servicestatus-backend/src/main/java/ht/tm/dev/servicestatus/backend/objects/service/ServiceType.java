package ht.tm.dev.servicestatus.backend.objects.service;

public enum ServiceType {
	COMPUTER(0), SWITCH(1), MISC(2), WEB_SERVER(3), IOT(4), INFRASTRUCTURE(5);

	private final int serviceType;

	ServiceType(int serviceType) {
		this.serviceType = serviceType;
	}

	public int getServiceType() {
		return serviceType;
	}

}
