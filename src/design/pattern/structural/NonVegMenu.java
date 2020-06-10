package design.pattern.structural;

import java.util.Arrays;
import java.util.List;

public class NonVegMenu implements Menu {

	@Override
	public List<String> getMenus() {
		return Arrays.asList("Butter Chicken", "Mutton Biriyani", "Kabab 65");
	}

}
