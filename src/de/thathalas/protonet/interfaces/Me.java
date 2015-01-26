package de.thathalas.protonet.interfaces;

import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.User;

/**
 * The Me class represents the Me REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Me {
	private ProtonetWrapper protonet;

	public Me(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public User me() {
		JSONObject json = new JSONObject(protonet.get("/api/v1/me")).getJSONObject("me");
		return User.createUser(json);
	}
	
	public String login_tokens() {
		return new JSONObject(protonet.get("/api/v1/me/login_token")).getString("login_token");
	}
}
