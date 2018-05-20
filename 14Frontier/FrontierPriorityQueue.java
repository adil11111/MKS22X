public class FrontierPriorityQueue implements Frontier{
    private MyHeap<Location> locations;

    public FrontierPriorityQueue(){
	locations = new MyHeap<Location>(false);
    }
    public void add(Location loc){
	locations.add(loc);
    }
    public Location next(){
	return locations.remove();
    }
    public boolean hasNext(){
	return locations.peek() != null;
    }
}  
