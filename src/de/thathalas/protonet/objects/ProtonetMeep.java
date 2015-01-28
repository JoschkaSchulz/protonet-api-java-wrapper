package de.thathalas.protonet.objects;

import org.json.JSONObject;

public class ProtonetMeep {
	private int id;
	private String message;
    private int no;
    private String type;
    private ProtonetUser user;
    private String files; //TODO: Has to be implemented next!
	
	private ProtonetMeep(int id, String message, int no, String type, ProtonetUser user,
			String files) {
		super();
		this.id = id;
		this.message = message;
		this.no = no;
		this.type = type;
		this.user = user;
		this.files = files;
	}

	private ProtonetMeep(int id, String message, int no, String type, ProtonetUser user) {
		super();
		this.id = id;
		this.message = message;
		this.no = no;
		this.type = type;
		this.user = user;
	}
	
	public static ProtonetMeep createMeep(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("meep")) {
			json = json.getJSONObject("meep");
		}
		return createMeep(json);
	}
	
	public static ProtonetMeep createMeep(JSONObject json) {
		ProtonetMeep meep = new ProtonetMeep(
				json.getInt("id"), 
				json.getString("message"), 
				json.getInt("no"), 
				json.getString("type"), 
				ProtonetUser.createUser(json.getJSONObject("user")));
		return meep;
	}

	public int getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public int getNo() {
		return no;
	}

	public String getType() {
		return type;
	}

	public ProtonetUser getUser() {
		return user;
	}

	public String getFiles() {
		return files;
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
		ProtonetMeep other = (ProtonetMeep) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meep [id=" + id + ", message=" + message + "]";
	}
	
}
