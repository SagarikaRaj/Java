package domain;

/**
 *
 * @author Sagarika
 */
public class Record 
{
   
    // Columns in the DB record...

    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String extension;
    private String email;
    private String officeCode;
    private String reportsTo;
    private String jobTitle;
    
   //no-arg constructor
    public Record() 
    {
    }
     //full arg constructor
    public Record(int employeeNumber, String lastName, String firstName, String extension, String email, String officeCode, String reportsTo, String jobTitle)
    {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.extension = extension;
        this.email = email;
        this.officeCode = officeCode;
        this.reportsTo = reportsTo;
        this.jobTitle = jobTitle;
    }


    //accessors and mutators
    
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(String reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    
    //toString Method
    
    @Override
    public String toString()
    {
        return "employeeNumber = " + employeeNumber + ", lastName = " + lastName + ","
                + " firstName = " + firstName + ", extension = " + extension + ", email = " + email + ","
                + " officeCode = " + officeCode + ", reportsTo = " + reportsTo + ", jobTitle = " + jobTitle;
    }
}
