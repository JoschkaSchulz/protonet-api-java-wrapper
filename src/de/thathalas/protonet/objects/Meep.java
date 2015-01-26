package de.thathalas.protonet.objects;

import org.json.JSONObject;

public class Meep {
	private int id;
    private String message;
    private int no;
    private String type;
    private User user;
	private String files; //TODO: Has to be implemented next!
	
	private Meep(int id, String message, int no, String type, User user,
			String files) {
		super();
		this.id = id;
		this.message = message;
		this.no = no;
		this.type = type;
		this.user = user;
		this.files = files;
	}

	private Meep(int id, String message, int no, String type, User user) {
		super();
		this.id = id;
		this.message = message;
		this.no = no;
		this.type = type;
		this.user = user;
	}
	
	public static Meep createMeep(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("meep")) {
			json = json.getJSONObject("meep");
		}
		return createMeep(json);
	}
	
	public static Meep createMeep(JSONObject json) {
		Meep meep = new Meep(
				json.getInt("id"), 
				json.getString("message"), 
				json.getInt("no"), 
				json.getString("type"), 
				User.createUser(json.getJSONObject("user")));
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

	public User getUser() {
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
		Meep other = (Meep) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meep [id=" + id + ", message=" + message + "]";
	}
	
}
