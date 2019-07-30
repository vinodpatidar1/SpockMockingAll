package jmockit;

/**
 * @author mumtazbanur
 */
public class Allocator {

	public String getAllocation(String name) {
		if (name.equalsIgnoreCase("jmockit")) {
			return "Welcome to Jmockit";
		} else {
			return "Not allocated";
		}
	}
}
