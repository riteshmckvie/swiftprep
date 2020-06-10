package string;

public class MakingAnagram {

	static int makeAnagram(String a, String b) {
		int[] freqFirst = new int[26];
		int[] freqSecond = new int[26];
		int deletions = 0;

		for (int i = 0; i < a.length(); i++)
			freqFirst[a.charAt(i) - 'a'] = freqFirst[a.charAt(i) - 'a'] + 1;
		for (int i = 0; i < b.length(); i++)
			freqSecond[b.charAt(i) - 'a'] = freqSecond[b.charAt(i) - 'a'] + 1;

		for (int i = 0; i < 26; i++)
			deletions += Math.abs(freqFirst[i] - freqSecond[i]);

		return deletions;
	}

	public static void main(String[] args) {
		makeAnagram("abc", "def");
	}

}
