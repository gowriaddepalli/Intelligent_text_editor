package spelling;

import java.util.TreeSet;

/**
 * @author UC San Diego Intermediate MOOC team
 *
 */
public class DictionaryBST implements Dictionary 
{
   private TreeSet<String> dict;
	
    // TODO: Implement the dictionary interface using a TreeSet.  
 	// You'll need a constructor here
   public DictionaryBST(){
	   this.dict = new TreeSet<String>();
   }
	
    
    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	String word1 = word.toLowerCase();
    	boolean flag =false;
    	if(!dict.isEmpty()){
        	for(String s: dict){
        	if(s.equals(word1)){
        		//System.out.println("flase");
        		flag = false;
        		break;
        	}else{
        		flag=true;
        		//System.out.println("ture");
        	}
        	}
        	}
    	if(flag || dict.isEmpty())
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
