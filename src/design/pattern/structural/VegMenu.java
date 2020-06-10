package design.pattern.structural;

import java.util.Arrays;
import java.util.List;

public class VegMenu implements Menu {

	@Override
	public List<String> getMenus() {
		return Arrays.asList("Curd Rice", "Fried Rice", "Dosa");
	}

}
