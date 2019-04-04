package com.dropbox;

import javax.swing.text.html.parser.Entity;
import java.util.*;

public class FindDuplicateFiles {
	public static void main(String[] args) {
//		HashMap<String, List<String>> map = new HashMap<>();
//		List<String> list = new ArrayList<>();
//		list.add("a");
//		map.put("1", list);
//		List<String> pathList = map.getOrDefault("1", new ArrayList<>());
//		pathList.add("b");
//		printMap(map);
		
		LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
		linkedHashMap.put(1, 1);
		linkedHashMap.put(2, 2);
		linkedHashMap.put(3, 3);
		linkedHashMap.remove(2);
		linkedHashMap.put(2, 20);
		linkedHashMap.remove(3);
		linkedHashMap.put(3, 30);
		for (Integer key : linkedHashMap.keySet()) {
			System.out.println(key + " : " + linkedHashMap.get(key));
		}
		Map.Entry<Integer, Integer> firstEntry = linkedHashMap.entrySet().iterator().next();
		System.out.println(firstEntry);
	}
	
	private static void printMap(HashMap<String, List<String>> map) {
		for (String key : map.keySet()) {
			List<String> list = map.get(key);
			System.out.println(key + " : " + list);
		}
	}
}
