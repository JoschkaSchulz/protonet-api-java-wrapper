package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.Project;

/**
 * The Me class represents the Projects REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Projects {
	private ProtonetWrapper protonet;
	
	public Projects(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public List<Project> index() {
		List<Project> list = new ArrayList<Project>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/projects")).getJSONArray("projects");
		for(int i = 0; i < array.length(); i++) {
			list.add(Project.createProject(array.getJSONObject(i)));
		}
		return list;
	}
	
	public Project create(String name) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("name", name));
		return Project.createProject(protonet.post("/api/v1/projects", data));
	}
	
	public Project show(int projectId) {
		return Project.createProject(protonet.get("/api/v1/projects/" + projectId));
	}
}
