public class RunningMedian{
    private MyHeap<Double> min;
    private MyHeap<Double> max;
    private int size;
    private Double median;

    
    public RunningMedian(){
	max = new MyHeap<Double>();
	min = new MyHeap<Double>(false);
	size=0;
    }
    //- makes an empty container for Doubles.

    public void add(Double num){
	if(size==0){
	    max.add(num);
	    median=num;
	}
	else{
	    if (num>median){
		min.add(num);
	    }
	    else{
		max.add(num);
	    }
	}
	if((max.size() - min.size()) >=2){
	    Double result = max.remove();
	    min.add(result);
	}
	else if((min.size() - max.size()) >= 2){
	    Double result = min.remove();
	    max.add(result);
	}
	size++;
    }
    //- insert a Double into the data structure.
    public double getMedian(){
	if (min.size()>max.size()){
	    median = min.peek();
	}

	else if(max.size()> min.size()){
	    median = max.peek();
	}
	else{
	    median = (min.peek()+max.peek()) / 2;
	}
	return median;	
    }
    //- return the current median, throws NoSuchElementException when size is 0.

    public int size(){
	return size;
    }
}
