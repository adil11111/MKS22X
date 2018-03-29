public class Node{

    private int data;
    private Node next;
    private Node previous;
    
    public Node(int value, Node after, Node before ){
	data=value;
	next=after;
	previous=before;
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
    /*public String toString(){
      }*/
}
