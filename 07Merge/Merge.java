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
    public static void selectionSort(int[] data){
	if (data.length==0 || data.length==1){
	    return;
	}
	for (int i=0;i<data.length;i++){
	    int min=data[i];
	    for (int current=i;current<data.length;current++){
		if (data[current]<min){
		    min=data[current];
		    data[current]=data[i];
		    data[i]=min;
		}
	    }
	}
    }
    public static void mergesort(int[] data){
	int[] temp=new int[data.length];
	msort(data,temp,0,data.length-1);
    }
    
    private static void msort(int[]data, int[]temp, int lo, int hi){
	if (lo>=hi){
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
}
