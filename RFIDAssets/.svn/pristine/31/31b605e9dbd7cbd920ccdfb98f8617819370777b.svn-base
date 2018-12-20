package com.daoben.rfid.utils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
@Repository
public class ResponsePWFactory {
	public String responseMap(String result,String msg,Object info,Map<String, Object> params){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("msg",msg);
		if( info == null ){
			map.put("info", "");
		}else
			map.put("info",info);
			
		if(null != params){
			for (String key : params.keySet()) {
				map.put(key, params.get(key));
			}
		}
//		Gson gson = new Gson();
		String s = null;
		Gson gson =  new GsonBuilder().serializeNulls().create();
		String json = gson.toJson(map);
		return json;
//		return JSONObject.toJSONString(map,SerializerFeature.WriteMapNullValue);  
//		return JSON.toJSONString(map);
	}
	
}
