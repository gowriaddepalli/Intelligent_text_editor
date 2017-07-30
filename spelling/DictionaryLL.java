package spelling;

import java.util.LinkedList;

/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
    // TODO: Add a constructor
      public DictionaryLL(){
    	this.dict = new LinkedList<String>();
      }

    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	String word1 = word.toLowerCase();
    	//System.out.println("%%%%");
    	boolean flag = false;
    	
    	for(String s: dict){
    	if(s.equals(word1)){
    		//System.out.println("flase");
    		flag = true;
    	}
    	}
    	
    	if(!flag)
    	{
    		dict.add(word1);
    		//System.out.println("added");
    	}
		return !flag;
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
        return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
        //TODO: Implement this method
    	String s1 = s.toLowerCase();
    	boolean flag = false;
    	for(String word: dict){
    		if(s1.equals(word)){
    			flag=true;
    			break;
    		}else{
    			flag=false;
    		}
    	}
        return flag;
    }

    
}
