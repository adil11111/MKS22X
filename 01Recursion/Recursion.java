public class Recursion{
    public int fact(int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n==1){
	    return 1;
	}
	return n * fact(n-1);
    }

    public int fib (int n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	if (n < 2){
	    return n;
	}
	return Math.abs(fibHelp(1,n, 0,1));
    }

    public int fibHelp(int counter,int n,int previous,int current){
	if (counter==n){
	    return current;
	}
	return fibHelp(counter+1,n,current,previous+current);
    }
	
    
    /*public static void main(String[] args){
	Recursion test = new Recursion();
	System.out.println(test.fib(47));
    }*/
}

