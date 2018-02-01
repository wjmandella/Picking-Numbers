import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PickingNumbersApp {
    static int pickingNumbers(int[] a) {
        // Complete this function
    	int count = 0;
    	Arrays.sort(a);
    	int [] tempArray1 = new int[a[a.length-1] + 1];
    	
    	for(int i = 0; i < a.length; i++) {
    		for(int j = 0; j < a.length; j++) {
    			if(i == j) {
    				continue;
    			}
    			else if(Math.abs(a[i]-a[j])<= 1) {
    				tempArray1[a[i]]++; 				
    			}
    		}
    	}
    	System.out.println("Temp array: "+Arrays.toString(tempArray1));

    	int maxOne = 0;
        int maxTwo = 0;
        for(int n:tempArray1){
            if(maxOne < n){
                maxTwo = maxOne;
                maxOne =n;
            } else if(maxTwo < n){
                maxTwo = n;
            }
        }
        System.out.println("First Max Number: "+maxOne);
        System.out.println("Second Max Number: "+maxTwo);
    	
        ArrayList<Integer>tempArray2 = new ArrayList<>();
    	for(int i = 0; i < tempArray1.length; i++) {
    		if(tempArray1[i] == maxOne || tempArray1[i] == maxTwo) {
    			tempArray2.add(i);
    		}
    	}
    	Arrays.sort(tempArray1);
    	System.out.println("Temp array: "+Arrays.toString(tempArray1));
    	System.out.println("Temp array 2:" + tempArray2.toString());
    	
    	for(int n = 0; n < a.length; n++) {
    		for(int m = 0; m < tempArray2.size(); m++) {
    			if(a[n] == tempArray2.get(m)) {
    				count++;
    			}	
    		}
    	}

    	return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the size of the array, n (integer 2 - 100): ");
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
        	System.out.print("Enter an integer (element #"+(a_i + 1)+") of the array (0 - 100): ");
            a[a_i] = in.nextInt();
        }
        int result = pickingNumbers(a);
        System.out.println(result);
        in.close();
    }
}
