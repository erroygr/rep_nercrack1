package model.interf;

import model.Division;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


public interface IPerson {

     Integer getId();
     void setId(Integer id);
     String getFirstName();
     void setFirstName(String firstName);
     String getLastName();
     void setLastName(String lastName);
    LocalDate getBirthdate();
     void setBirthdate(LocalDate  birthdate);
     int getAge(LocalDate  birthDay);
     Gender getGender();
     void setGender(Gender gender);
     Division getDivision();
     void setDivision(Division division);
     BigDecimal getSalary();
     void setSalary(BigDecimal salary);


}
