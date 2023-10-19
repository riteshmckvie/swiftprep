package recursion;

public class FindSentencesFromWord {
	
//	Problem Description::
//	    
//		Given a String "word" and an array of Strings "words", add spaces in "word" to construct a sentence 
//		where each word is a valid word from "words". Return all such possible sentences in any order.
//
//		Note: The same word in the "words" may be reused multiple times in the segmentation.
//
//	Example 1::
//		Input: word = "batsandcows", words = {"bat", "bats", "and", "sand", "cows", "cow"} 
//		Output: {"bat sand cows", "bats and cows"}
//	
//	Example 2::
//		Input: word = "basand", words = {"bat", "bats", "and", "sand", "cows", "cow"} 
//		Output: {}
//		
//	Constraints::
//		1 <= word.length <= 20
//		1 <= words.length <= 1000
//		1 <= words[i].length <= 10
//		Word and words[i] consist of lowercase English letters.
//		All the strings of words array are unique.
	
	public static void main(String[] args) {
				String[] words = { "bat", "bats", "and", "sand", "cows", "cow" };
				String[] result = findProperSentences("batsandcows", words);
				for (String str : result) {
					System.out.println(str);
				}
			}

			public static String[] findProperSentences(String word, String[] words) {
				String[] anotherWords = new String[words.length];
				appendTheWord("",word, words,anotherWords,0);
				return anotherWords;
			}
			
			static void appendTheWord(String current, String elem, String[] words, String[] anotherWords,int index) {
				if(elem.length() == 0) {
					anotherWords[index] = current;
					return;
				}
				
				for(int i= 0; i < words.length; i++) {
					String word = words[i];
					if(elem.indexOf(word) == 0) {
						appendTheWord(current+ " "+word,elem.substring(word.length()), words, anotherWords,index++);
					}
				}
			}

}
