package de.thathalas.protonet.objects;

import org.json.JSONObject;

public class ProtonetProject {
	private int id;
	private String name;
	private String lastMeepDate; //TODO: in future convert to real date!
	private int currentMeepNo;
	private ProtonetUser lastMeepUser;
	private ProtonetMeep lastMeep;
	private ProtonetSubscription subscription;

	private ProtonetProject(int id, String name, String lastMeepDate,
			int currentMeepNo, ProtonetUser lastMeepUser, ProtonetMeep lastMeep,
			ProtonetSubscription subscription) {
		super();
		this.id = id;
		this.name = name;
		this.lastMeepDate = lastMeepDate;
		this.currentMeepNo = currentMeepNo;
		this.lastMeepUser = lastMeepUser;
		this.lastMeep = lastMeep;
		this.subscription = subscription;
	}

	public static ProtonetProject createProject(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("project")) {
			json = json.getJSONObject("project");
		}
		return createProject(json);
	}

	public static ProtonetProject createProject(JSONObject json) {
		String lastMeepDate = "";
		if(!json.isNull("last_meep_date")) {
			lastMeepDate = json.getString("last_meep_date");
		}
		
		ProtonetUser lastMeepUser = null;
		if(!json.isNull("last_meep_user")) {
			lastMeepUser = ProtonetUser.createUser(json.getJSONObject("last_meep_user"));
		}
		
		ProtonetMeep lastMeep = null;
		if(!json.isNull("last_meep")) {
			lastMeep = ProtonetMeep.createMeep(json.getJSONObject("last_meep"));
		}
		
		ProtonetProject project = new ProtonetProject(
				json.getInt("id"), 
				json.getString("name"),
				lastMeepDate,
				json.getInt("current_meep_no"),
				lastMeepUser,
				lastMeep,
				ProtonetSubscription.createSubscription(json.getJSONObject("subscription")));
		return project;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastMeepDate() {
		return lastMeepDate;
	}

	public int getCurrentMeepNo() {
		return currentMeepNo;
	}

	public ProtonetUser getLastMeepUser() {
		return lastMeepUser;
	}

	public ProtonetMeep getLastMeep() {
		return lastMeep;
	}

	public ProtonetSubscription getSubscription() {
		return subscription;
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
		ProtonetProject other = (ProtonetProject) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
}
