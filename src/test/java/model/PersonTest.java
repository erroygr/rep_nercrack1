package model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import ru.vsu.lab.entities.enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static ru.vsu.lab.entities.enums.Gender.MALE;

class PersonTest {
    private Person person1 = new Person(1,"Иванов","Иван","Иванович", MALE, LocalDate.now(),  new Division(4343,"Продажи"),new BigDecimal("105000"));

    @Test
    void getId() {
        Assert.assertTrue(person1.getId()==1);
    }

    @Test
    void setId() {
        Person person =new Person();
        person.setId(23);
        Assert.assertTrue(person.getId()==23);
    }

    @Test
    void getFirstName() {
        Assert.assertTrue(person1.getFirstName()=="Иван");
    }

    @Test
    void setFirstName() {
        Person person =new Person();
        person.setFirstName("name");
        Assert.assertTrue(person.getFirstName()=="name");
    }

    @Test
    void getLastName() {
        Assert.assertTrue(person1.getLastName()=="Иванов");
    }

    @Test
    void setLastName() {
        Person person =new Person();
        person.setLastName("23");
        Assert.assertTrue(person.getLastName()=="23");
    }

    @Test
    void getPatronymic() {
        Assert.assertTrue(person1.getPatronymic()=="Иванович");
    }

    @Test
    void setPatronymic() {
        Person person =new Person();
        person.setPatronymic("23");
        Assert.assertTrue(person.getPatronymic()=="23");
    }

    @Test
    void getGender() {
        Assert.assertTrue(person1.getGender()== MALE);
    }

    @Test
    void setGender() {
        Person person =new Person();
        person.setGender(MALE);
        Assert.assertTrue(person.getGender()== MALE);
    }

    @Test
    void getDivision() {
        Assert.assertTrue(person1.getDivision().getName()== "Продажи");
    }

    @Test
    void setDivision() {
        Person person =new Person();
        person.setDivision(new Division(1,"23"));
        Assert.assertTrue(person.getDivision().getName()=="23");
    }

    @Test
    void getSalary() {
        Assert.assertTrue(Integer.valueOf(String.valueOf(person1.getSalary()))==105000 );
    }

    @Test
    void setSalary() {
        Person person =new Person();
        person.setSalary(new BigDecimal("23"));
        Assert.assertTrue(Integer.valueOf(String.valueOf(person.getSalary()))== 23);
    }


}