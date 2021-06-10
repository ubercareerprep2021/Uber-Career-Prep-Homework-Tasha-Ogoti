
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TashaOgoti
 */
public class ListPhonebook{
    private String name;
    private long phoneNumber;
    Integer size = 0;
    private long startTime;
    
    ArrayList<ListPhonebook> phoneList = new ArrayList<>();
    
    private Integer findCalled = 0;
    
    public ListPhonebook(){
        this.name = "";
        this.phoneNumber = 0L;
        startTime = 0;
    }
    
    public ListPhonebook(String name, long phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    public int size() {
        return size;
    }

    public void insert(String name, long phoneNumber) {
        ListPhonebook node = new ListPhonebook(name, phoneNumber);
        //System.out.println("Added node");
        phoneList.add(node);
        size = size + 1;
    }

    public long find(String name) {
        
        for(ListPhonebook phone: phoneList){
            if(phone.name.equals(name)){
                //System.out.println("Found");
                return phone.phoneNumber;
            }
        }
        //System.out.println("Not found");
        return 0L;
    }
    
    public void readFileToList(){
        Timer();
        try {
            File myPhonebook = new File("data.csv");
            Scanner readData = new Scanner(myPhonebook);
            
            
            while (readData.hasNextLine()) {
                String data = readData.nextLine();
                //System.out.println(data);
                
                String[] phoneBook = data.split(",");
                insert(phoneBook[0],Long.parseLong(phoneBook[1]));
                
            }
            readData.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.print("Insertion time");
        getExecutionTime();
        System.out.println("The total size is: " + size());
    }
    
    public void searchFile(){
        Timer();
        try {
            File myPhonebook = new File("search.txt");
            Scanner readData = new Scanner(myPhonebook);
            
            while (readData.hasNextLine()) {
                String data = readData.nextLine();
                System.out.println(data);
                
                //String[] phoneBook = data.split(",");
                if(find(data) == -1){
                    System.out.println("Find has been called " + findCalled + " times");
                }
                else{
                    findCalled++;
                    System.out.println();
                }
                
            }
            readData.close();
            
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.print("Search time ");
        getExecutionTime();
    }
    
    public void Timer(){
        startTime = System.currentTimeMillis();
    }
    
    public void getExecutionTime(){
        long endTime = System.currentTimeMillis();
        
        long totalTime = endTime - startTime;
        System.out.print("has taken: " + Long.toString(totalTime)+" ms\n");
    }
}
