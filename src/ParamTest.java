/**
 * Created by Candice.Q.Zhao on 2016/11/3.
 */
public class ParamTest {
    public static void main(String[] args) {
      /*
       * Test 1: Methods can't modify numeric parameters
       */
        System.out.println("Testing tripleValue:");
        double percent = 10;
        System.out.println("Before: percent=" + percent);
        tripleValue(percent);
        System.out.println("After: percent=" + percent);

      /*
       * Test 2: Methods can change the state of object parameters
       */
        System.out.println("\nTesting tripleSalary:");
        Employeess harry = new Employeess("Harry", 50000);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary=" + harry.getSalary());

      /*
       * Test 3: Methods can't attach new objects to object parameters
       */
        System.out.println("\nTesting swap:");
        Employeess a = new Employeess("Alice", 70000);
        Employeess b = new Employeess("Bob", 60000);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
    }

    public static void tripleValue(double x) // doesn't work
    {
        x = 3 * x;
        System.out.println("End of method: x=" + x);
    }

    public static void tripleSalary(Employeess x) // works
    {
        x.raiseSalary(200);
        System.out.println("End of method: salary=" + x.getSalary());
    }

    public static void swap(Employeess x, Employeess y) {

        /*Employeess temp = x;
        x = y;
        y = temp;*/
        x.swap(y);
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }
}

class Employeess // simplified Employeess class
{
    private String name;
    private double salary;

    public Employeess(String n, double s) {
        name = n;
        salary = s;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public void swap(Employeess employeess) {
        Employeess temp = new Employeess(this.getName(), this.getSalary());
        this.name = employeess.getName();
        this.salary = employeess.getSalary();
        employeess.name = temp.getName();
        employeess.salary = temp.getSalary();

    }
}
