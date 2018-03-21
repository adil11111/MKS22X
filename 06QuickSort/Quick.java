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
    public static void quickH(int[] ary,int small,int large){
	if(small<large){   
	    int half = partition(ary, small, large);
	    quickH(ary, small, half - 1);
	    quickH(ary, half + 1, large);
	}
    }
    public static void main(String[] args){
	int[] data= {0,0,0,1,1,1,2,2,2,0,0,0,1,1,1,2,2,2,0,1,1,2,2,2,3,4,2,3,4,5,2,1,3,4,2,1,3,2,3,4,1,2,3,2,3,2,1,1,3,2,4,5,6,2,1,3};
	Random randgen= new Random();
                //System.out.println(partition(data,0,7));
	//System.out.println(quickSelect(data,0));
	quickSort(data);
	for(int i=0;i<data.length;i++){
	    System.out.println(data[i]);
	}
	/*for (int i=0;i<data.length;i++){
	    System.out.println(data[i]);
	    }*/
    }
}
