package textgen;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/** 
 * An implementation of the MTG interface that uses a list of lists.
 * @author UC San Diego Intermediate Programming MOOC team 
 */
public class MarkovTextGeneratorLoL implements MarkovTextGenerator {

	// The list of words with their next words
	private List<ListNode> wordList; 
	
	// The starting "word"
	private String starter;
	
	// The random number generator
	private Random rnGenerator;
	
	public MarkovTextGeneratorLoL(Random generator)
	{
		wordList = new LinkedList<ListNode>();
		starter = "";
		rnGenerator = generator;
	}
	
	
	/** Train the generator by adding the sourceText */
	@Override
	public void train(String sourceText)
	{
		// TODO: Implement this method
		//sourceText=sourceText.replaceAll("[^a-zA-Z ]", "").toLowerCase();
		String[] words=sourceText.split("\\s+");
		starter = words[0];
		boolean flag=false;
		//System.out.println("-----");
		//System.out.println(starter);
		//System.out.println(wordList);
		String prevWord = starter;
		for(int i=1;i<words.length;i++){
			flag=false;
			if((!wordList.isEmpty())){
				for(ListNode n: wordList){
					//System.out.println("&&&");
					//System.out.println(prevWord);
					
				if(prevWord.equals(n.getWord())){
					//System.out.println("***");
					//System.out.println(words[i]);
					n.addNextWord(words[i]);
					flag=true;
					break;
				}
				}
			}
			if(wordList.isEmpty() || !flag){
				flag= false;
				ListNode notPresent = new ListNode(prevWord);
				wordList.add(notPresent);
				//System.out.println("!!!!");
				//System.out.println(words[i]);
				notPresent.addNextWord(words[i]);
			}
		prevWord=words[i];
		//System.out.println("{{");
		//System.out.println(prevWord);
		}
		ListNode notPresent = new ListNode(prevWord);
		wordList.add(notPresent);
		notPresent.addNextWord(starter);
	 }
		
	
	/** 
	 * Generate the number of words requested.
	 */
	@Override
	public String generateText(int numWords) {
	    // TODO: Implement this method
		String currWord = starter;
		String Output = "";
		if(numWords>0){
		Output = currWord;
		}
		else{
			Output = "";	
		}
		int s=1;
		//System.out.println(numWords);
		if(wordList.isEmpty()){
			return "";
		}else{
		while(s<numWords){
			for(ListNode n: wordList){
				if(n.getWord().equals(currWord)){
					String p = n.getRandomNextWord(rnGenerator);
					//System.out.println(p);
					Output=Output+" "+p;
					//System.out.println(Output);
					currWord=p;
					s++;
					//System.out.println(s);
				}
			}
		}
		//System.out.println(Output);
		return Output;
		}
	}
	
	
	// Can be helpful for debugging
	@Override
	public String toString()
	{
		String toReturn = "";
		for (ListNode n : wordList)
		{
			toReturn += n.toString();
		}
		return toReturn;
	}
	
	/** Retrain the generator from scratch on the source text */
	@Override
	public void retrain(String sourceText)
	{
		// TODO: Implement this method.
		//Random generator;
		wordList.clear();
		starter = "";
		//rnGenerator = generator;
		train(sourceText);
	}
	
	// TODO: Add any private helper methods you need here.
	
	
	/**
	 * This is a minimal set of tests.  Note that it can be difficult
	 * to test methods/classes with randomized behavior.   
	 * @param args
	 */
	public static void main(String[] args)
	{
		// feed the generator a fixed random value for repeatable behavior
		MarkovTextGeneratorLoL gen = new MarkovTextGeneratorLoL(new Random(42));
		String textString = "Hello.  Hello there.  This is a test.  Hello there.  Hello Bob.  Test again.";
		String textString3="hi there hi Leo";
		//System.out.println(textString3);
		gen.train(textString3);
		System.out.println(gen);
		//System.out.println(textString3);
		gen.train(textString3);
		System.out.println(gen);
		//System.out.println(gen.wordList);
		System.out.println(gen.generateText(20));
		
		String textString2 = "You say yes, I say no, "+
				"You say stop, and I say go, go, go, "+
				"Oh no. You say goodbye and I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"I say high, you say low, "+
				"You say why, and I say I don't know. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"Why, why, why, why, why, why, "+
				"Do you say goodbye. "+
				"Oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello. "+
				"You say yes, I say no, "+
				"You say stop and I say go, go, go. "+
				"Oh, oh no. "+
				"You say goodbye and I say hello, hello, hello. "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello, "+
				"I don't know why you say goodbye, I say hello, hello, hello,";
		//System.out.println(textString2);
		gen.retrain(textString2);
		//System.out.println(gen);
		System.out.println(gen.generateText(20));
	}

}

/** Links a word to the next words in the list 
 * You should use this class in your implementation. */
class ListNode
{
    // The word that is linking to the next words
	private String word;
	
	// The next words that could follow it
	private List<String> nextWords;
	
	ListNode(String word)
	{
		this.word = word;
		nextWords = new LinkedList<String>();
	}
	
	public String getWord()
	{
		return word;
	}

	public void addNextWord(String nextWord)
	{
		nextWords.add(nextWord);
	}
	
	public String getRandomNextWord(Random generator)
	{
		// TODO: Implement this method
	    // The random number generator should be passed from 
	    // the MarkovTextGeneratorLoL class
		int randomInt = generator.nextInt(nextWords.size());
		String RandomNext = nextWords.get(randomInt);
	    return RandomNext;
	}

	public String toString()
	{
		String toReturn = word + ": ";
		for (String s : nextWords) {
			toReturn += s + "->";
		}
		toReturn += "\n";
		return toReturn;
	}
	
}


