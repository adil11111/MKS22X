import java.util.*;
public class Calculator{	

    private static LinkedList<String> stack = new LinkedList<>();

    public static double eval(String s){
	String[] array = s.split(" ", -1);
        for(int i=0;i<array.length;i++){
	    if(array[i].equals("+")){
		double ans = Double.parseDouble(pop(stack))+Double.parseDouble(pop(stack));
		push(stack,"" + ans );
	    }
	    else if(array[i].equals("-")){
		double first = Double.parseDouble(pop(stack));
		double ans = Double.parseDouble(pop(stack))-first;
		push(stack,"" + ans );
	    }
	    else if(array[i].equals("*")){
	        double ans = Double.parseDouble(pop(stack))*Double.parseDouble(pop(stack));
		push(stack,"" + ans );
	    }
	    else if(array[i].equals("/")){
		double first = Double.parseDouble(pop(stack));
		double ans = Double.parseDouble(pop(stack))/first;
		push(stack,"" + ans );
	    }
	    else if(array[i].equals("%")){
		double first = Double.parseDouble(pop(stack));
		double ans = Double.parseDouble(pop(stack))%first;
		push(stack,"" + ans );
	    }
	    else{
		push(stack,array[i]);
	    }
	}
	return Double.parseDouble(peek(stack));	   
    }

    public static void push(LinkedList<String> data,String s){
	data.add(s);
    }
    public static String  pop(LinkedList<String> data){
	String res = data.get(data.size()-1);
	data.remove(data.size()-1);
	return res;
    }
    public static String peek(LinkedList<String> data){
	return data.get(data.size()-1);
    }
    
    public static void main(String[] args){
	System.out.println(eval("10 3.0 %")); //is 12.0;
	System.out.println(eval("11 3 - 4 + 2.5 *")); //is 30.0;
	System.out.println(eval("8 2 + 99 9 - * 2 + 9 -"));
    }
}
