package design.pattern.structural;

public class FacadeDemos {

	public static void main(String[] args) {
		HotelKeeperFacade keeper = new HotelKeeperFacade();

		VegMenu v = keeper.getVegMenu();
		v.getMenus();
		NonVegMenu nv = keeper.getNonVegMenu();
		nv.getMenus();
	}

}
