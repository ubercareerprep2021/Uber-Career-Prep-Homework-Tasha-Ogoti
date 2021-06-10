
import java.util.ArrayList;

/**
 *
 * @author TashaOgoti
 */
public class ListPhonebook implements Phonebook{
    private String name;
    private long phoneNumber;
    Integer size;
    
    ArrayList<ListPhonebook> phoneList = new ArrayList<>();
    
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
        phoneList.add(new ListPhonebook(name, phoneNumber));
        size++;
    }

    @Override
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
    
}
