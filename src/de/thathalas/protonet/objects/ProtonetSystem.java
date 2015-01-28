package de.thathalas.protonet.objects;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ProtonetSystem {
	private String name;
	private String publicHost;
	private String productType;
	private List<String> internalAddress;
	
	private ProtonetSystem(String name, String publicHost, String productType,
			List<String> internalAddress) {
		super();
		this.name = name;
		this.publicHost = publicHost;
		this.productType = productType;
		this.internalAddress = internalAddress;
	}
	
	public static ProtonetSystem createSystem(JSONObject json) {
		JSONArray array = json.getJSONArray("internal_address");
		List<String> internalAdress = new ArrayList<String>();
		for(int i = 0; i < array.length(); i++) {
			internalAdress.add(array.getString(i));
		}
		return new ProtonetSystem(
				json.getString("name"), 
				json.getString("publicHost"), 
				json.getString("productType"), 
				internalAdress);
	}
	
	public static ProtonetSystem createSystem(String jsonObject) {
		JSONObject json = new JSONObject(jsonObject);
		if (json.has("system")) {
			json = json.getJSONObject("system");
		}
		return createSystem(json);
	}
	
	public String getName() {
		return name;
	}

	public String getPublicHost() {
		return publicHost;
	}

	public String getProductType() {
		return productType;
	}

	public List<String> getInternalAddress() {
		return internalAddress;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((productType == null) ? 0 : productType.hashCode());
		result = prime * result
				+ ((publicHost == null) ? 0 : publicHost.hashCode());
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
		ProtonetSystem other = (ProtonetSystem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (publicHost == null) {
			if (other.publicHost != null)
				return false;
		} else if (!publicHost.equals(other.publicHost))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "System [name=" + name + ", publicHost=" + publicHost
				+ ", productType=" + productType + ", internalAddress="
				+ internalAddress + "]";
	}
}
