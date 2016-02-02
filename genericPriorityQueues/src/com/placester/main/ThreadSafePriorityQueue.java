package com.placester.main;

//NOTE: we are aware that there is a PriorityQueue in
//java.util. Please do not use this. 
//If you are doing this test at home, please do not use any containers from
//java.util in your solution, as this is a test of data
//structure knowledge, rather than a test of java library knowledge.
//If you are doing it in the office, please ask the person testing you if you are going to
//use any built in collections other than arrays.
/*
* The task is as follows: implement this class as you see fit, and get the unit test in
* src/test/com/placester/test/PriorityQueueTest to pass. This class
* must allow dynamic resizing as elements are added. What the
* strategy is to do this is entirely up to you modulo the previously
* stated constraints.
* 
* Feel free to use anything from Java.util.Arrays (e.g., you don't need to implement
* your own sort if you don't want to).
*/
@SuppressWarnings("unchecked")
public class ThreadSafePriorityQueue<X> implements SimpleQueue<Priority<X>>{
	
	private static final int CAPACITY = 2;
	private Object[] heap;
	private int size;
	
	
    public ThreadSafePriorityQueue()
    {
        initialize();
    }
     
    public void initialize()
    {
    	heap = new Object[CAPACITY];
    }
    
    @Override
    public int size()
    {
    	 return size;
    }

    @Override
    public boolean isEmpty()
    {
    	return size == 0;
    }

    @Override
    public void clear()
    {
		size = 0;
		heap = new Object[CAPACITY];        
    }

	@Override
    public boolean add(Priority<X> e)
    {
		if(size == heap.length - 1) doubleSize();
		int pos = ++size;
		
	    for(; pos > 1 && e.priority  > ((Priority<X>)heap[pos/2]).priority ; pos = pos/2 ){
	    	heap[pos] = heap[pos/2];
	    }         
        
	    heap[pos] = e;		        
        return true;       
    }

    @Override
    public Priority<X> poll()
    {
	    if (size == 0) return null;
	    Priority<X> min = (Priority<X>) heap[1];
	    heap[1] = heap[size--];
	    percolatingDown(1);
	    return min;		  	
    }

    @Override
    public Priority<X> peek()
    {
    	return (Priority<X>)heap[1];
    }

    @Override
    public boolean contains(Priority<X> x)
    {
	    if (size == 0) throw new RuntimeException();
	    int pos = 1;
        while ( pos <= size)
        {
        	if( x.equals(((Priority<X>)heap[pos]).item())){
        		return true;
        	}
        	pos++;
        }
		return false;    	

    }
	private void doubleSize(){
		
		 Object [] old =  heap;
		 heap = new Object[heap.length * 2];
		 System.arraycopy(old, 1, heap, 1, size);
		 
	}
	private void percolatingDown(int k)
	{
	      Priority<X> tmp = (Priority<X>) heap[k];
	      int child;

	      for(; 2*k <= size; k = child)
	      {
	         child = 2*k;
	         if(child != size &&	        		 
	            ((Priority<X>)heap[child]).priority < ((Priority<X>)heap[child + 1]).priority) child++;
	         if(tmp.priority < ((Priority<X>)heap[child]).priority)  heap[k] = heap[child];
	         else
	                break;
	      }
	      heap[k] = tmp;
	}  
}
