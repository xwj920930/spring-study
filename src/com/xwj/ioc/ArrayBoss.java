package com.xwj.ioc;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class ArrayBoss {
	private List<String> list;
	private Set<Integer> set;
	private Map<Integer, String> map;
	private Properties prop;

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}
	public void introduce(){
		for (String string : list) {
			System.out.print("+"+string+"+");
		}
		for (Integer integer : set) {
			System.out.print("*"+integer+"*");
		}
		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.print("/"+entry.getKey()+":"+entry.getValue()+"/");
		}
		for (Entry<Object, Object> entry : prop.entrySet()) {
			System.out.print("<"+entry.getKey()+"="+entry.getValue()+"<");
		}
	}

	public Set<Integer> getSet() {
		return set;
	}

	public void setSet(Set<Integer> set) {
		this.set = set;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
}
