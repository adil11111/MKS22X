public class RunningMedian{
    private MyHeap<Double> min;
    private MyHeap<Double> max;
    private int size;
    
    public RunningMedian(){
	max = new MyHeap<Double>();
	min = new MyHeap<Double>(false);
	size=0;
    }
    //- makes an empty container for Doubles.

    public void add(Double num){
	size++;
    }
    //- insert a Double into the data structure.

    public Double getMedian(){
	return 0.0;
    }
    //- return the current median, throws NoSuchElementException when size is 0.

    public int size(){
	return size;
    }
}
