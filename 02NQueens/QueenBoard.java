public class QueenBoard{
    private int[][]board;
    
    public QueenBoard(int size){
	board= new int[size][size];
	for(int r=0;r<size;r++){
	    for(int c=0;c<size;c++){
		board[r][c]=0;
	    }
	}
    }
    
      
    private boolean addQueen(int r, int c){
	int row=r;
	int col=c;
	if (board[r][c]==0){
	    board[r][c]=-1;
	    while (row> 0 && col < board.length-1){
		board[row-1][col+1]+=1;
		row--;
		col++;
	    }
	    row=r;
	    col=c+1;
	    while (col <board[0].length){
		board[r][col]+=1;
		col++;
	    }
	    row=r;
	    col=c;
	    while (row< board.length-1 && col < board[0].length-1){
		board[row+1][col+1]+=1;
		row++;
		col++;
	    }
	    return true;		
	}
		
	return false;
    }
    private boolean removeQueen(int r, int c){
	int row=r;
	int col=c;
	if (board[r][c]==-1){
	    board[r][c]=0;
	    while (row> 0 && col < board.length-1){
		board[row-1][col+1]-=1;
		row--;
		col++;
	    }
	    row=r;
	    col=c+1;
	    while (col <board[0].length){
		board[r][col]-=1;
		col++;
	    }
	    row=r;
	    col=c;
	    while (row< board.length-1 && col < board[0].length-1){
		board[row+1][col+1]-=1;
		row++;
		col++;
	    }
	    return true;		
	}
		
	return false;
    }
    public String toString(){
	String gatherer="";
	for(int r=0;r<board.length;r++){
	    for(int c=0;c<board.length;c++){
		if (board[r][c]==-1){
	        gatherer= gatherer + " Q" + " ";
		}
		else{
		    gatherer= gatherer + " _";
		}
	    }
	    gatherer = gatherer + "\n";
	}
	return gatherer;
    }
    public boolean solveH(int col){
	if (col>=board[0].length){
	    return true;
	}
	for (int r=0;r<board.length;r++){
	    if(addQueen(r,col)){
		if (solveH(col+1)){
		    return true;
		}
	    }
	    removeQueen(r,col);
	}
	return false;
    }
    public boolean solve(){
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board.length;c++){
		if (board[r][c]!=0){
		    throw new IllegalStateException("Your board cannot start with any nonzero numbers");
		}
	    }
	}
	return solveH(0);
    }
	
    public int countSolutionsH(int col){
	int soln = 0;
	if (col>=board[0].length){
	    return 1;
	}           
	for (int r=0;r<board.length;r++){
	    if(addQueen(r,col)){
		soln+=countSolutionsH(col+1);
		removeQueen(r,col);
	    }
	}
	return soln;
    }

	


    public int countSolutions(){
	for (int r=0;r<board.length;r++){
	    for (int c=0;c<board.length;c++){
		if (board[r][c]!=0){
		    throw new IllegalStateException("Your board cannot start with any nonzero numbers");
		}
	    }
	}
	return countSolutionsH(0);
    }

    public static void main(String[] args){
        QueenBoard test = new QueenBoard(5);
	//	test.addQueen(0,0);
	//System.out.println(test);
	//System.out.println(test.solveH(0));
	System.out.println(test.solve());
	System.out.println(test);
	//test.removeQueen(2,1);
	//System.out.println(test);
	//System.out.println(test.solve(0));
	//System.out.println(test);
    }
}
