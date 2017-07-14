/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> emptyList1;
	MyLinkedList<Integer> emptyListNew;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		
		emptyList = new MyLinkedList<Integer>();
		emptyList1 = new MyLinkedList<Integer>();
		emptyListNew = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		//assertEquals("Check 3 element",(Integer)9, longerList.get(9));
		//assertEquals("Check second", "B", shortList.get(0));
		
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
		assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			 emptyList.remove(-1);
			 fail("Check IndexOutOfBounds Exception");
			}
			catch (IndexOutOfBoundsException e) {
					}
		try {
			 emptyList.remove(34);
			 fail("Check IndexOutOfBounds Exception");
			}
			catch (IndexOutOfBoundsException e) {
					}
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		//checking for adding null values in an empty list
		try {
			emptyList.add(null);
			fail("Check null Pointer Exception");
		}
		catch (NullPointerException e) {
			
		}
		//checking for adding null values in a list of elements
		try {
			list1.add(null);
			fail("Check null Pointer Exception");
			}
		catch (NullPointerException e) {
				}
		//checking for adding element at last in a list of elements
		boolean a =longerList.add(30);
		assertEquals("add: check a is correct ", true, a);
		assertEquals("add: check element 10 is correct ", (Integer)30, longerList.get(10));
		assertEquals("add: check size is correct ", 11, longerList.size());
		
		//checking for adding element at last in an empty list
		boolean a1 =emptyList.add(3);
		assertEquals("add: check a1 is correct ", true, a1);
		assertEquals("add: check element 0 is correct ", (Integer)3, emptyList.get(0));
		assertEquals("add: check size is correct ", 1, emptyList.size());
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		longerList.add(2,70);
		assertEquals("add: check size is correct ", 11, longerList.size());
		boolean a1 =emptyList.add(13);
		assertEquals("add: check size is correct ", 1, emptyList.size());
		emptyList1 = new MyLinkedList<Integer>();
		assertEquals("check size is correct ", 0, emptyList1.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		//checking for adding null values in an empty list at a certain index.
		try {
			emptyListNew.add(1,null);
			fail("Check null Pointer Exception and IndexOutOfBoundsException");
		}
		catch (NullPointerException e) {
			
		}
        catch (IndexOutOfBoundsException e1) {
			
		}
		
		//checking for adding null values in a list of elements
		try {
			list1.add(2,null);
			fail("Check null Pointer Exception");
			}
		catch (NullPointerException e) {
				}
		
		//checking for adding values in an list at an inappropriate index.
		try {
			 emptyList.add(11,20);
			 fail("Check IndexOutOfBounds Exception");
			}
			catch (IndexOutOfBoundsException e) {
					}
		
		//checking for adding values in an list at an inappropriate index.
		try {
			list1.add(-2,78);
			fail("Check IndexOutOfBounds Exception");
					}
			catch (IndexOutOfBoundsException e) {
						}
		
		//checking for adding element at certain index in a list of elements
				longerList.add(2,90);
				assertEquals("add: check element added at position 2 is correct ", (Integer)90, longerList.get(2));
				assertEquals("add: check size is correct ", 11, longerList.size());
				
				//checking for adding element at last in an empty list
				emptyListNew.add(0,55);
				assertEquals("add: check element added at position 0 is correct ", (Integer)55, emptyListNew.get(0));
				assertEquals("add: check size is correct ", 1, emptyListNew.size());
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		try {
			emptyListNew.set(1,null);
			fail("Check null Pointer Exception and IndexOutOfBoundsException");
		}
		catch (NullPointerException e) {
			
		}
        catch (IndexOutOfBoundsException e1) {
			
		}
		
		//checking for adding null values in a list of elements
		try {
			list1.set(2,null);
			fail("Check null Pointer Exception");
			}
		catch (NullPointerException e) {
				}
		
		//checking for adding values in an list at an inappropriate index.
		try {
			 emptyList.set(11,20);
			 fail("Check IndexOutOfBounds Exception");
			}
			catch (IndexOutOfBoundsException e) {
					}
		
		//checking for adding values in an list at an inappropriate index.
		try {
			list1.set(-2,78);
			fail("Check IndexOutOfBounds Exception");
					}
			catch (IndexOutOfBoundsException e) {
						}
		
		//checking for adding element at last in a list of elements
				int a =longerList.set(2,12);
				assertEquals("set: check a is correct ", 2, a);
				assertEquals("set: check element 2 is correct ", (Integer)12, longerList.get(2));
				assertEquals("set: check size is correct ", 10, longerList.size());
				
	}
	
	
	// TODO: Optionally add more test methods.
	
}
