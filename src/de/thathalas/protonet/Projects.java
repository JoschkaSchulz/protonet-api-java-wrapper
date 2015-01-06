package de.thathalas.protonet;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

public class Projects {
	private ProtonetWrapper protonet;
	
	public Projects(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public String index() {
		return protonet.get("/api/v1/projects");
	}
	
	public String create(String name) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("name", name));
		return protonet.post("/api/v1/projects", data);
	}
	
	public String show(int projectId) {
		return protonet.get("/api/v1/projects/" + projectId);
	}
}
