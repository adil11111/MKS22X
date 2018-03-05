import java.io.*;
import java.util.*;

public class Maze{

    public char[][] puzzle;
    private int[][] moves={{1,0},{-1,0},{0,1},{0,-1}};
    private boolean animate;

    public Maze(String filename)throws FileNotFoundException{
	animate=false;
	try{
	    int rows=0;
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    String line="";
	    while(in.hasNextLine()){
		 line = in.nextLine();
		 rows++;
		}
	     in.close();
	     puzzle = new char[rows][line.length()];

	}
	catch(FileNotFoundException e){
	}
	try{
	    File text = new File(filename);
	    Scanner in = new Scanner(text);
	    for (int r=0;r<puzzle.length;r++){
		String line = in.nextLine();
		for (int c=0;c<puzzle[0].length;c++){
		    char character=line.charAt(c);
		    puzzle[r][c]=character;
		}
	    }
	}
	catch(FileNotFoundException e){
	}
	int e=0;
	int s=0;
	for (int row = 0; row < puzzle.length; row++) {
	    for (int col = 0; col < puzzle[row].length; col++) {
		if (puzzle[row][col] == 'E') {
		    e++;
		}
		if (puzzle[row][col] == 'S') {
		    s++;
		}
	    }
	}
	
	if (e != 1 || s != 1) {
	    throw new IllegalStateException();
	}

    }
    public void setAnimate(boolean b){
        animate = b;
    }
    private void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
     }

    public void clearTerminal(){
        System.out.println("\033[2J\033[1;1H");
    }
    public String toString(){
	String gatherer = "";
	for(int r = 0; r < puzzle.length;r++){
	    for(int c = 0;c < puzzle[0].length;c++){
		gatherer += puzzle[r][c];
	    }
	    gatherer += "\n";
	}
	return gatherer;
    }
    public int solve(){
	int row = 0;
	int col = 0;
	for (int r=0;r<puzzle.length;r++){
	    for (int c=0;c<puzzle[0].length;c++){
		if (puzzle[r][c]=='S'){
		    row=r;
		    col=c;
		}
	    }
	}
	return solve(row,col,0);
    }

    private int solve(int row, int col, int steps){
	/*if(animate){
            clearTerminal();
            System.out.println(this);
            wait(20);
	    }*/
        if(puzzle[row][col]=='E'){
	    return steps;
	}
	for(int i=0;i<moves.length;i++){
	    int rowCheck = row + moves[i][0];
	    int colCheck = col + moves[i][1];
	    if (puzzle[rowCheck][colCheck]==' ' || puzzle[rowCheck][colCheck]=='E' ){
		puzzle[row][col]='@';
		int result = solve(rowCheck,colCheck,steps+1);
		if(result!=-1){
		    return result;
		}
		puzzle[row][col]='.';
	    }
	}
	return -1;
    }


    public static void main(String[] args){
        //System.out.println(reader("data1.dat"));
	
        try{
	Maze test= new Maze("data3.dat");
	test.setAnimate(true);
	System.out.println(test.solve());
	}
	catch(Exception e){System.out.println(e);}
    }
	
}
