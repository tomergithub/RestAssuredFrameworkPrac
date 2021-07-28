package apiConfigs;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs 
{	public Map<String, String> defaultHeaders(){
		Map<String, String>defaultHeaders=new HashMap<String,String>();
		defaultHeaders.put("Content-Type","application/json");
		defaultHeaders.put("test key","test value");
		return defaultHeaders;		
	}
	public Map<String, String> headersWithToken()
	{
		Map<String, String>defaultHeaders=new HashMap<String,String>();
		defaultHeaders.put("Content-Type","application/json");
		defaultHeaders.put("Access-Token","dsgdagdfggarwerfwr");
		defaultHeaders.put("jwt_token","afdgfdagfagfgfdagfdgfad");
		defaultHeaders.put("Tenet_user","test");		
		return defaultHeaders;		
	}
	/*
	 * public Map<String, String> headersWithToken(){ Map<String,
	 * String>defaultHeaders=new HashMap<String,String>();
	 * defaultHeaders.put("Content-Type","application/json");
	 * defaultHeaders.put("Access-Token","dsgdagdfggarwerfwr");
	 * defaultHeaders.put("jwt_token","afdgfdagfagfgfdagfdgfad");
	 * defaultHeaders.put("Tenet_user","test");
	 * 
	 * return defaultHeaders;
	 * 
	 * }
	 */	
	
	
}
