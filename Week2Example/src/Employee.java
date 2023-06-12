
public class Employee // cookie cutter
{
    // instance variables

    private String empName;
    private double hours;
    private double rate;

    // constructors
    public Employee() 
    {
        empName = "none";
        hours = 0.0;
        rate = 0.0;
    }

    public Employee(String empName, double hours, double rate) 
    {
        this.empName = empName;
        this.hours = hours;
        this.rate = rate;
    }

    // behaviors
    double getPay() 
    {
        return hours * rate;
    }

    // getters and setters
    public String getName() 
    {
        // return the value of the private instance variable
        return empName;
    }

    public void setName(String ename) 
    {
        //store the value of ename into the instance variable empName
        empName = ename;
    }

    public double getHours() 
    {
        return hours;
    }

    public void setHours(double hours) 
    {
        //store the value of h into the instance variable hours
        this.hours = hours;  // same word so use the “this” modifier
    }

    public double getRate() 
    {
        return rate;
    }

    public void setRate(double rate) 
    {
        //store the value of h into the instance variable hours
        this.rate = rate;  // same word so use the “this” modifier
    }

}   //end class Employee
