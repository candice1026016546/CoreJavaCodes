/**
 * Created by Candice.Q.Zhao on 2016/11/3.
 */
public class StaticTest {
    public static void main(String[] args)
    {
        // fill the staff array with three Employees objects
        Employees[] staff = new Employees[3];

        staff[0] = new Employees("Tom", 40000);
        staff[1] = new Employees("Dick", 60000);
        staff[2] = new Employees("Harry", 65000);

        // print out information about all Employees objects
        for (Employees e : staff)
        {
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary="
                    + e.getSalary());
        }

        int n = Employees.getNextId(); // calls static method
        System.out.println("Next available id=" + n);
    }
}

class Employees
{
    private static int nextId = 1;

    private String name;
    private double salary;
    private int id;

    public Employees(String n, double s)
    {
        name = n;
        salary = s;
        id = 0;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public int getId()
    {
        return id;
    }

    public void setId()
    {
        id = nextId; // set id to next available id
        nextId++;
    }

    public static int getNextId()
    {
        return nextId; // returns static field
    }

    public static void main(String[] args) // unit test
    {
        Employees e = new Employees("Harry", 50000);
        System.out.println(e.getName() + " " + e.getSalary());
    }
}
