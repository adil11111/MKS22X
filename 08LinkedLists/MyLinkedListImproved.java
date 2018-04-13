import java.util.Iterator;
public class MyLinkedListImproved<T> implements Iterable<T>{
    private class Node{

	private T data;
	private Node next;
	private Node previous;
    
	public Node(T value){
	    data=value;
	    next=null;
	    previous=null;
	}
	public Node getNext(){
	    return next;
	}
	public Node getPrev(){
	    return previous;
	}
	public T getValue(){
	    return data;
	}
	public void setNext(Node newNode){
	    next=newNode;
	}
	public void setPrev(Node newNode){
	    previous=newNode;
	}
	public void setValue(T newValue){
	    data= newValue;
	}
	public String toString(Node n){
	    String result= ""+ n.getValue();
	    return result;
	}
	    
    }
    private Node start;
    private Node end;
    private int size;

    private Node getNode(int index){
	Node initial= start;
	for (int i=0;i<index;i++){
	    initial=initial.getNext();
	}
	return initial;
    }
    public Iterator<T> iterator(){
	return new MLLIterator(this);
    }
    public MyLinkedListImproved(){
	start=null;
	end=null;
	size=0;
    }
    public void clear(){
	start=null;
	end=null;
	size=0;
    }
    public int size(){
	return size;
    }
    public T get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }
    public T set(int index, T value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node replaced = getNode(index);
	T oldValue=replaced.getValue();
	replaced.setValue(value);
	return oldValue;
    }

    public int indexOf(T value){
	int index=0;
	while (index<size()){
	    if (getNode(index).getValue().equals(value)){
		return index;
	    }
	    index++;
	}
	return -1;
    }

    public boolean add(T newData){
	Node adding = new Node(newData);
	if (size() == 0){
	start = adding;
	end=adding;
	}
        else if(size()==1){
	    end=adding;
	    start.setNext(adding);
	    adding.setPrev(start);   
	}
	else{
	    adding.setPrev(end);
	    end.setNext(adding);
	    end=adding;
	}
	size++;
	return true;
    }
    public void add(int index, T value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	Node adding =new Node(value);
	if (index==size()){
	    add(value);
	    return;
	}
	else if(index==0){
	    adding.setNext(start);
	    start.setPrev(adding);		    
	    start=adding;
	}
	else{
	    adding.setNext(getNode(index));
	    adding.setPrev(getNode(index-1));
	    getNode(index-1).setNext(adding);
	    getNode(index).setPrev(adding);
	    	}
	size++;
    }


    public boolean remove(T value){
	if (indexOf(value)==-1){
	    return false;
	}
	remove(indexOf(value));
        return true;
    }
    public T remove(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	T result = getNode(index).getValue();
	if (index==0){
	    start=getNode(1);
	}
	if (index==size()-1){
	    end=getNode(index-1);
	}
	else{
	    getNode(index+1).setPrev(getNode(index-1));	    
	    getNode(index-1).setNext(getNode(index+1));

	}
	size--;
	return result;
    }
    public String toString(){
	String result= "[";
	int i=0;
	for (;i<size()-1;i++){
	    result+=getNode(i).getValue() + ",";
	}
	result+=getNode(i).getValue();
	return result + "]";
    }
    public static void main(String[]args){
	MyLinkedListImproved<String> n = new MyLinkedListImproved<>();
        n.add("fish");
	System.out.println(n);
	MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();
        m.add(new Integer(0));
	System.out.println(m);
    }
}
