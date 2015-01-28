package de.thathalas.protonet.objects;

import org.json.JSONObject;

public class ProtonetUserDevice {
	private int id;
	private String token;
	private String platform;
	
	private ProtonetUserDevice(int id, String token, String platform) {
		this.id = id;
		this.token = token;
		this.platform = platform;
	}
	
	public static ProtonetUserDevice createUserDevice(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("user_device")) {
			json = json.getJSONObject("user_device");
		}
		return createUserDevice(json);
	}
	
	public static ProtonetUserDevice createUserDevice(JSONObject json) {
		return new ProtonetUserDevice(
				json.getInt("id"), 
				json.getString("token"), 
				json.getString("platform"));
	}

	public int getId() {
		return id;
	}

	public String getToken() {
		return token;
	}

	public String getPlatform() {
		return platform;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((token == null) ? 0 : token.hashCode());
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
		ProtonetUserDevice other = (ProtonetUserDevice) obj;
		if (id != other.id)
			return false;
		if (token == null) {
			if (other.token != null)
				return false;
		} else if (!token.equals(other.token))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDevice [id=" + id + ", token=" + token + ", platform="
				+ platform + "]";
	}
}
