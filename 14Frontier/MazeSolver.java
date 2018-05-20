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
	    Location next = frontier.next();
	    Location[] neighbors = maze.getNeighbors(next);
	    maze.set(next.getX(), next.getY(), '.');
	    for(Location loc: neighbors){
		if(loc!=null){
		    if(loc.getX()==end.getX() && loc.getY()==end.getY()){
			Location previous = loc.getPrevious();
			while(!(previous.getX() == start.getX() && previous.getY() == start.getY())){
			    maze.set(previous.getX(), previous.getY(), '@');
			    previous = previous.getPrevious();
			}
			System.out.println(maze.toStringColor());				
			return true;
		    }
		    frontier.add(loc);
		    maze.set(loc.getX(), loc.getY(), '?');
		}
	    }
	}
	return false;	
    }
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true!
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false

    public String toString(){
	return maze.toString();
    }
    public static void main(String[] args){
        //System.out.println(reader("data2.dat"));
	
        try{
	MazeSolver test= new MazeSolver("data1.dat");
	System.out.println(test.maze);
    System.out.println(test.solve(1));
	}
	catch(Exception e){System.out.println(e);}
    }
}
