package de.thathalas.protonet.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProtonetPrivateChat {
	private int id;
	private List<ProtonetUser> otherUsers;
	private int notificationId;
	private ProtonetMeep lastMeep;
	private String lastMeepDate;
	private ProtonetSubscription subscription;
	private int currentMeepNo;
	
	private ProtonetPrivateChat(int id, List<ProtonetUser> otherUsers,
			int notificationId, ProtonetMeep lastMeep, String lastMeepDate,
			ProtonetSubscription subscription, int currentMeepNo) {
		super();
		this.id = id;
		this.otherUsers = otherUsers;
		this.notificationId = notificationId;
		this.lastMeep = lastMeep;
		this.lastMeepDate = lastMeepDate;
		this.subscription = subscription;
		this.currentMeepNo = currentMeepNo;
	}
	
	public static ProtonetPrivateChat createPrivateChat(JSONObject json) {
		JSONArray arrayOtherUsers = json.getJSONArray("other_users");
		List<ProtonetUser> otherUsers = new ArrayList<ProtonetUser>();
		for(int i = 0; i < arrayOtherUsers.length(); i++) {
			otherUsers.add(ProtonetUser.createUser(arrayOtherUsers.getJSONObject(i)));
		}
		
		ProtonetMeep lastMeep = null;
		if(!json.isNull("last_meep")) {
			lastMeep = ProtonetMeep.createMeep(json.getJSONObject("last_meep"));
		}
		
		String lastMeepDate = null;
		if(!json.isNull("last_meep_date")) {
			lastMeepDate = json.getString("last_meep_date");
		}
		
		
		return new ProtonetPrivateChat(
				json.getInt("id"), 
				otherUsers, 
				json.getInt("notification_id"), 
				lastMeep,
				lastMeepDate,
				ProtonetSubscription.createSubscription(json.getJSONObject("subscription")), 
				json.getInt("current_meep_no"));
	}
	
	public static ProtonetPrivateChat createPrivateChat(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("private_chat")) {
			json = json.getJSONObject("private_chat");
		}
		return createPrivateChat(json);
	}

	public int getId() {
		return id;
	}

	public List<ProtonetUser> getOtherUsers() {
		return otherUsers;
	}

	public int getNotificationId() {
		return notificationId;
	}

	public ProtonetMeep getLastMeep() {
		return lastMeep;
	}

	public String getLastMeepDate() {
		return lastMeepDate;
	}

	public ProtonetSubscription getSubscription() {
		return subscription;
	}

	public int getCurrentMeepNo() {
		return currentMeepNo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProtonetPrivateChat other = (ProtonetPrivateChat) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProtonetPrivateChat [id=" + id + ", otherUsers=" + otherUsers
				+ "]";
	}
	
	
	
}
