package ht.tm.dev.servicestatus.backend.network;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import ht.tm.dev.servicestatus.backend.objects.service.Service;
import ht.tm.dev.servicestatus.backend.objects.service.ServiceStatus;
import ht.tm.dev.servicestatus.backend.objects.service.ServiceType;
import ht.tm.dev.servicestatus.backend.util.network.NetworkUtil;

public class NetworkUtilTest {

	/**
	 * 
	 */
	@Test
	public void testCheckHostnamesAreOnline() {
		JsonReader reader;

		ArrayList<Service> services = new ArrayList<Service>();
		try {
			reader = new JsonReader(new FileReader("src/test/resources/services.txt"));
			Service[] serviceArray = new Gson().fromJson(reader, Service[].class);
			services = new ArrayList<Service>(Arrays.asList(serviceArray));
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		// create test services
		Service service = new Service(0, "localhost", "localhost", ServiceType.INFRASTRUCTURE);
		Service service2 = new Service(1, "offline address", "10.111.0.1", ServiceType.MISC);
		Service service3 = new Service(2, "Google", "google.com", ServiceType.WEB_SERVER);
		Service service4 = new Service(3, "CSAT", "csat.academy", ServiceType.WEB_SERVER);

		// output to JSON using GSON
		// System.out.println(gson.toJsonTree(services));

		// instantiate our networkutil class
		NetworkUtil nu = new NetworkUtil();

		// get the statuses for our services
		ArrayList<ServiceStatus> statuses = nu.checkHostnamesAreOnline(services);

		// iterate over them and assert we get the correct response
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
