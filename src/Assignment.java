public class Assignment
{
    public String name;
    public String subject;
    public String duedate;
    public String dueday;
    //constructs a new Assignment object
    public Assignment(String name, String subject, String duedate, String dueday){
        this.name=name;
        this.subject=subject;
        this.duedate=duedate;
        this.dueday=dueday;
    }
    //returns the name of the assignment
    public String getName(){
        return this.name;
    }
    //returns what subject the assignment is for
    public String getSubject(){
        return this.subject;
    }
    //returns the date of when the assignment is due
    public String getDuedate(){
        return this.duedate;
    }
    //returns the day of the week that the assignment is due
    public String getDueday(){
        return this.dueday;
    }
    //returns a formatted version of the String
    public String format(){
        return getSubject() + " | " + getName() + " - " + getDueday() + " " + getDuedate();

    }
}
