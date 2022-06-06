package GeneralString;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String first="ababca";
		String second="bbaaba";
		Anagram t=new Anagram();
		boolean check=t.checkAnagram(first,second);
		System.out.println(check);
	}

	private boolean checkAnagram(String first, String second) {
		if(first.length()!=second.length())
			return false;
		int[] count=new int[26];
		for(int i=0;i<first.length();i++) {
			count[first.charAt(i)-'a']++;
			count[second.charAt(i)-'a']--;
		}
		
		for(int i=0;i<26;i++) {
			if(count[i]!=0)
				return false;
		}
		
		
//		if(map.containsKey(first.charAt(i))) {
//			map.put(first.charAt(i), map.get(first.charAt(i))+1);
//		}
//		else {
//			map.put(first.charAt(i), 1);
//		}
		
//		for(int i=0;i<second.length();i++) {
//			if(map.containsKey(second.charAt(i)) && map.get(second.charAt(i))>0) {
//				map.put(second.charAt(i), map.get(second.charAt(i))-1);
//			}
//			else {
//				return false;
//			}
//		}
		
		return true;
	}

}
