package de.thathalas.protonet.objects;

import org.json.JSONObject;

public class ProtonetSubscription {
	private int id;
	private int lastSeenMeepNo;
	
	private ProtonetSubscription(int id, int lastSeenMeepNo) {
		super();
		this.id = id;
		this.lastSeenMeepNo = lastSeenMeepNo;
	}
	
	public static ProtonetSubscription createSubscription(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("subscription")) {
			json = json.getJSONObject("subscription");
		}
		return createSubscription(json);
	}
	
	public static ProtonetSubscription createSubscription(JSONObject json) {
		return new ProtonetSubscription(
				json.getInt("id"), 
				json.getInt("last_seen_meep_no"));
	}

	public int getId() {
		return id;
	}

	public int getLastSeenMeepNo() {
		return lastSeenMeepNo;
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
		ProtonetSubscription other = (ProtonetSubscription) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Subscription [id=" + id + ", lastSeenMeepNo=" + lastSeenMeepNo
				+ "]";
	}
}
