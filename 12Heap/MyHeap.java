public class MyHeap<T extends Comparable<T>>{
    T[] data;
    int size;
    boolean type;
    
    @SuppressWarnings("unchecked")
    public MyHeap(){
	data = (T[]) new Comparable[10];
	type=true;
    }
    
    public void heapify(T[] array){
	size = array.length;
	//System.out.println(size);
	data = array;
	for(int index = size - 1; index >= 0; index--){
	    int check = index*2+1;
	    if(check < size){
		pushDown(index);
	    }
	}
    }
    
    @SuppressWarnings("unchecked")
    public MyHeap(boolean bool){
	data = (T[]) new Comparable[10];
	if(bool){
	    type=true;
	}
	else{
	    type=false;
	}
    }
    //- true: construct empty max heap, false: construct empty min heap.
 
    public  void add(T s){
	if (size==data.length){
	    resize();
	}
	if(size==0){
	    data[size]=s;
	}
	else{
	    data[size]=s;
	    pushUp(size);
	}
	size++;
    }
    public T remove(){
	T result = data[0];
	//System.out.println(size-1);
	data[0]=data[size-1];
	data[size-1] = null;
	size--;
	//System.out.println(this);
	pushDown(0);
	return result;
    }
    
    public T peek(){
	return data[0];
    }
    public int size(){
	return size;
    }
    
    public void pushDown(int index){
	int greaterIndex;
	if(type){
	    //System.out.println(index);
	    //System.out.println(2*index+1 < size);
	    //System.out.println(size);
	    while((2*index+1 < size && data[index].compareTo(data[2*index+1]) < 0) ||(2*index+2 < size &&  data[index].compareTo(data[2*index+2]) < 0)){
		if(2*index+2>=size){
		    greaterIndex=2*index+1;
		}
		else if(data[2*index+1].compareTo(data[2*index+2])>=0){
		    greaterIndex=2*index+1;
		}
		else{
		    greaterIndex=2*index+2;
		}
		//System.out.println(index);
		//System.out.println(greaterIndex);
		swap(index,greaterIndex);
		index=greaterIndex;
		//System.out.println(this);
	    }
	}
	else{
	    while((2*index+1 < size && data[index].compareTo(data[2*index+1]) > 0) ||(2*index+2 < size &&  data[index].compareTo(data[2*index+2]) > 0)){
		if(2*index+2>=size){
		    greaterIndex=2*index+1;
		}
		else if(data[2*index+1].compareTo(data[2*index+2])<=0){
		    greaterIndex=2*index+1;
		}
		else{
		    greaterIndex=2*index+2;
		}
		swap(index,greaterIndex);
		index=greaterIndex;
	    }
	}
    }

    public void swap(int first,int second){
	T temp= data[first];
	data[first]=data[second];
	data[second]=temp;
    }
    private void pushUp(int index){
	if(type){
	    //System.out.println((((index-1)/2)>=0));
	    //System.out.println(data[index].compareTo(data[(index-1)/2])>=0);
	    while((((index-1)/2)>=0) && index!=0 &&  data[index].compareTo(data[(index-1)/2])>=0){
		//System.out.println("hello");
	    	swap(index,(index-1)/2);
		index=(index-1)/2;
	    }
	}
	else{
	    while((((index-1)/2)>=0) && index!=0 &&data[index].compareTo(data[(index-1)/2])<=0){
	    	swap(index,(index-1)/2);
		index=(index-1)/2;
	    }
	}
    }
    
    @SuppressWarnings("unchecked")
    private void resize(){
	T[] newData = (T[])new Comparable [data.length*2+1];
	for(int i=0;i<data.length;i++){
	    newData[i]=data[i];
	}
	data=newData;
    }
    
    public String toString(){
	String result= "[";
	int i=0;
	for (;i<size()-1;i++){
	    result+=data[i]+ ",";
	}
	result+=data[i];
	return result + "]";
    }
    
    public static void main(String[] args){
	MyHeap<Integer> temp = new MyHeap<Integer>();
	temp.add(6);
	temp.add(7);
	temp.add(9);
	temp.add(2);
	temp.add(12);
	temp.add(99);
	temp.add(0);
	temp.add(900);
	temp.add(2);
	temp.add(21);
	System.out.println(temp);
	Integer[] a = new Integer[10];
	a[0]=new Integer(6);
	a[1]=new Integer(7);
	a[2]=new Integer(9);
	a[3]=new Integer(2);
	a[4]=new Integer(12);
	a[5]=new Integer(99);
	a[6]=new Integer(0);
	a[7]=new Integer(900);
	a[8]=new Integer(2);
	a[9]=new Integer(21);

	MyHeap<Integer> temp2 = new MyHeap<Integer>();
	temp2.heapify(a);
	System.out.println(temp2);
		
    }    
}

