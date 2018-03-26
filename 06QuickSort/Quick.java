import java.util.*;
import java.io.*;
public class Quick{
    /*
    public static int partition ( int [] data, int start, int end){
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
	}
    */
    public static int partition ( int [] data, int start, int end){
	Random gen = new Random();
	int num= start + gen.nextInt(end - start + 1);
	swap(data,start,num);
	int small=start+1;
	int large=end;
	int index=small;
	while (index <= large){
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
    public static void quickSort(int[] ary){
	quickH(ary,0,ary.length-1);
    }
    public static void insertionSort(int[] data,int lo,int hi){
	int index=lo+1;
	while(index<=hi){
	    int counter=index;
	    while(counter>lo && data[index]<data[counter-1]){
		counter--;
	    }
	    move(data,index,counter);
	    index++;
	}
    }
    public static void	move(int[] data, int oldindex,int newindex){
	int temp=data[oldindex];
	for (int i=oldindex;i>newindex;i--){
	    data[i]=data[i-1];
	}
	data[newindex]=temp;		 
    }
    public static void quickH(int[] ary,int small,int large){
	if (large-small <=20){
	    insertionSort(ary,small,large);
	    return;
	}
	if(small<large){   
	    int half = partition(ary, small, large);
	    quickH(ary, small, half - 1);
	    quickH(ary, half + 1, large);
	}
    }
    public static void main(String[] args){
        
    }
}
