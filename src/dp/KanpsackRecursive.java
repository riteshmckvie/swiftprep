package dp;

public class KanpsackRecursive {

	public static void main(String[] args) {
		int value[] = new int[] { 60, 100, 120 };
        int weight[] = new int[] { 10, 20, 30 };
        int capacityWeight = 50;
        int n = value.length;
        System.out.println(maximumProfit(weight,value,capacityWeight,n));
	}

	private static int maximumProfit(int weight[], int value[], int capacityWeight, int n) {
		//base condition
		if(n == 0 || capacityWeight == 0) return 0;
		
		if(weight[n-1] > capacityWeight)
			return maximumProfit(weight, value, capacityWeight, n-1);
		else
			return Math.max(value[n-1] + maximumProfit(weight, value, capacityWeight - weight[n-1], n -1) ,
					maximumProfit(weight, value, capacityWeight, n-1));
	}
}
