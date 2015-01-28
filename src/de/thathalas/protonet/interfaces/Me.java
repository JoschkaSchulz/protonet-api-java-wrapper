package de.thathalas.protonet.interfaces;

import org.json.JSONObject;

import de.thathalas.protonet.ProtonetWrapper;
import de.thathalas.protonet.objects.ProtonetUser;

/**
 * The Me class represents the Me REST interface of the Protonet API.
 * @author Joschka Schulz
 */
public class Me {
	private ProtonetWrapper protonet;

	public Me(ProtonetWrapper protonet) {
		this.protonet = protonet;
	}
	
	public ProtonetUser me() {
		JSONObject json = new JSONObject(protonet.get("/api/v1/me")).getJSONObject("me");
		return ProtonetUser.createUser(json);
	}
	
	public String login_tokens() {
		return new JSONObject(protonet.get("/api/v1/me/login_token")).getString("login_token");
	}
}
