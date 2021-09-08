 
/*   
     Input: int array
     Output: int(min) or -1

     Corner cases: isEmpty, return -1
                   length == 1, return -1
                   same integer all through, return -1 
*/
public static int findMinimum(int[] arr){
        if(arr.isEmpty()){
            return -1; 
        }
        int limit = arr.length;
        int minimum = -1;
        
        if(limit == 0){
            //System.out.println("One element " + arr[0]);
            return;
        }
        for(int i=0; i< limit; i++){
            if(i!= 0){
                int difference = arr[i] - arr[i-1];
                if(difference < 0 && minimum > arr[i]){
                    //System.out.println("Element is " + arr[i-1] + " vs " + arr[i] );
                    minimum = arr[i];
                    
                }
            }
        }
        return minimum;
    }
