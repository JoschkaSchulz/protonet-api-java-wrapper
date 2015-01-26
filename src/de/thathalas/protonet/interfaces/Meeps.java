package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.Meep;

/**
 * The Me class represents the Meeps REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Meeps {
	private ProtonetWrapper protonet;
	
	public Meeps(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public List<Meep> indexTopics(int topicId) {
		List<Meep> list = new ArrayList<Meep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/topics/" + topicId + "/meeps")).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(Meep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<Meep> indexProjects(int projectId) {
		List<Meep> list = new ArrayList<Meep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/projects/" + projectId + "/meeps")).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(Meep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<Meep> indexPrivateChats(int privateChatsId) {
		List<Meep> list = new ArrayList<Meep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/private_chats/" + privateChatsId + "/meeps")).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(Meep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public Meep createTopics(int topicId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return Meep.createMeep(protonet.post("/api/v1/topics/" + topicId + "/meeps", data));
	}
	
	public Meep createProjects(int projectId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return Meep.createMeep(protonet.post("/api/v1/projects/" + projectId + "/meeps", data));
	}
	
	public Meep createPrivateChats(int privateChatId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return Meep.createMeep(protonet.post("/api/v1/private_chats/" + privateChatId + "/meeps", data));
	}
	
	public Meep showTopics(int projectId, int meepId) {
		return Meep.createMeep(protonet.get("/api/v1/topics/" + projectId + "/meeps/" + meepId));
	}
	
	public Meep showProjects(int topicId, int meepId) {
		return Meep.createMeep(protonet.get("/api/v1/projects/" + topicId + "/meeps/" + meepId));
	}
	
	public Meep showPrivateChats(int privateChatId, int meepId) {
		return Meep.createMeep(protonet.get("/api/v1/private_chats/" + privateChatId + "/meeps/" + meepId));
	}
}
