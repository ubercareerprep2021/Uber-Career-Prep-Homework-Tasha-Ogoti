/*
    Input: int array 1, int array 2
    Output: boolean
    
    Example:   arr1 = {9,1,3,7,2,5,4}
               arr2 = {1,2,3}
               true
                
               arr1 = {1,2,3}              
               arr2 = {1,0}
               false
               
    Time complexity: O(N^2)
    Space complexity: O(1)      
*/

public boolean isSubset(int[] arr1, int[] arr2){
  int arr1Limit = arr1.length;
  int arr2Limit = arr2.length;
  
  boolean elementFound = false;
  
  for(int i=0; i<arr2Limit; i++){
    for(int j=0; j<arr1Limit; j++){
      if(arr1[j] == arr2[i]){
        elementFound = true;
        break;
      }
    }
    if(elementFound == false){
      return false; 
    }
    else{
      elementFound = false;
    }
  }
  return true;
}
