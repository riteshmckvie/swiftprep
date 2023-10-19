package recursion;

public class FindSentencesFromWord {

	public static void main(String[] args) {
		//write code for testing the solution
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
