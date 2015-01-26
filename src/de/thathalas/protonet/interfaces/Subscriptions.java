package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.Subscription;

/**
 * The Me class represents the Subscriptions REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Subscriptions {
	private ProtonetWrapper protonet;
	
	public Subscriptions(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public Subscription showTopics(int topicId, int subscriptionId) {
		return Subscription.createSubscription(
				protonet.get("/api/v1/topics/" + topicId +"/subscriptions/" + subscriptionId));
	}
	
	public Subscription showProjects(int projectId, int subscriptionId) {
		return Subscription.createSubscription(
				protonet.get("/api/v1/projects/" + projectId +"/subscriptions/" + subscriptionId));
	}
	
	public Subscription showPrivateChats(int privateChatId, int subscriptionId) {
		return Subscription.createSubscription(
				protonet.get("/api/v1/private_chats/" + privateChatId +"/subscriptions/" + subscriptionId));
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
