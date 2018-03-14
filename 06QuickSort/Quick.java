import java.util.*;
import java.io.*;
public class Quick{
    public static int pivot;
    public static int partition ( int [] data, int start, int end){
	Random gen = new Random();
	int num= start + gen.nextInt(end - start + 1);
	System.out.println(data[num]);
	swap(data,0,num);
	pivot=data[0];
	int small=start+1;
	int large=end;
	while (small <= large){
	    if(data[small]>=pivot){
		swap(data,small,large);
		large--;
	    }
	    else{
		small++;
	    }
	}
	swap(data,0,large);
	return large;
	
    }
    
    public static void swap(int[] data, int first, int second){
	int temp = data[second];
	data[second]=data[first];
	data[first]=temp;
    }
    public static String printer(int[] array){
	String gatherer="";
	for (int i=0;i<array.length;i++){
	    gatherer+=array[i]+ ",";
	}
	return gatherer;
    }
    public static void main(String[] args){
	int[] data= {999,999,999,4,1,0,3,2,999,999,999,8,76,4,3,90,56,67,74};
        System.out.println(partition(data,0,18));
	System.out.println(printer(data));
	    
    }
}
