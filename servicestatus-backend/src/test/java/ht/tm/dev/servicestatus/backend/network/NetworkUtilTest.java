package ht.tm.dev.servicestatus.backend.network;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import ht.tm.dev.servicestatus.backend.objects.service.Service;
import ht.tm.dev.servicestatus.backend.objects.service.ServiceStatus;
import ht.tm.dev.servicestatus.backend.objects.service.ServiceType;

public class NetworkUtilTest {

	@Test
	public void testCheckHostnamesAreOnline() {
		//create arraylist of service
		ArrayList<Service> services = new ArrayList<Service>();
		//create test services
		Service service = new Service(0, "localhost", "localhost", ServiceType.INFRASTRUCTURE);
		Service service2 = new Service(1, "offline address", "10.111.0.1", ServiceType.MISC);
		Service service3 = new Service(2, "Google", "google.com", ServiceType.WEB_SERVER);
		Service service4 = new Service(3, "CSAT", "csat.academy", ServiceType.WEB_SERVER);
		
		//add them to the arraylist
		services.add(service);
		services.add(service2);
		services.add(service3);
		services.add(service4);

		//instantiate our networkutil class
		NetworkUtil nu = new NetworkUtil();

		//get the statuses for our services
		ArrayList<ServiceStatus> statuses = nu.checkHostnamesAreOnline(services);

		//iterate over them and assert we get the correct response
		for (ServiceStatus serviceStatus : statuses) {
			System.out.println(serviceStatus.toString());
			if (serviceStatus.getService().getKey() == service.getKey()) {
				assertTrue(serviceStatus.isOnline());
			} else if (serviceStatus.getService().getKey() == service2.getKey()) {
				assertFalse(serviceStatus.isOnline());
			} else if (serviceStatus.getService().getKey() == service3.getKey()) {
				assertTrue(serviceStatus.isOnline());
			} else if (serviceStatus.getService().getKey() == service4.getKey()) {
				assertTrue(serviceStatus.isOnline());
			}
		}
	}

}
