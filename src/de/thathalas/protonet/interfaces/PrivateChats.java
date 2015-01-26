package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;

import de.thathalas.protonet.ProtonetWrapper;

/**
 * The Me class represents the Private Chats REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class PrivateChats {
	private ProtonetWrapper protonet;
	
	public PrivateChats(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public String index() {
		return protonet.get("/api/v1/private_chats");
	}
	
	public String create(int otherUserId) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("other_user_id", otherUserId + ""));
		return protonet.post("/api/v1/private_chats", data);
	}
	
	public String show(int userId) {
		return protonet.get("/api/v1/private_chats/" + userId);
	}
	
	public String update(int privateChatId, int lastSeenNumber) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("last_seen_no", lastSeenNumber + ""));
		return protonet.patch("/api/v1/private_chats/" + privateChatId, data);
	}
}
