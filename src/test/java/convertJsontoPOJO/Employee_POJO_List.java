package convertJsontoPOJO;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.List;

/*
This is the main POJO Class covering all the list of the values - this is the main Json Node -
 which can have mutiple JSON values
 */
public class Employee_POJO_List {

    private List<Employee_POJO_Class> Employee = null ;

    public List<Employee_POJO_Class> getEmpList() {
        return Employee ;
    }

    public void setEmployee(List<Employee_POJO_Class> empList) {

        this.Employee = empList;

    }

    public String toString() {

        return new ToStringBuilder(this).append("employee" , Employee).toString();
    }

}
