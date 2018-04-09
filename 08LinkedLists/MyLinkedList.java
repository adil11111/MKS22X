public class MyLinkedList{
    private class Node{

    private int data;
    private Node next;
    private Node previous;
    
    public Node(int value){
	data=value;
	next=null;
	previous=null;
    }
    public Node getnext(){
	return next;
    }
    public Node getPrev(){
	return previous;
    }
    public int getValue(){
	return data;
    }
    public void setnext(Node newNode){
	next=newNode;
    }
    public void setPrev(Node newNode){
	previous=newNode;
    }
    public void setValue(int newValue){
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

    //  private Node getNode(int index){
    //	
    // }
}
