package exception;

public class EmployeeNotFoundException extends Exception{

    public EmployeeNotFoundException(){
        super("Employee with this Id already there in db");
    }
    public EmployeeNotFoundException(String msg){
        super(msg);
    }

}
