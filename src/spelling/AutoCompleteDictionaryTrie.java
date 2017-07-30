package spelling;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    private int count;

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should convert the 
	 * string to all lower case before you insert it. 
	 * 
	 * This method adds a word by creating and linking the necessary trie nodes 
	 * into the trie, as described outlined in the videos for this week. It 
	 * should appropriately use existing nodes in the trie, only creating new 
	 * nodes when necessary. E.g. If the word "no" is already in the trie, 
	 * then adding the word "now" would add only one additional node 
	 * (for the 'w').
	 * 
	 * @return true if the word was successfully added or false if it already exists
	 * in the dictionary.
	 */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		String word1=word.toLowerCase();
		char p[] = word1.toCharArray();
		boolean flag = false;
		TrieNode curr = root;
		//System.out.println("^^^");
		//System.out.println(curr.getText());
		TrieNode next = null;
		//System.out.println("######");
		//System.out.println(word1);
		if(isWord(word1)){
			flag=false;
			//System.out.println("$$");
			//System.out.println(word1);
		}else{
		for (Character c : p){
			next=curr.getChild(c);
			if(next==null){
				next = curr.insert(c);
				flag = true;
			}
			//System.out.println(next.getText());
			curr = next; 
		}
		curr.setEndsWord(true);
		count++;}
	    return flag;
	}
	
	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method 
		/*
		TrieNode curr = root;
		TrieNode next = null;
		int count=0;
		System.out.println(curr.getValidNextCharacters());
		for (Character c : curr.getValidNextCharacters()) {
			System.out.println(curr.getValidNextCharacters());
			System.out.println("(((");
			System.out.println(c);
 			next=curr.getChild(c);
 			if(next==null){
 				System.out.println("++");
 				break;
 			}
 			if(next!=null && next.endsWord()){
 				count++;
 				System.out.println(count);
 			}	
 			System.out.println("$$");
 			System.out.println(curr.getText());
 			System.out.println(next.getText());
 			System.out.println(next.endsWord());
 			curr=next;
		}
		
	   return count;
	   */
         return count;
	}
	
	
	/** Returns whether the string is a word in the trie, using the algorithm
	 * described in the videos for this week. */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		TrieNode curr = root;
		//System.out.println(curr.getText());
		String word1 = s.toLowerCase();
		boolean flag = false;
		if(!word1.isEmpty()){
		char p[] = word1.toCharArray();
		for(Character c: p){
			TrieNode next = curr.getChild(c);
			if(next == null){
				flag = true;
				break;
			}
			if(!next.endsWord()){
				flag=true;
			}else{
				flag=false;
			}
			//System.out.println(next.getText());
			curr=next;
		}
		}else{
			flag =true;
		}
		return !flag;
	}

	/** 
     * Return a list, in order of increasing (non-decreasing) word length,
     * containing the numCompletions shortest legal completions 
     * of the prefix string. All legal completions must be valid words in the 
     * dictionary. If the prefix itself is a valid word, it is included 
     * in the list of returned words. 
     * 
     * The list of completions must contain 
     * all of the shortest completions, but when there are ties, it may break 
     * them in any order. For example, if there the prefix string is "ste" and 
     * only the words "step", "stem", "stew", "steer" and "steep" are in the 
     * dictionary, when the user asks for 4 completions, the list must include 
     * "step", "stem" and "stew", but may include either the word 
     * "steer" or "steep".
     * 
     * If this string prefix is not in the trie, it returns an empty list.
     * 
     * @param prefix The text to use at the word stem
     * @param numCompletions The maximum number of predictions desired.
     * @return A list containing the up to numCompletions best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
    	 String prefix1 = prefix.toLowerCase();
 		 boolean flag = false;
    	 TrieNode curr =root;
    	 LinkedList<TrieNode> predictWords=new LinkedList<TrieNode>();  
    	 LinkedList<String> completions=new LinkedList<String>(); 
    		 char p[] = prefix1.toCharArray();
    			for(Character c: p){
    				TrieNode next = curr.getChild(c);
    				if(next == null){
    					flag = true;
    					return completions;
    				}
    				//System.out.println(next.getText());
    				curr=next;
    			}
    		if(curr.endsWord()){
    			predictWords.add(curr);
    		}
    		Set<Character> s = curr.getValidNextCharacters();
    		for(char c:s)
 			{ 
    		TrieNode move =curr.getChild(c);
    		if(move==null){
    			break;
    		}
    		predictWords.add(move);
    		
 			//curr =move;
 			//System.out.println(q.size() + "!!@");
 			} 
    		
    		while(!predictWords.isEmpty() && (completions.size()!=numCompletions)){
    			{
    				TrieNode sw = predictWords.remove();
    				if(sw.endsWord()){
    				completions.add(sw.getText());
    				}
    				
    				Set<Character> sm = sw.getValidNextCharacters();
    	    		for(char c:sm)
    	 			{ 
    	    		TrieNode move1 =sw.getChild(c);
    	    		if(move1==null){
    	    			break;
    	    		}
    	    		predictWords.add(move1);
    	 			}
    	    		
    			}
 
    		}
    	 
         return completions;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	
 	
 	

	
}