import java.util.*;
import java.io.*;
public class Quick{

    /*public static int partition ( int [] data, int start, int end){
	Random gen = new Random();
	int num= start + gen.nextInt(end - start + 1);
	swap(data,start,num);
	int small=start+1;
	int large=end;
	while (small <= large){
	    if(data[small]>data[start]){
		swap(data,small,large);
		large--;
	    }
	    else{
		small++;
	    }
	}
	swap(data,start,large);
	return large;	
	}*/
    public static int partition ( int [] data, int start, int end){
	Random gen = new Random();
	int num= start + gen.nextInt(end - start + 1);
	swap(data,start,num);
	int small=start+1;
	int large=end;
	int index=small;
	while (small <= large){
	    if(data[index]==data[start]){
		index++;
	    }
	    else if(data[index]>data[start]){
		swap(data,index,large);
		large--;
	    }
	    else{
		swap(data,index,small);
		small++;
		index++;
	    }
	}
	swap(data,start,large);
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
    
    public static int quickSelect(int[]ary, int k){
	int small=0;
	int large= ary.length-1;
	int i= partition(ary,small,large);
    	while (i !=k){
	    if (i < k){
		small=i+1;
		i=partition(ary,small,large);
	    }
	    else{
		large=i-1;
		i=partition(ary,small,large);
	    }
	}
	return ary[i];
    }
    public static void main(String[] args){
	int[] data= { 2, 10, 15, 23, 0,  5};
        //System.out.println(partition(data,0,7));
	System.out.println(quickSelect(data,0));
		System.out.println(quickSelect(data,1));
	System.out.println(quickSelect(data,2));
	System.out.println(quickSelect(data,3));
	System.out.println(quickSelect(data,4));
	System.out.println(quickSelect(data,5));
	    
    }
}
