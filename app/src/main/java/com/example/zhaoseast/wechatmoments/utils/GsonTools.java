package com.example.zhaoseast.wechatmoments.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Project:
 * @Package com.sh.abclient.http
 * @Title: GsonTools.java
 * @Description: 解析json数据封装类(Gson)
 * @author lxr
 * @version V1.0.1
 **/
public class GsonTools {

	private static Gson gson = null;

	//private static final String format = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 采用单例模式得到Gson 对象
	 *
	 * @return
	 */
	public static Gson getInstace() {
			synchronized (GsonTools.class) {
				if (gson == null) {
					// 解决返回数据 time  是Date类型
					//gson = new GsonBuilder().setDateFormat(format).create();
					gson = new Gson();
				}
				return gson;
			}
	}

	/**
	 * 获取单个用户的信息
	 *
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> T jsonToObj(String jsonString, Class<T> cls) {
		T t = null;
		try {
			t = getInstace().fromJson(jsonString, cls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return t;
	}

	/**
	 * 获取多个用户的信息
	 *
	 * @param jsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> jsonToList(String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<>();
		try {
			list = getInstace().fromJson(jsonString,
					new TypeToken<List<T>>() {}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 获取多个用户的信息  解决ClassCastException
	 * @param jsonString
	 * @param cls
	 * @param <T>
	 * @return
	 */
	public static <T> List<T> getObjectList(String jsonString,Class<T> cls){
		List<T> list = new ArrayList<>();
		try {
			JsonArray arry = new JsonParser().parse(jsonString).getAsJsonArray();
			for (JsonElement jsonElement : arry) {
				list.add(getInstace().fromJson(jsonElement, cls));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static <T> List<T> getMuchDatas(String name,String jsonString, Class<T> cls) {
		List<T> list = new ArrayList<>();
		try {
			JsonParser parser = new JsonParser();
			JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
			//将data节点下的内容转为JsonArray
			JsonArray jsonArray = jsonObject.getAsJsonArray(name);
			for (JsonElement jsonElement : jsonArray) {
				list.add(getInstace().fromJson(jsonElement, cls));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 获取String的一个集合
	 *
	 * @param jsonString
	 * @return
	 */
	public static List<String> getList(String jsonString) {
		List<String> list = new ArrayList<>();
		try {
			list = getInstace().fromJson(jsonString,
					new TypeToken<List<String>>() {}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	/**
	 * 获取以<key,value>的一个集合
	 *
	 * @param jsonString
	 * @return
	 */
	public static List<Map<String, Object>> listKeyMap(String jsonString) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			list = getInstace().fromJson(jsonString,
					new TypeToken<List<Map<String, Object>>>() {}.getType());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * object to json
	 * @param object
	 * @return
	 */
	public static String objectToJson(Object object){
		return getInstace().toJson(object);
	}

	/**
	 * map to json
	 * @param map
	 * @return
	 */
	public static String mapToJson(Map<String,String> map){
		return getInstace().toJson(map);
	}

	/**
	 * list to json
	 * @param list
	 * @return
	 */
	public static <T> String listToJson(List<T> list){
		return getInstace().toJson(list);
	}

}
