/*   Input: int array and  int value
     Output: boolean
     
     Helper function: binarySearch
     
     Examples:   {4,5,6,1,2,3} , 15
                 false
                 
                 {-2,-3,-4,2,0,-1}, 2
                 true
                 
     Time complexity: O(N*log N)
     Space complexity: O(1)
*/

public static boolean findSumValues(int[] arr, int sum){
    int limit = arr.length - 1;
  
    if(limit <= 0){
      return false;
    }
    for(int i=0; i<limit; i++){
        int target = sum - arr[i];
        
        if(binarySearch(arr,0,limit,target, i)){
            return true;
        }
    }
    return false;
 }
 
public boolean binarySearch(int[] arr, int start, int end, int target, int valIndex){
    if(start != valIndex && arr[start] == target){
      return true;
    }
  
    else if(end != valIndex && arr[end] == target){
      return true;
    }
  
    else if((start+1) == end){
      return false;
    }
  
    //else if(start < end){
    int mid = start + (end - start)/2;

    if(mid!= valIndex && arr[mid] == target){
      return true;
    }
    else if(target > arr[mid+1] && target < arr[end]){
      return binarySearch(arr, mid+1, end, target,valIndex);
    }
    return binarySearch(arr, start, mid, target,valIndex);
}

