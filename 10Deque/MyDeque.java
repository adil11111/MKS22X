import java.util.*;
public class MyDeque<E>{

    private E[] array;
    private int size;
    private int front;
    private int back;
    
    @SuppressWarnings("unchecked")
    public MyDeque(){
	array =(E[])new Object[10];
	size=0;
	front=0;
	back=0;
    }
    
    @SuppressWarnings("unchecked")
    public MyDeque(int initialCapacity){
	if(initialCapacity < 0){
	    throw new IllegalArgumentException();
	}
	array =(E[])new Object[initialCapacity];
	size=0;
	front=0;
	back=0;
    }
    public int size(){
	return size;
    }
    @SuppressWarnings("unchecked")
    public void resize(){
	if(size()==array.length){
	    E[] temp = (E[])new Object[array.length * 2];
	    int counter = 0;
	    while (counter < array.length){
		temp[counter]=array[(front+counter)%array.length];
		counter ++;
	    }
	    array=temp;
	    front=0;
	    back=counter-1;
	}
    }
    public void addFirst(E elem){
	if(elem == null){
	    throw new NullPointerException();
	}
	resize();
	if (size==0){
	    array[front]=elem;
	    //System.out.println(0);
	}
	/*else if(front == 0 && back == 0){
	  array[1]=elem;
	  front=0;
	  back=1;
	  }*/
	else if (front == 0){
	    array[array.length-1]=elem;
	    front=array.length-1;
	    //System.out.println(1);

	}
	else{
	    array[front-1]=elem;
	    front--;
	    //System.out.println(2);

	}
	size++;
	//System.out.println(3);	 
    }

    public void addLast(E elem){
	if(elem == null){
	    throw new NullPointerException();
	}
	resize();
	if (size==0){
	    array[front]=elem;
	}
	/*else if(front == 0 && back == 0){
	  array[1]=elem;
	  front=0;
	  back=1;
	  }*/
	else if ( back==array.length-1){
	    array[0]=elem;
	    back=0;
	}
	else{
	    array[back+1]=elem;
	    back++;	    
	}
	size++;
    }

    public E removeFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E result = array[front];
	if (front == array.length-1){
	    array[front]=null;
	    front=(front+1)%array.length;
	}
	else{
	    array[front]=null;
	    front++;
	}
	size--;
	return result;
    }
    public E removeLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	E result = array[back];
	if (back==0){
	    array[back]=null;
	    back=array.length-1;
	}
	else{
	    array[back]=null;
	    back--;
	}
	size--;
	return result;
    }
    public E getFirst(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return array[front];
    }
    public E getLast(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	return array[back];
    }
    public static void main(String[] args) {
	MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
	ArrayList<String> b = new ArrayList<>();

	int size = Integer.parseInt(args[0]);
	for(int i = 0; i < size; i++){
	    int temp = (int)(Math.random() * 1000);
	    if(temp % 2 == 0){
		a.addFirst("" + temp);
		a1.addFirst("" + temp);
		b.add(0, "" + temp);
	    }
	    else{
		a.addLast("" + temp);
		a1.addLast("" + temp);
		b.add("" + temp);
	    }
	}

	int index = 0;
	boolean hasError = false;
	String errorEvaluation = "Errors found at these indices: ";
	for (String x : b){
	    if (!(x.equals(a.getFirst()))){
		System.out.println("The getFirst() function is incorrect at index " + index);
		hasError = true;
	    }
	    if (!(x.equals(a.removeFirst()))){
		System.out.println("There is an error at index " + index);
		errorEvaluation += index + ", ";
		hasError = true;
	    }
	    index++;
	}


	if(hasError){
	    errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
	    System.out.println(errorEvaluation);
	    System.out.println("MyDeque: " + a1);
	    System.out.println("Actual Deque: " + b);
	}
	else{
	    System.out.println("Your deque is bug-free!");
	    //System.out.println("MyDeque: " + a1);
	    //System.out.println("Actual Deque: " + b);
	}
    }
}
