package topcoder.chapter05.party.bart;

import java.util.HashMap;
import java.util.Map;

public class InterestingParty {

	public static int bestInvitation(String[] first, String[] second) {
		Map<String, Integer> countMap = new HashMap<>();
		buildCountMap(first,countMap);
		buildCountMap(second,countMap);
		return findMax(countMap);
	}

	private static int findMax(Map<String, Integer> countMap) {
		int max = 1;
		for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
			max =  max < entry.getValue()? entry.getValue() : max;
		}

		return max;
	}

	private static void buildCountMap(String[] list, Map<String, Integer> countMap) {
		for(int index = 0; index < list.length; index++) {
			if(countMap.containsKey(list[index])) {
				int currentCount = countMap.get(list[index]) + 1;
				countMap.put(list[index], currentCount);
			}else {
				countMap.put(list[index], 1);
			}
		}
	}
}