package jmockit;

/**
 * @author mumtazbanur
 */
public class Person {
	

	public String getDetails(String name) {
		Allocator allocator = new Allocator();
		return allocator.getAllocation(name);
	}

	public String setName(String name) {
		if (NameValidator.isNameValid(name)) {
			return name;
		} else {
			return "DEFAULT";
		}
	}
	
}
