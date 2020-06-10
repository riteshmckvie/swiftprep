package design.pattern.structural;

public class NonVegRestaurant implements Hotel {
	
	@Override
	public NonVegMenu getMenus() {
		return new NonVegMenu();
	}

}
