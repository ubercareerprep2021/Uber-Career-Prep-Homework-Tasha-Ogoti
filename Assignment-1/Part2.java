/*
  Receiving two strings
  Assumptions:  1) Function is case-sensitive
                2) Numbers can be present
        
  Steps
  - Check to see whether the strings are of the same length
  - Loop through checking whether the second string has identical characters to the first
*/
public boolean isStringPermutation(String s1, String s2){
    int lengthS1 = s1.length(); //length of first string
    int lengthS2 = s2.length();
  
    s1.toLower();// Convert string to lower-case
    s2.toLower();// Convert string to lower-case
  
    //Length of strings check
    if(lengthS1 != lengthS2){
          return false;
    }
    
    int i; //Used in looping through the string
    for(i=0; i < lengthS1; i++){
        String characterS2 = Character.toString(s2.charAt(i));
        //Check to see if the character is present or not
        if(s1.contains(characterS2)){
            continue;
        }
        else if(!s1.contains(characterS2)){
            return false;
        }
    }
  
    return true;
}




/*


*/
public List<List<Integer>> pairsThatEqualSum(List<Integer> inputArray, Integer targetSum){



}
