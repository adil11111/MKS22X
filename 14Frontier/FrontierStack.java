import java.util.*;

public class FrontierStack implements Frontier{
    private Stack<Location> locations;
    public FrontierStack(){
	locations = new Stack<Location>();
    }
    
    public Location next(){
	return locations.pop();
    }

    public void add(Location loc){
	locations.push(loc);
    }
    public boolean hasNext(){
	return locations.size() != 0;
    }
}
