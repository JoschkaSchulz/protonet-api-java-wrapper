package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.ProtonetPrivateChat;

/**
 * The Me class represents the Private Chats REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class PrivateChats {
	private ProtonetWrapper protonet;
	
	public PrivateChats(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public List<ProtonetPrivateChat> index() {
		List<ProtonetPrivateChat> list = new ArrayList<ProtonetPrivateChat>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/private_chats")).getJSONArray("private_chats");
		for(int i = 0; i < array.length(); i++) {
			list.add(ProtonetPrivateChat.createPrivateChat(array.getJSONObject(i)));
		}
		return list;
	}
	
	public ProtonetPrivateChat create(int otherUserId) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("other_user_id", otherUserId + ""));
		return ProtonetPrivateChat.createPrivateChat(protonet.post("/api/v1/private_chats", data));
	}
	
	public ProtonetPrivateChat show(int userId) {
		return ProtonetPrivateChat.createPrivateChat(protonet.get("/api/v1/private_chats/" + userId));
	}
	
	public String update(int privateChatId, int lastSeenNumber) {
		List<BasicNameValuePair> data = new ArrayList<>();
		data.add(new BasicNameValuePair("last_seen_no", lastSeenNumber + ""));
		return protonet.patch("/api/v1/private_chats/" + privateChatId, data);
	}
}
