   
/*   Input: int array and  int value
     Output: boolean
     
     Examples:   {4,5,6,1,2,3} , 5
                 true
                 
                 {-2,-3,-4,-5,0,-1}, 2
                 false
                 
     Time complexity: O(log N)
     Space complexity: O(1)
*/

public boolean findElement(int[] arr, int target){
    if(arr.isEmpty()){
        return false; 
    }

    int limit = arr.length - 1;
  
    if(limit == 0){
      return (arr[0] == target) ? true : false;
    }
  
    return recursiveBinary(arr,0,limit,target);
 }
 
public boolean binarySearch(int[] arr, int start, int end, int target){
    if(arr[start] == target){
      return true;
    }
  
    else if(arr[end] == target){
      return true;
    }
  
    else if((start+1) == end){
      return false;
    }
  
    //else if(start < end){
    int mid = start + (end - start)/2;

    if(arr[mid] == target){
      return true;
    }
    else if(target > arr[mid+1] && target < arr[end]){
      return binarySearch(arr, mid+1, end, target);
    }
    return binarySearch(arr, start, mid, target);
}
