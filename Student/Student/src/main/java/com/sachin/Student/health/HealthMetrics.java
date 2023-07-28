package com.sachin.Student.health;

import java.net.URL;
import java.net.URLConnection;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthMetrics implements HealthIndicator{

	@Override
	public Health health() {
		
		Health health = null;
		health = checkInternetConnection()==true?Health.up().withDetail("success", "Active Internet Connection").build()
												:Health.down().withDetail("Failed", "InActive Internet").build();
		return health;
	}
	
	private boolean checkInternetConnection() {
		boolean flag = false;
		try {
		URL url = new URL("http://www.google.com");
		URLConnection connection = url.openConnection();
		connection.connect();
		flag = true;
				
		}catch(Exception e) {
			flag= false;
		}
		return flag;
	}

}
