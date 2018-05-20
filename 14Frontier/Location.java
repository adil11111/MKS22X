public class Location implements Comparable<Location>{
    private int x,y;
    private Location previous;
    private int distance;
    private int distanceSoFar;

    public Location(int _x, int _y, Location prev){
	x = _x;
	y = _y;
	previous = prev;
    }
    public Location(int _x, int _y, Location prev,int dist){
	x = _x;
	y = _y;
	previous = prev;
	distance=dist;
    }
    public Location(int _x, int _y, Location prev,int dist,int dSF){
	x=_x;
	y=_y;
	previous=prev;
	distance=dist;
	distanceSoFar=dSF;
    }
    public Location getPrevious(){
	return previous;
    }
    public int getDistanceSoFar(){
	return distanceSoFar;
    }

    public int getDistance(){
	return distance;
    }
    public int getX(){
	return x;
    }
    
    public int getY(){
	return y;
    }
    public int compareTo(Location loc){
	int ourDist= getDistance() + getDistanceSoFar();
	int otherDist = loc.getDistance() + loc.getDistanceSoFar();
	return ourDist-otherDist;
    }

}
