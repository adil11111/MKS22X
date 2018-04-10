public class MyLinkedList{
    private class Node{

	private Integer data;
	private Node next;
	private Node previous;
    
	public Node(int value){
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
	public Integer getValue(){
	    return data;
	}
	public void setnext(Node newNode){
	    next=newNode;
	}
	public void setPrev(Node newNode){
	    previous=newNode;
	}
    
	public void setValue(Integer newValue){
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


    public MyLinkedList(){
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
    public Integer get(int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	return getNode(index).getValue();
    }
    public Integer set(int index, Integer value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	Node replaced = getNode(index);
	int oldValue=replaced.getValue();
	replaced.setValue(value);
	return oldValue;
    }

    public int indexOf(Integer value){
	int index=0;
	while (index<size()){
	    if (getNode(index).getValue().equals(value)){
		return index;
	    }
	    index++;
	}
	return -1;
    }

    //public boolean add(Integer newData);
    //public void add(int index, Integer value);//exceptions!

    //The remove methods can cause a problem, this is why we shouldn't 
    //use an int as the data, we need objects to distinguish between index and data
    //public boolean remove(Integer value);
    //public Integer remove(int index)
    public String toString(){
	String result= "[";
	for (int i=0;i<size();i++){
	    result+=getNode(i) + ",";
	}
	return result + "]";
    }
}
