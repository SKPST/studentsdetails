package com.sachin.Student.endpoint;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Endpoint(id="sachin", enableByDefault = true)
@Component
public class MyEndPoint {

	@ReadOperation
	public MyEndPointResponse response() {
		return new MyEndPointResponse(252525, "Sachin tomar", "Active its working properly");
	}
}

@Getter
@Setter
@AllArgsConstructor
class MyEndPointResponse {
	private int id;
	private String name;
	private String status;
}
