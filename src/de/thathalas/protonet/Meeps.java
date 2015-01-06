package de.thathalas.protonet;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

public class Meeps {
	private ProtonetWrapper protonet;
	
	public Meeps(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public String indexTopics(int topicId) {
		return protonet.get("/api/v1/topics/" + topicId + "/meeps");
	}
	
	public String indexProjects(int projectId) {
		return protonet.get("/api/v1/projects/" + projectId + "/meeps");
	}
	
	public String indexPrivateChats(int privateChatsId) {
		return protonet.get("/api/v1/private_chats/" + privateChatsId + "/meeps");
	}
	
	public String createTopics(int topicId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return protonet.post("/api/v1/topics/" + topicId + "/meeps", data);
	}
	
	public String createProjects(int projectId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return protonet.post("/api/v1/projects/" + projectId + "/meeps", data);
	}
	
	public String createPrivateChats(int privateChatId, String message) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("message", message));
		return protonet.post("/api/v1/private_chats/" + privateChatId + "/meeps", data);
	}
	
	public String showTopics(int projectId, int meepId) {
		return protonet.get("/api/v1/topics/" + projectId + "/meeps/" + meepId);
	}
	
	public String showProjects(int topicId, int meepId) {
		return protonet.get("/api/v1/projects/" + topicId + "/meeps/" + meepId);
	}
	
	public String showPrivateChats(int privateChatId, int meepId) {
		return protonet.get("/api/v1/private_chats/" + privateChatId + "/meeps/" + meepId);
	}
}
