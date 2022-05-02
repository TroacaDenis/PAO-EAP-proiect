package stock;

import java.util.*;
import java.util.stream.*;
public class test {
	public static void main(String[] args) {
		ArrayList<ArrayList<String>> a = new ArrayList<>();
		ArrayList<String> a1 = new ArrayList<>(Arrays.asList("abcd", "efgh"));
		ArrayList<String> a2 = new ArrayList<>(Arrays.asList("1234", "5678"));
		a.add(a1);
		a.add(a2);
		System.out.println(a);
	   // ArrayList<String> b = a.stream().map(x->String.join("++", x)).collect(Collectors.toCollection(ArrayList::new));
	    a.stream().map(x->String.join("++", x)).forEach(y->System.out.println(y));
	    //System.out.println(b);
	    
	    for (ArrayList<String> line : a) {
	    	line.set(1, "bruh");
			
		}
	    System.out.println(a);
	}
}
