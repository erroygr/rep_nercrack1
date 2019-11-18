package model;


import model.interf.Gender;
import model.interf.IDivision;
import model.interf.IPerson;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Optional;


public class Person implements Comparable<Person>, IPerson {

    private Integer id;
    private String surname;  //фамилия
    private String name;    //имя
    private String patronymic;  //отчество
    private Gender gender;   //пол
    private DateTime birthDay;
    private Division division; //отдел
    private BigDecimal salary; //ЗП

    public Person(){

    }

    public Person( int id, String surname, String name, String patronymic, Gender gender,DateTime birthDay ,Division division, BigDecimal salary ) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.gender = gender;
        this.birthDay = birthDay;
        this.division=division;
        this.salary=salary;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getFirstName() {
        return name;
    }

    @Override
    public void setFirstName(String firstName) {
        this.name = firstName;
    }

    @Override
    public String getLastName() {
        return surname;
    }

    @Override
    public void setLastName(String firstName) {
        this.surname=firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }


    @Override
    public DateTime getBirthdate() {
        return birthDay;
    }

    @Override
    public void setBirthdate(DateTime birthdate) {
        this.birthDay = birthdate;
    }

    public Gender  getGender() {
        return gender;
    }

    @Override
    public void setGender(Gender gender) {
        this.gender = gender;
    }



    @Override
    public Integer getAge( DateTime birthDay) {
        DateTime checkDay=new DateTime();
        int years = checkDay.getYear() - birthDay.getYear();

        int checkMonth = checkDay.getMonthOfYear();
        int birthMonth = birthDay.getMonthOfYear();
        if ( checkMonth < birthMonth ) {
            years --;
        } else  if (checkMonth == birthMonth
                && checkDay.getDayOfMonth() < birthDay.getDayOfMonth()) {

            years --;
        }
        return years;
    }


    @Override
    public Division getDivision() {
        return division;
    }

    @Override
    public void setDivision(Division division) {
    this.division=division;
    }

    @Override
    public BigDecimal getSalary() {
        return salary;
    }

    @Override
    public void setSalary(BigDecimal salary) {
    this.salary=salary;
    }


    public String outPerson(){

        return  " Код: "+getId()+
                ",\n Фамилия: "+getLastName()+",\n Имя: "+getFirstName()+
                ",\n Отчество: "+getPatronymic()+",\n Пол: "+getGender()+
                ",\n Дата рождения: "+birthDay.getDayOfMonth()+"."+birthDay.getMonthOfYear()+"."+ birthDay.getYear()+" г."+
                ",\n Возраст: "+getAge(birthDay) +
                "\n Должность: "+getDivision().getName()+
                "\n Зарплата: "+getSalary()+"\n";
    }


    public String outPerson1(){

        return  " | Код: " + getId() +
                " | Имя: " + getFirstName() +
                " | Возраст: " + getAge(getBirthdate()) +
                " | Пол: " + getGender()+
                " | Должность: "+ getDivision().getName()+
                " | Зарплата: "+getSalary();
    }




    public int compareTo(Person emp) {
        return (this.id - emp.id);
    }

    public static Comparator<Person> AgeComparator = new Comparator<Person>() {
        @Override
        public int compare(Person e1, Person e2) {
            if (e1.getAge(e1.birthDay) > e2.getAge(e2.birthDay))
                return 1;
            else if (e1.getAge(e1.birthDay) == e2.getAge(e2.birthDay))
                return 0;
            return -1;
        }
    };


    public static Comparator<Person> NamePersonComparator = new Comparator<Person>() {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getFirstName().compareTo(e2.getFirstName());
        }
    };

    public static Comparator<Person> SurnamePersonComparator = new Comparator<Person>() {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getLastName().compareTo(e2.getLastName());
        }
    };

    public static Comparator<Person> PatronymicPersonComparator = new Comparator<Person>() {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getPatronymic().compareTo(e2.getPatronymic());
        }
    };


    public static Comparator<Person> GenderPersonComparator = new Comparator<Person>() {

        @Override
        public int compare(Person e1, Person e2) {
            return e1.getGender().compareTo(e2.getGender());
        }
    };

}
