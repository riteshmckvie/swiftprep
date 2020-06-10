package design.pattern.structural;

public class HotelKeeperFacade {

	public VegMenu getVegMenu() {
		VegRestaurant v = new VegRestaurant();
		return v.getMenus();
	}

	public NonVegMenu getNonVegMenu() {
		NonVegRestaurant v = new NonVegRestaurant();
		return v.getMenus();
	}
	
}
