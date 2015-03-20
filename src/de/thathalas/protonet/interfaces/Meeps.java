package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.ProtonetMeep;

/**
 * The Me class represents the Meeps REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Meeps {
	private ProtonetWrapper protonet;
	
	public Meeps(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public List<ProtonetMeep> indexTopics(int topicId, int limit) {
		List<ProtonetMeep> list = new ArrayList<ProtonetMeep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/topics/" + topicId + "/meeps?limit="+limit)).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetMeep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<ProtonetMeep> indexTopics(int topicId) {
		List<ProtonetMeep> list = new ArrayList<ProtonetMeep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/topics/" + topicId + "/meeps")).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetMeep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<ProtonetMeep> indexProjects(int projectId, int limit) {
		List<ProtonetMeep> list = new ArrayList<ProtonetMeep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/projects/" + projectId + "/meeps?limit="+limit)).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetMeep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<ProtonetMeep> indexProjects(int projectId) {
		List<ProtonetMeep> list = new ArrayList<ProtonetMeep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/projects/" + projectId + "/meeps")).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetMeep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<ProtonetMeep> indexPrivateChats(int privateChatsId, int limit) {
		List<ProtonetMeep> list = new ArrayList<ProtonetMeep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/private_chats/" + privateChatsId + "/meeps?limit="+limit)).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetMeep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public List<ProtonetMeep> indexPrivateChats(int privateChatsId) {
		List<ProtonetMeep> list = new ArrayList<ProtonetMeep>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/private_chats/" + privateChatsId + "/meeps")).getJSONArray("meeps");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetMeep.createMeep(array.getJSONObject(i)));
		}
		return list;
	}
	
	public ProtonetMeep createTopics(int topicId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return ProtonetMeep.createMeep(protonet.post("/api/v1/topics/" + topicId + "/meeps", data));
	}
	
	public ProtonetMeep createProjects(int projectId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return ProtonetMeep.createMeep(protonet.post("/api/v1/projects/" + projectId + "/meeps", data));
	}
	
	public ProtonetMeep createPrivateChats(int privateChatId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return ProtonetMeep.createMeep(protonet.post("/api/v1/private_chats/" + privateChatId + "/meeps", data));
	}
	
	public ProtonetMeep showTopics(int projectId, int meepId) {
		return ProtonetMeep.createMeep(protonet.get("/api/v1/topics/" + projectId + "/meeps/" + meepId));
	}
	
	public ProtonetMeep showProjects(int topicId, int meepId) {
		return ProtonetMeep.createMeep(protonet.get("/api/v1/projects/" + topicId + "/meeps/" + meepId));
	}
	
	public ProtonetMeep showPrivateChats(int privateChatId, int meepId) {
		return ProtonetMeep.createMeep(protonet.get("/api/v1/private_chats/" + privateChatId + "/meeps/" + meepId));
	}
}
