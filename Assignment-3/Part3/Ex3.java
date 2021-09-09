
public double pow(double base, int power){
    double total = 1.0;
    boolean negativePower = (power < 0) ? true : false;

    if(power == 0){
      return 1.0;
    }
  
    power = Math.abs(power);
  
    while(power != 0){
      total = total * base;
      power--;
    }
    
    return (negativePower) ? (1/total) : total;
 } 
