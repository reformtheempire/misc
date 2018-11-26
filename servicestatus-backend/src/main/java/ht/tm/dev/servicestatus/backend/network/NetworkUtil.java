package ht.tm.dev.servicestatus.backend.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import ht.tm.dev.servicestatus.backend.objects.service.Service;
import ht.tm.dev.servicestatus.backend.objects.service.ServiceStatus;

public class NetworkUtil {

	public ArrayList<ServiceStatus> checkHostnamesAreOnline(ArrayList<Service> services) {

		ArrayList<ServiceStatus> statuses = new ArrayList<ServiceStatus>();

		for (Service service : services) {
			statuses.add(new ServiceStatus(service, isOnline(service.getHostname())));
		}

		return statuses;
	}

	private boolean isOnline(String hostname) {
		try {
			if (InetAddress.getByName(hostname).isReachable(1000)) {
				return true;
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
