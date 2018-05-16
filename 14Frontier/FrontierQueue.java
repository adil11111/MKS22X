import java.util.*;

public class FrontierQueue implements Frontier{
    public LinkedList<Location> locations;

    public FrontierQueue(){
	locations = new LinkedList<>();
    }
    public Location next(){
	return locations.remove();
    }
    public void add(Location loc){
	locations.add(loc);
    }
    public boolean hasNext(){
	return locations.peek() != null;
    }
}
