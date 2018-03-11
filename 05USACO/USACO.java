import java.io.*;
import java.util.*;

public class USACO{

    public static int[][] map;
    public static int bronze(String filename){
	int[] instructions = new int[4];
	ArrayList<Integer> nums = new ArrayList<Integer>();
        try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    while (in.hasNextInt()){
		nums.add(in.nextInt());
	    }
	}
	catch(FileNotFoundException e){
	}
	    for (int i=0;i<4;i++){
		instructions[i]=nums.get(0);
		nums.remove(0);
	    }
	    
	    map = new int[instructions[0]][instructions[1]];
	    int counter= 0;
	    for(int r=0;r<map.length;r++){
		for(int c=0;c<map[0].length;c++){
		    map[r][c]=nums.get(0);
		    counter++;
		    nums.remove(0);
		}
	    }
	    
	    int[][] commands=new int[instructions[3]][3];  
	    int index=0;
	    for(int r=0;r<commands.length;r++){
		for(int c=0;c<commands[0].length;c++){
		    //System.out.println(nums.get(0));
		    commands[r][c]=nums.get(0);
		    index++;
		    nums.remove(0);
		}
	    }
	    
	    for (int i=0;i<commands.length;i++){
		stomper(commands[i][0],commands[i][1],commands[i][2]);
	    }
	    
	    int finalDepth=instructions[2];
	    for (int r=0;r<map.length;r++){
		for(int c=0;c<map[0].length;c++){
		    if(map[r][c]>finalDepth){
			map[r][c]=0;
		    }
		    else{
			map[r][c]=finalDepth-map[r][c];
		    }
		}
	    }
	    
	    int sum=0;
	    for (int r=0;r<map.length;r++){
		for(int c=0;c<map[0].length;c++){
		    sum+=map[r][c];
		}
	    }
	    return sum * 72 * 72;
    }
    public static void stomper(int r,int c,int d){
	int max=0;
	int realR=r-1;
	int realC=c-1;
	for(int row=0;row<3;row++){
	    for(int col=0;col<3;col++){
		//System.out.println(map[realR+row][realC+col]);			    
		if (map[realR+row][realC+col]>max){
		    max=map[realR+row][realC+col];
		}
	    }
	}
	int depthNum=max-d;
	//System.out.println(depthNum);
	for(int row=0;row<3;row++){
	    for(int col=0;col<3;col++){
		if(map[realR+row][realC+col]>depthNum){
		    map[realR+row][realC+col]=depthNum;
		}
	    }
	}
    }
    public static int silver(String filename){
	int rows;
	int cols;
	int time;
	String gatherer="";
	char[][] map;
	int startRow;
	int endRow;
	int startCol;
	int endCol;
	try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    rows=in.nextInt();
	    cols=in.nextInt();
	    time=in.nextInt();
	    in.nextLine();
	    String line= "";
	    while(in.hasNextLine()){
		line=in.nextLine();
		gatherer= gatherer + line;
	    }
	    map= new char[rows][cols];
	    int index=0;
	    for (int r=0;r<rows;r++){
		for (int c=0;c<cols;c++){
		    map[r][c]=gatherer.charAt(index);
		    index++;
		}
	    }
	    String[] nums=line.split(" ");
	    endCol = Integer.parseInt(nums[0])-1;
	    endRow = Integer.parseInt(nums[1])-1;
	    startCol = Integer.parseInt(nums[2])-1;
	    startRow = Integer.parseInt(nums[3])-1;
	    //System.out.println(endRow);
	    
	}
	catch(FileNotFoundException e){
	}
	int[][] currentWays;
	int[][] previousWays;
	return 0;
    }
    public static void main(String[] args){
	silver("ctravel.in");
    }	
}
