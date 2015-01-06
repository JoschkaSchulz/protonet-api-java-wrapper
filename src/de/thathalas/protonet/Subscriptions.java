package de.thathalas.protonet;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

public class Subscriptions {
	private ProtonetWrapper protonet;
	
	public Subscriptions(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public String showTopics(int topicId, int subscriptionId) {
		return protonet.get("/api/v1/topics/" + topicId +"/subscriptions/" + subscriptionId);
	}
	
	public String showProjects(int projectId, int subscriptionId) {
		return protonet.get("/api/v1/projects/" + projectId +"/subscriptions/" + subscriptionId);
	}
	
	public String showPrivateChats(int privateChatId, int subscriptionId) {
		return protonet.get("/api/v1/private_chats/" + privateChatId +"/subscriptions/" + subscriptionId);
	}
	
	public String updateTopics(int topicId, int subscriptionId) {
		List<BasicNameValuePair> data = new ArrayList<>();
		return protonet.patch("/api/v1/topics/" + topicId +"/subscriptions/" + subscriptionId, data);
	}
	
	public String updateProjects(int projectId, int subscriptionId) {
		List<BasicNameValuePair> data = new ArrayList<>();
		return protonet.patch("/api/v1/projects/" + projectId +"/subscriptions/" + subscriptionId, data);
	}
	
	public String updatePrivateChats(int privateChatId, int subscriptionId) {
		List<BasicNameValuePair> data = new ArrayList<>();
		return protonet.patch("/api/v1/private_chats/" + privateChatId +"/subscriptions/" + subscriptionId, data);
	}
}
