package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.ProtonetProject;

/**
 * The Me class represents the Projects REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Projects {
	private ProtonetWrapper protonet;
	
	public Projects(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public List<ProtonetProject> index() {
		List<ProtonetProject> list = new ArrayList<ProtonetProject>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/projects")).getJSONArray("projects");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetProject.createProject(array.getJSONObject(i)));
		}
		return list;
	}
	
	public ProtonetProject create(String name) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("name", name));
		return ProtonetProject.createProject(protonet.post("/api/v1/projects", data));
	}
	
	public ProtonetProject show(int projectId) {
		return ProtonetProject.createProject(protonet.get("/api/v1/projects/" + projectId));
	}
}
