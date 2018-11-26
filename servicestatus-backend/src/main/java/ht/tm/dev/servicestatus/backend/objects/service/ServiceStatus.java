package ht.tm.dev.servicestatus.backend.objects.service;

public class ServiceStatus {

	private Service service;
	private boolean isOnline;

	public ServiceStatus(Service service, boolean isOnline) {
		super();
		this.service = service;
		this.isOnline = isOnline;
	}

	public Service getService() {
		return service;
	}

	public boolean isOnline() {
		return isOnline;
	}

	@Override
	public String toString() {
		return "ServiceStatus [service=" + service + ", isOnline=" + isOnline + "]";
	}

}
