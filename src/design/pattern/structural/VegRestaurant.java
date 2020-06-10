package design.pattern.structural;

public class VegRestaurant implements Hotel {

	@Override
	public VegMenu getMenus() {
		return new VegMenu(); 
	}

}
