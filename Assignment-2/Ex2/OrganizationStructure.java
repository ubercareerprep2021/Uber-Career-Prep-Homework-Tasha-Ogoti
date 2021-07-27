
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author TashaOgoti
 */
public class OrganizationStructure {
    public Employee ceo;

    public OrganizationStructure(Employee ceo){
        this.ceo = ceo;
    }
    
    public static class Employee {
        public String name;
        public String title;
        public List<Employee> directReports;
        
        public Employee(String name, String title){
            this.name = name;
            this.title = title;
            directReports = new ArrayList<>();
        }
    }
    
    public void printLevelByLevel(){
        Queue<Employee> organizationLevels = new LinkedList<>();
        
        organizationLevels.add(ceo);
        addQueue(organizationLevels,ceo.directReports);
        
        //System.out.println("Top " + organizationLevels.poll().name);

        for(Employee employee : organizationLevels){
            if(employee.name.equals("")){
                System.out.println();
                continue;
            }
            
            System.out.println("" + employee.name + " - " + employee.title);
        }
 
    }
    
    public void addQueue(Queue<Employee> empQueue, List<Employee> empList){
        if(empList.isEmpty()){
            return;
        }
        empQueue.add(new Employee("",""));
        List<Employee> temp = empList;
        empQueue.addAll(empList);
        
        for(Employee employee : temp){
            addQueue(empQueue,employee.directReports);
        }
        
    }
    
    public Employee fetch(Employee e, Integer eIndex){
        return e.directReports.get(eIndex);
    }

}
