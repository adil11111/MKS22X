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
	    Frontier frontier = new FrontierQueue();
	}
	else if (mode==1){
	    Frontier frontier = new FrontierStack();	
	}
	while (frontier.hasNext()){
	}
	//  get the next location
	//  process the location to find the locations (use the maze to do this)
	//  check if any locations are the end, if you found the end just return true!
	//  add all the locations to the frontier
	//when there are no more values in the frontier return false
	return false;
    }

    public String toString(){
	return maze.toString();
    }
}
