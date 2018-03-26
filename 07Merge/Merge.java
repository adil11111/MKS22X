public class Merge{
     public static void merge(int[] data,int temp[],int lo,int mid,int hi){
	int first=lo;
	int second=mid+1;
	for(int i=lo;i<=hi;i++){
	    if(first<=mid && second<= hi && temp[first]<=temp[second]){
		data[i]=temp[first];
		first++;
	    }
	    else if(first<=mid && second<= hi && temp[second]<=temp[first]){
		data[i]=temp[second];
		second++;
	    }
	    else if(first>mid){
		data[i]=temp[second];
		second++;
	    }
	    else if(second>hi){
		data[i]=temp[first];
		first++;
	    }
	}
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
    public static void mergesort(int[] data){
	int[] temp=new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    
    private static void msort(int[]data, int[]temp, int lo, int hi){
        if (hi-lo <= 20){
	    insertionSort(data, lo, hi);
	    return;
	}
	for(int i=lo;i<hi+1;i++){
	    temp[i]=data[i];
	}
	int mid=(lo+hi)/2;
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,hi);
    }

    public static void main(String[]args){

	    
    }	    
}
