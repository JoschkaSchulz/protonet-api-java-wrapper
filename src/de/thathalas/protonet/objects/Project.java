package de.thathalas.protonet.objects;

import org.json.JSONObject;

public class Project {
	private int id;
	private String name;
	private String lastMeepDate; //TODO: in future convert to real date!
	private int currentMeepNo;
	private User lastMeepUser;
	private Meep lastMeep;
	private Subscription subscription;

	private Project(int id, String name, String lastMeepDate,
			int currentMeepNo, User lastMeepUser, Meep lastMeep,
			Subscription subscription) {
		super();
		this.id = id;
		this.name = name;
		this.lastMeepDate = lastMeepDate;
		this.currentMeepNo = currentMeepNo;
		this.lastMeepUser = lastMeepUser;
		this.lastMeep = lastMeep;
		this.subscription = subscription;
	}

	public static Project createProject(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("project")) {
			json = json.getJSONObject("project");
		}
		return createProject(json);
	}

	public static Project createProject(JSONObject json) {
		String lastMeepDate = "";
		if(!json.isNull("last_meep_date")) {
			lastMeepDate = json.getString("last_meep_date");
		}
		
		User lastMeepUser = null;
		if(!json.isNull("last_meep_user")) {
			lastMeepUser = User.createUser(json.getJSONObject("last_meep_user"));
		}
		
		Meep lastMeep = null;
		if(!json.isNull("last_meep")) {
			lastMeep = Meep.createMeep(json.getJSONObject("last_meep"));
		}
		
		Project project = new Project(
				json.getInt("id"), 
				json.getString("name"),
				lastMeepDate,
				json.getInt("current_meep_no"),
				lastMeepUser,
				lastMeep,
				Subscription.createSubscription(json.getJSONObject("subscription")));
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

	public User getLastMeepUser() {
		return lastMeepUser;
	}

	public Meep getLastMeep() {
		return lastMeep;
	}

	public Subscription getSubscription() {
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
		Project other = (Project) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + "]";
	}
}
