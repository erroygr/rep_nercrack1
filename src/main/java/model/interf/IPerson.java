package model.interf;

import model.Division;
import org.joda.time.DateTime;

import java.math.BigDecimal;

public interface IPerson {

     Integer getId();
     void setId(Integer id);
     String getFirstName();
     void setFirstName(String firstName);
     String getLastName();
     void setLastName(String lastName);
     DateTime getBirthdate();
     void setBirthdate(DateTime birthdate);
     Integer getAge(DateTime birthDay);
     Gender getGender();
     void setGender(Gender gender);
     Division getDivision();
     void setDivision(Division division);
     BigDecimal getSalary();
     void setSalary(BigDecimal salary);


}
