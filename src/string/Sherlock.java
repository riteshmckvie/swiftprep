package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Sherlock considers a string to be valid if all characters of the string appear the same number of times. It is also valid if he can remove just  character at  index in the string, and the remaining characters will occur the same number of times. Given a string , determine if it is valid. If so, return YES, otherwise return NO.
//For example, if , it is a valid string because frequencies are . So is  because we can remove one  and have  of each character in the remaining string. If  however, the string is not valid as we can only remove  occurrence of . That would leave character frequencies of .
public class Sherlock {

	static public int maxCharCount = 0;
	static int deletionCount = 0;
	static int firstValue = 0;

	static String isValid(String s) {
         if (s == null || s.isEmpty()) return "NO";
        
        Map<Character,Integer> charCountMap = getcharCountMap(s.toCharArray());

        Set<Integer> st = new HashSet<>();
        for(int freq : charCountMap.values())
        {
            st.add(freq);
        }
        
        if(st.size() > 2)
            return "NO";
        else if(st.size() == 1)
            return "YES";
        else
        {
            int f1 = 0;
            int f2 = 0;
            int f1Count = 0;
            int f2Count = 0;
            int i = 0;
            for(int n : st)
            {
                if(i == 0) f1 = n;
                else f2 = n;
                i++;
            }
            
            for(int freq : charCountMap.values())
            {
                if(freq == f1) f1Count++;
                if(freq == f2) f2Count++;
            }
            
            
            
            if((f1 == 1 && f1Count == 1 ) || (f2 == 1 && f2Count == 1 ))
                return "YES";
            else if ((Math.abs(f1 - f2)  == 1) && (f1Count == 1 || f2Count == 1))
                return "YES";
            else
                return "NO";
        }
    }
	
	static Map<Character,Integer> getcharCountMap(char[] charArray) {
		HashMap<Character, Integer> charCountMap = new HashMap<>();
		for(int i= 0; i< charArray.length; i++) {
				if(charCountMap.containsKey(charArray[i])) {
					int newCount = charCountMap.get(charArray[i]) + 1;
					charCountMap.put(charArray[i], newCount);
					maxCharCount = newCount > maxCharCount ?  newCount : maxCharCount;
				} else {
					charCountMap.put(charArray[i], 0);
				}
		}
        return charCountMap;
    }

	public static void main(String[] args) {
		Sherlock.isValid("abcdefghhgfedecba");
	}

}
