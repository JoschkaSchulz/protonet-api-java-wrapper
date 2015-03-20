package de.thathalas.protonet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

import de.thathalas.protonet.interfaces.Devices;
import de.thathalas.protonet.interfaces.Me;
import de.thathalas.protonet.interfaces.Meeps;
import de.thathalas.protonet.interfaces.PrivateChats;
import de.thathalas.protonet.interfaces.Projects;
import de.thathalas.protonet.interfaces.Subscriptions;
import de.thathalas.protonet.interfaces.Systems;
import de.thathalas.protonet.interfaces.Users;

public class ProtonetWrapper {
	private String serverUrl;
	private HttpClient client;

	private String token;
	private int userId;
	
	private Me meWrapper;
	private Devices devicesWrapper;
	private Users usersWrapper;
	private Projects projectsWrapper;
	private Meeps meepsWrapper;
	private PrivateChats privateChatsWrapper;
	private Subscriptions subscriptionsWrapper;
	private Systems systemsWrapper;
	
	public ProtonetWrapper(String serverUrl) {
		this.serverUrl = serverUrl;
		
		client = new DefaultHttpClient();
		
		this.initInterfaceWrappers();
	}
	
	private String buildUrl(String endpoint) {
		return serverUrl + endpoint;
	}
	
	private void initInterfaceWrappers() {
		meWrapper = new Me(this);
		devicesWrapper = new Devices(this);
		usersWrapper = new Users(this);
		projectsWrapper = new Projects(this);
		meepsWrapper = new Meeps(this);
		privateChatsWrapper = new PrivateChats(this);
		systemsWrapper = new Systems(this);
		subscriptionsWrapper = new Subscriptions(this);
	}
	
	private String startResponse(HttpResponse response) {
		String result = "";
		try {
			BufferedReader reader;
			int code = response.getStatusLine().getStatusCode();
			if (code == HttpStatus.SC_OK || code == HttpStatus.SC_CREATED) {
				reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
				String line = "";
				while ((line = reader.readLine()) != null) {
					result += line;
				}
			} else if (code == HttpStatus.SC_NO_CONTENT) {
				result = "{}";
			} else {
				throw new RuntimeException("The Status Code is: " + code);
			}
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public Me getMe() {
		return meWrapper;
	}
	
	public Devices getDevices() {
		return devicesWrapper;
	}
	
	public Users getUsers() {
		return usersWrapper;
	}
	
	public Projects getProjects() {
		return projectsWrapper;
	}
	
	public Meeps getMeeps() {
		return meepsWrapper;
	}
	
	public PrivateChats getPrivateChats() {
		return privateChatsWrapper;
	}
	
	public Subscriptions getSubscriptions() {
		return subscriptionsWrapper;
	}
	
	public Systems getSystems() {
		return systemsWrapper;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getToken() {
		return token;
	}
	
	public void setToken(String token) {
		this.token = token;
	}
	
	public void getToken(String email, String password, String comment) {
		String result = "";
		try {
			HttpPost request = new HttpPost(serverUrl + "/api/v1/tokens");
			BasicAuthCache auth = new BasicAuthCache();
			request.addHeader("Authorization", "Basic " + Base64.encodeBase64String((email+":"+password).getBytes()));
			List<BasicNameValuePair> data = new ArrayList<>();
			data.add(new BasicNameValuePair("comment", comment));
			request.setEntity(new UrlEncodedFormEntity(data));
			result = startResponse(client.execute(request));
			JSONObject json = new JSONObject(result);
			this.token = json.getString("token");
			this.userId = json.getInt("user_id");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String get(String endpoint) {
		String result = "";
		try {
			HttpGet request = new HttpGet(serverUrl + endpoint);
			request.addHeader("X-Protonet-Token", token);
			result = startResponse(client.execute(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String post(String endpoint, List<BasicNameValuePair> data) {
		String result = "";
		try {
			HttpPost request = new HttpPost(serverUrl + endpoint);
			request.addHeader("X-Protonet-Token", token);
			request.setEntity(new UrlEncodedFormEntity(data));
			result = startResponse(client.execute(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String patch(String endpoint, List<BasicNameValuePair> data) {
		String result = "";
		try {
			HttpPatch request = new HttpPatch(serverUrl + endpoint);
			request.addHeader("X-Protonet-Token", token);
			request.setEntity(new UrlEncodedFormEntity(data));
			result = startResponse(client.execute(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String delete(String endpoint) {
		String result = "";
		try {
			HttpDelete request = new HttpDelete(serverUrl + endpoint);
			request.addHeader("X-Protonet-Token", token);
			result = startResponse(client.execute(request));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
