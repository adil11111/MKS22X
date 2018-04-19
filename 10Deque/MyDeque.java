public class MyDeque<E>{

    private E[] data;
    private int size;
    private int first;
    private int last;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	data =(E[])new Object[10];
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	data =(E[])new Object[initialCapacity];
    }
    public int size(){
	return size;
    }
    
    public void addFirst(Object E){
	if(E == null){
	    throw new NullPointerException();
	}
    }
    public void addLast(Object E){
	if(E == null){
	    throw new NullPointerException();
	}
    }
    /* public E removeFirst(){
    }
    public E removeLast(){
    }
    public E getFirst(){
    }
    public E getLast(){
    }*/

}
