public class Ex2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       Employee a = new Employee("A","CEO");
       Employee b = new Employee("B","CTO");
       Employee c = new Employee("C","CFO");
       Employee d = new Employee("D","Director");
       Employee e = new Employee("E","Manage");
       Employee f = new Employee("F","Manager");
       Employee g = new Employee("G","Manage");
       Employee h = new Employee("H","Manager");
       Employee i = new Employee("I","Manage");
       a.directReports.add(b);
       a.directReports.add(c);  
       d.directReports.add(h);
       c.directReports.add(g);
       c.directReports.add(f);
       c.directReports.add(d);
       b.directReports.add(e);
       b.directReports.add(i);

       
       OrganizationStructure root = new OrganizationStructure(a);
       root.printLevelByLevel();
    }
}
