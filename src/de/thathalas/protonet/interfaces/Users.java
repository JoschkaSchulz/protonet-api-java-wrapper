package de.thathalas.protonet.interfaces;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.User;

/**
 * The Me class represents the Users REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Users {
	private ProtonetWrapper protonet;
	
	public Users(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public List<User> index() {
		List<User> list = new ArrayList<User>();
		JSONArray array = new JSONObject(protonet.get("/api/v1/users")).getJSONArray("users");
		for(int i = 0; i < array.length(); i++) {
			list.add(User.createUser(array.getJSONObject(i)));
		}
		return list;
	}
	
	public User show(int userId) {
		String json = protonet.get("/api/v1/users/" + userId);
		User user = User.createUser(json);
		return user;
	}
}
