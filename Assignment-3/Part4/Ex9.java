import java.util.List;
import java.util.ArrayList;

public static int numberOfStringsWithPrefix(List<String> listStr, String str, int prefixLength){
  List<Integer> substringCounter = new ArrayList<>();
  List<String> substrings = new ArrayList<>();
        
  int i=0;
 
  int endIndex = i + prefixLength;
 
  while( endIndex <= str.length()){
    String sub = str.substring(i,endIndex);        
    substrings.add(sub);
    substringCounter.add(0);
    i++;
    endIndex++;
  }
        
  for(int j=0; j<substrings.size(); j++){        
    String findSub = substrings.get(j);
           
    for(int k=0; k<listStr.size(); k++){
      if(listStr.get(k).contains(findSub)){
          int count = substringCounter.get(j);
        
          substringCounter.set(j,count+1);
      }
     }
  }   
  
  int max = -1;
  for(Integer a: substringCounter){
      if(a > max){
          max =a;
      }      
  }
  return max;
       
}
