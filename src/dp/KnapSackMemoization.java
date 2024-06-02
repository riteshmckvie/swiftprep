package dp;


public class KnapSackMemoization {
	
	public static void main(String[] args) {
		
		int value[] = new int[] { 60, 100, 120 };
		int weight[] = new int[] { 10, 20, 30 };
		int capacityWeight = 50;
		int n = value.length;
		// Declare the table dynamically
		int dp[][] = new int[n + 1][capacityWeight + 1];
		
		// Loop to initially filled the
		// table with -1
		for (int i = 0; i < n + 1; i++)
			for (int j = 0; j < capacityWeight + 1; j++)
				dp[i][j] = -1;
		System.out.println(maximumProfit(weight,value, capacityWeight, n,dp));
	}
	
	private static int maximumProfit(int weight[], int value[],int capacityWeight,int n,int dp[][]) {
		//base condition
		if(n == 0 || capacityWeight == 0) return 0;
		
		 if (dp[n][capacityWeight] != -1)
			 return dp[n][capacityWeight];
		
		if(weight[n-1] > capacityWeight)
			return dp[n][capacityWeight] = maximumProfit(weight, value, capacityWeight, n-1,dp);
		else
			return dp[n][capacityWeight] = Math.max(value[n-1] + maximumProfit(weight, value, capacityWeight - weight[n-1], n -1,dp) ,
					maximumProfit(weight, value, capacityWeight, n-1,dp));
	}
	


}
