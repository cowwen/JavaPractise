import java.util.Set;
import java.util.HashSet;

public final class ThreeStooges{
	private final Set<String> stooges = new HashSet<String>();

	public ThreeStooges(){
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}

	public boolean isStooge(String name){
		return stooges.contains(name);
	}

	public Set<String> getStooges(){
		return stooges;
	}
}
