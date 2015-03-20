package de.thathalas.protonet.objects;

import java.util.Date;

import org.json.JSONObject;

public class ProtonetUser {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String avatar;
	private String role;
	private String username;
	private boolean deactivated;
	private boolean online;
	private Date lastActiveAt;
	
	private ProtonetUser(int id, String firstName, String lastName, String email,
			String avatar, String role, String username, boolean deactivated,
			boolean online, String lastActiveAt) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.avatar = avatar;
		this.role = role;
		this.username = username;
		this.deactivated = deactivated;
		this.online = online;
		this.lastActiveAt =  new Date();
	}
	
	/**
	 * Creates a new User from a given json.
	 * @param json the json object the user should be created from.
	 * @return a user instance
	 */
	public static ProtonetUser createUser(JSONObject json) {
		String username;
		if (json.has("username")) {
			username = json.getString("username");
		} else {
			username = json.getString("first_name").toLowerCase() + "." + json.getString("last_name").toLowerCase();
		}
		
		String lastActiveAt;
		if (json.isNull("last_active_at")) {
			lastActiveAt = "";
		} else {
			lastActiveAt = json.getString("last_active_at");
		}
		
		ProtonetUser user = new ProtonetUser(
				json.getInt("id"), 
				json.getString("first_name"), 
				json.getString("last_name"), 
				json.getString("email"), 
				json.getString("avatar"), 
				json.getString("role"), 
				username, 
				json.getBoolean("deactivated"), 
				json.getBoolean("online"), 
				lastActiveAt);
		return user;
	}
	
	/**
	 * Creates a new user instance from a given json string. Accept the json with user root
	 * and without root user.
	 * @param jsonObject the json string the user should be created from.
	 * @return A user instance
	 */
	public static ProtonetUser createUser(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("user")) {
			json = json.getJSONObject("user");
		}
		return createUser(json);
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getAvatar() {
		return avatar;
	}

	public String getRole() {
		return role;
	}

	public String getUsername() {
		return username;
	}

	public boolean isDeactivated() {
		return deactivated;
	}

	public boolean isOnline() {
		return online;
	}

	public Date getLastActiveAt() {
		return lastActiveAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
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
		ProtonetUser other = (ProtonetUser) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", role=" + role + ", username=" + username
				+ "]";
	}
	
}
