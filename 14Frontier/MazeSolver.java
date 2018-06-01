import java.io.*;
public class MazeSolver{
    private Maze maze;
    private Frontier frontier;
    private boolean animate;
    
    public MazeSolver(String mazeText){
	animate=false;
	maze = new Maze(mazeText);
    }
    public void setAnimate(boolean type){
	animate=type;
    }
    //Default to BFS
    public boolean solve(){ return solve(0); }

    //mode: required to allow for alternate solve modes.
    //0: BFS
    //1: DFS
    //2:PRQ
    //3:Astar
    public boolean solve(int mode){
	if(mode==0){
	    frontier = new FrontierQueue();
	}
	else if (mode==1){
	    frontier = new FrontierStack();	
	}
	else if (mode==2){
	    frontier = new FrontierPriorityQueue();
	}
	else{
	    frontier = new FrontierPriorityQueue();
	    maze.setAstar(true);
	}
	frontier.add(maze.getStart());
	Location start=maze.getStart();
	Location end=maze.getEnd();
	while (frontier.hasNext()){
	    // System.out.println(frontier);
	    Location next = frontier.next();
	    Location[] neighbors = maze.getNeighbors(next);
	    //System.out.println(maze.toStringColor());
	    if(maze.get(next.getY(),next.getX())== 'E'){
		Location previous = next.getPrevious();
		while(!(previous.getX() == start.getX() && previous.getY() == start.getY())){
		    maze.set(previous.getY(), previous.getX(), '@');
		    previous = previous.getPrevious();
		    //System.out.println(maze.toStringColor()); 
		}
		return true;
	    }
	    else{
		if(maze.get(next.getY(),next.getX())!= 'S'){
		    maze.set(next.getY(), next.getX(), '.');
		}}
	    for(Location loc: neighbors){
		if(loc!=null){
		    
		    frontier.add(loc);
		    //	System.out.println("added");
		    
		    /*if(maze.get(next.getY(),next.getX())== 'E'){
			System.out.println("HEYEYYEYEYEYEYEYEYEYEY");
			Location previous = loc.getPrevious();
			while(!(previous.getX() == start.getX() && previous.getY() == start.getY())){
			    maze.set(previous.getY(), previous.getX(), '@');
			    previous = previous.getPrevious();
			}
			System.out.println(maze.toStringColor());				
			return true;
		    }
		    
		    //maze.set(loc.getX(), loc.getY(), '?');*/
		}
	    }
	}
	//	System.out.println(frontier);
	return false;	
    }
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false

    public String toString(){
	return maze.toStringColor();
    }
    public static void main(String[] args){
        //System.out.println(reader("data2.dat"));
	
        try{
	    MazeSolver test= new MazeSolver("data2.dat");
	    test.solve(2);
	    System.out.println(test);

	}
	catch(Exception e){System.out.println(e);}
    }
}
