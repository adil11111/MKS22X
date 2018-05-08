import java.util.*;

public class Sorts{
    /*public static void heapSort(Integer[] data){
	    MyHeap<Integer> heap = new MyHeap<Integer>();
	    heap.heapify(data);
	    for(int i=data.length-1;i>=0;i--){
		data[i]=heap.peek();
		heap.remove();     
	    }
	    }*/
    
    public static void heapSort(Integer[] data){
        MyHeap<Integer> n = new MyHeap<>();

        for(int i = 0; i < data.length; i++){
            n.add(data[i]);
        }
        while(n.size() != 0){
            data[n.size() - 1] = n.remove();
        }
    }
    public static void main(String[] args){
	Integer[] a = new Integer[10];
	a[0]=new Integer(99);
	a[0]=new Integer(12);
	a[0]=new Integer(9);
	a[0]=new Integer(1);
	a[0]=new Integer(8);
	a[0]=new Integer(0);
	a[0]=new Integer(2);
	a[0]=new Integer(5);
	a[0]=new Integer(11);
	a[0]=new Integer(18);
	heapSort(a);
	System.out.println(a);

    }
}
