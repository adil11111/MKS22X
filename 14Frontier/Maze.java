import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;
public class Maze{
    private static final String CLEAR_SCREEN =  "\033[2J";
    private static final String HIDE_CURSOR =  "\033[?25l";
    private static final String SHOW_CURSOR =  "\033[?25h";
    Location start,end;
    private char[][]maze;
    private boolean aStar = true;

    public void setAstar(boolean type){
	aStar=type;
    }
    /*
      YOU MUST COMPLETE THIS METHOD!!!
      YOU MUST COMPLETE THIS METHOD!!!
      YOU MUST COMPLETE THIS METHOD!!!
    */
    public Location[] getNeighbors(Location L){
	Location[] result = new Location[4];
	int[][] choices ={{0,1},{0,-1},{1,0},{-1,0}};
	for(int i=0;i<choices.length;i++){
	    int nextX= choices[i][0] + L.getX();
	    int nextY= choices[i][1] + L.getY();
	    if(checkX(nextX) && checkY(nextY)){
		if(maze[nextY][nextX] == ' ' ||  maze[nextY][nextX] == 'E'){
		    int distEnd = Math.abs(nextX-end.getX())+Math.abs(nextY-end.getY());     
		    if(aStar){
			result[i]=new Location(nextX,nextY,L, distEnd,L.getDistanceSoFar() + 1);
		    }
		    else{
			result[i]=new Location(nextX,nextY,L, distEnd);
		    }
		    //System.out.println(result[i]);
		}
	    }
	    
	}
	return result;
    }
    public boolean checkX(int bound){
	return bound<maze[0].length && bound>=0;
    }
    public boolean checkY(int bound){
	return bound<maze.length && bound>=0;
    }
    public Location getStart(){
	return start;
    }
    public Location getEnd(){
	return end;
    }


    private static String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
    private static String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    public void clearTerminal(){
	System.out.println(CLEAR_SCREEN+"\033[1;1H");
    }
    public Maze(String filename){
	ArrayList<char[]> lines = new ArrayList<char[]>();
	int startr=-1, startc=-1;
	int endr=-1,endc=-1;
	try{
	    Scanner in = new Scanner(new File(filename));
	    while(in.hasNext()){
		lines.add(in.nextLine().toCharArray());
	    }
	}catch(FileNotFoundException e){
	    System.out.println("File not found: "+filename);
	    System.exit(1);
	}
	maze = new char[lines.size()][];
	for(int i = 0; i < maze.length; i++){
	    maze[i]=lines.get(i);
	}
	for(int r=0; r<maze.length;r++){
	    for(int c=0; c<maze[r].length;c++){
		if(maze[r][c]=='S'){
		    if(startr == -1){
			startr=r;
			startc=c;
		    }else{
			System.out.println("Multiple 'S' found!");
			System.exit(0);
		    }
		}

		if(maze[r][c]=='E'){
		    //erase E
		    //maze[r][c]=' ';
		    if(endr == -1){
			endr=r;
			endc=c;
		    }else{
			System.out.println("Multiple 'E' found!");
			System.exit(0);
		    }
		}
	    }
	}
	if(startr == -1 || endr == -1){
	    System.out.println("Missing 'S' or 'E' from maze.");
	    System.exit(0);

	}

	/*
	  THIS IS AN IMPORTANT PART BECAUSE YOU WILL NEED TO CHANGE IT LATER!
	  The start/end Locations may need more information later when we add
	  other kinds of frontiers!
	*/
	end = new Location(endr,endc,null);
	start = new Location(startr,startc,null);
    }

    public String toStringColor(){
	return toStringColor(50);
    }

    public String toStringColor(int delay){
	try{
	    Thread.sleep(delay);
	}catch(InterruptedException e){

	}
	return HIDE_CURSOR+CLEAR_SCREEN+go(1,1)+colorize(toString())+SHOW_CURSOR;
    }

    public String toString(){
	int maxr = maze.length;
	int maxc = maze[0].length;
	String ans = "";
	for(int i = 0; i < maxr * maxc; i++){
	    int row = i/maxc;
	    int col = i%maxc;

	    char c =  maze[row][col];
	    ans+=c;
	    if( col == maxc-1 ){
		ans += "\n";
	    }

	}
	return ans + "\n";
    }

    public char get(int row,int col){
	return maze[row][col];
    }
    public void set(int row,int col, char n){
	maze[row][col] = n;
    }
    public static String colorize(String s){
	String ans = "";
	Scanner in = new Scanner(s);
	while(in.hasNext()){
	    String line ="";
	    for(char c : in.nextLine().toCharArray()){
		if(c == '#'){
		    line+= color(37,47)+c;
		}
		else if(c == '@'){
		    line+= color(33,40)+c;
		}
		else if(c == '?'){
		    line+= color(37,42)+c;
		}
		else if(c == '.'){
		    line+= color(36,40)+c;
		}
		else if(c == ' '){
		    line+= color(35,40)+c;
		}else{
		    line+=color(37,40)+c;
		}

	    }
	    ans += line+color(37,40)+"\n";
	}
	return ans;
    }
}
