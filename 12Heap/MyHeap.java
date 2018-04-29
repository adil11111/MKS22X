public class MyHeap{
    String[] data;
    int size;
    boolean type;
    
    public MyHeap(){
	data = new String[10];
	type=true;
    }
    //- construct empty max heap
    public MyHeap(boolean bool){
	data = new String[10];
	if(bool){
	    type=true;
	}
	else{
	    type=false;
	}
    }
    //- true: construct empty max heap, false: construct empty min heap.
 
    public  void add(String s){
	if (size==data.length){
	    resize();
	}
	if(size==0){
	    data[size]=s;
	}
	else{
	    data[size]=s;
	    pushUp();
	}
	size++;
    }
    public String remove(){
	String result = data[0];
	//System.out.println(size-1);
	data[0]=data[size-1];
	data[size-1] = null;
	size--;
	//System.out.println(this);
	pushDown();
	return result;
    }
    
    public String peek(){
	return data[0];
    }
    public int size(){
	return size;
    }
    private void pushDown(){
	int index=0;
	int greaterIndex;
	if(type){
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
	String temp= data[first];
	data[first]=data[second];
	data[second]=temp;
    }
    private void pushUp(){
	int index=size;
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
    private void resize(){
	String[] newData = new String [data.length*2+1];
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
    }    
}

