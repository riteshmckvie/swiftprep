package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Relation {

	public static void main(String[] args) {
		
		Map<String, String> relMap = new HashMap<>();
		relMap.put("a", "b");
		relMap.put("b", "c");
		relMap.put("c", "d");
		relMap.put("d", null);
		Map<String, Integer> mapCount = Relation.mapCount(relMap);
		System.out.println(mapCount);
		
	}

	private static Map<String, Integer> mapCount(Map<String, String> relMap) {
		Map<String, Integer> countMap = new HashMap<>();
		String firstKey = (String) relMap.keySet().toArray()[0];
		String firstVal = relMap.get(relMap.keySet().toArray()[0]);
		return Relation.mapCountRecursive(relMap, countMap, firstVal, firstKey);
	}
	
	private static Map<String, Integer> mapCountRecursive(Map<String, String> relMap,Map<String, Integer> countMap, String firstVal, String firstKey) {
		countMap.put(firstKey, 0);
		if (firstVal == null) 
			return countMap;
		if(relMap.containsKey(firstVal)) {
			countMap.put(firstVal, countMap.getOrDefault(firstVal, 0)+1);
			Relation.mapCountRecursive(relMap, countMap, relMap.get(firstVal), firstVal);
			countMap.put(firstKey, countMap.get(firstVal)+1);
		}
		return countMap;
	}

}
