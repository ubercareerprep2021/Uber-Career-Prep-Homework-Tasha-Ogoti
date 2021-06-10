import java.util.ArrayList;

/**
 *
 * @author TashaOgoti
 */
public class ListPhonebook implements Phonebook{
    private String name;
    private long phoneNumber;
    Integer size = 0;
    
    ArrayList<ListPhonebook> phoneList = new ArrayList<>();
    
    public ListPhonebook(){
        this.name = "";
        this.phoneNumber = 0L;
    }
    
    public ListPhonebook(String name, long phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public void insert(String name, long phoneNumber) {
        ListPhonebook node = new ListPhonebook(name, phoneNumber);
        System.out.println("Added node");
        phoneList.add(node);
        size = size + 1;
    }

    @Override
    public long find(String name) {
        
        for(ListPhonebook phone: phoneList){
            // If exists returns the phoneNumber
            if(phone.name.equals(name)){
                //System.out.println("Found");
                return phone.phoneNumber;
            }
        }
        // If it does not exist returns 0
        //System.out.println("Not found");
        return 0L;
    }
    
}
