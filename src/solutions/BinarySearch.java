package solutions;

import javax.naming.NamingException;

public class BinarySearch {

	public static void main(String[] args) throws NamingException {
		int[] arr = {20,30,90,5,43,4,2};
		int k= 4;
		System.out.println(searchIndex(k,arr,0,arr.length));
	}
	
	public void test() {
		System.out.println("Test");
	}
	
	
	static int searchIndex(int k, int[] arr,int start,int dest) {
	    int index = -1;
	    if (dest > start) {
    	    int middle = (start + dest)/2;
    	    if (arr[middle] == k) return middle;
    	    index = searchIndex(k,arr,start,middle-1);
    	    if (index == -1) { 
    	        return searchIndex(k,arr,middle+1,dest);
    	    }
	    }
    	return index;
	}
	

}
