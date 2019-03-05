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
		
		/*	System.out.println(list1.get(0));
			System.out.println(list1.get(1));
			System.out.println(list1.get(2));
	*/
		int a = list1.remove(0);
		
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
		//test null element insertion, add should throw an exception
				try {
					shortList.add(null);
					fail("Check null pointer");
				}
				catch (NullPointerException e) {
					
				}
				
				// test empty list
					emptyList.add(5);
					emptyList.add(10);
					assertEquals((Integer) 5, emptyList.get(0));
					assertEquals((Integer) 10, emptyList.get(1));
				
			 // test longer list
					longerList.add(5);
					assertEquals((Integer) 5, longerList.get(longerList.size-1));
					longerList.add(10);
					assertEquals((Integer) 10, longerList.get(longerList.size-1));
	}
		
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// test an empty list
		
		assertEquals(0, emptyList.size());
		
		// test a shortlist
		assertEquals(2, shortList.size());
		// test a longlist
		assertEquals(10, longerList.size());
		//test a list1
		assertEquals(3, list1.size());
		//test after removal
		list1.remove(1);
		assertEquals(2, list1.size());
		//test empty list after addition
		emptyList.add(5);
		assertEquals(1, emptyList.size());
		//test shortlist after removal of 2 elements
		shortList.remove(0);
		shortList.remove(0);
		assertEquals(0, shortList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // add to non-existent index in an empty list
		try {
			emptyList.add(10, 3);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.add(-1, "A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		//test null element insertion, add should throw an exception
		try {
			shortList.add(0, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e1) {
			
		}
		
		// test adding at the beginning of an empty list
		
		emptyList.add(0, 5);
		emptyList.add(0, 3);
		//System.out.println(emptyList.get(0));
		//assertEquals((Integer) 5, emptyList.get(1));
		//assertEquals((Integer) 3, emptyList.get(0));
		emptyList.add(0, 10);
		assertEquals((Integer) 10, emptyList.get(0));
		assertEquals((Integer) 3, emptyList.get(1));
		assertEquals((Integer) 5, emptyList.get(2));

		
		}
		// test longer list contents
		longerList.add(4, 50);
		assertEquals((Integer)50, longerList.get(4));
		assertEquals((Integer)4, longerList.get(5));
		assertEquals((Integer)3, longerList.get(3));

		
		
		// test end insertion
		longerList.add(10, 40);
		assertEquals((Integer)40,longerList.get(10));
		assertEquals((Integer)9, longerList.get(11));
		assertEquals((Integer)8, longerList.get(9));

		}
		// TODO: implement this test
		
	
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    
		//check the 1st element
		String s = shortList.set(0, "C");
		//System.out.println(s);
		//System.out.println(shortList.get(0));
		String str = shortList.get(0);
		assertEquals("C", str);
		assertEquals("A", s);
		
		
		//check the last element
		s = shortList.set(1, "K");
		//str = shortList.get(1);
		assertEquals("Check last", "B", s);
		//assertEquals("Check last", "K", str);
		//check any element
		int i = longerList.set(5,50);
		assertEquals(5, i);
		assertEquals((Integer)50, longerList.get(5));
		
		//check exceptions
		try {
			shortList.set(-1, "M");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(2, "A");
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.set(1, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
			
		}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
