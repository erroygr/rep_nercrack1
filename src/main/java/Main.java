import model.Division;
import model.Person;
import model.RepositoryPerson;
import org.joda.time.DateTime;

import java.math.BigDecimal;
import java.util.*;

import static model.interf.Gender.MALE;
import static model.interf.Gender.FEMALE;

public class Main {

    public static void main(String[] args) {

        Person person1=new Person(1,"Иванов","Иван","Иванович",MALE, new DateTime(1998,4,10,0,0), new Division(1,"Менеджер"),new BigDecimal("105000"));
        Person person2=new Person(2,"Петров","Петр","Петрович",MALE,new DateTime(2000,12,14,0,0), new Division(1,"Программист"),new BigDecimal("155000"));
        Person person3=new Person(3,"Иванчюк","Оксана","Валерьевна",FEMALE,new DateTime(1999,6,24,0,0), new Division(1,"Экономист"),new BigDecimal("167000"));
        Person person4=new Person(4,"Кисилева","Елена","Петровна",FEMALE,new DateTime(2001,11,11,0,0), new Division(1,"Продавец"),new BigDecimal("30460"));


        RepositoryPerson repositoryPerson=new RepositoryPerson(2);

        repositoryPerson.add(person1);
        repositoryPerson.add(person2);
        System.out.println(repositoryPerson.display());
       repositoryPerson.add(person3);
        System.out.println(repositoryPerson.display());
       repositoryPerson.add(person4);

        System.out.println(repositoryPerson.display());
        System.out.println("Кол-во записей: "+repositoryPerson.size());

        System.out.println("Удалить запись: "+repositoryPerson.find(person4.getId()));
        repositoryPerson.delete(person3.getId());


        System.out.println(repositoryPerson.display());
        System.out.println("Кол-во записей: "+repositoryPerson.size());


        repositoryPerson.add(person3);
        System.out.println(repositoryPerson.display());
        System.out.println("Кол-во записей: "+repositoryPerson.size());


        System.out.println("По Возрасту");
        //сортировка по возрасту по возрастанию
        Arrays.sort(repositoryPerson.get(), Person.AgeComparator);
        System.out.println(repositoryPerson.display());

        System.out.println("По Имени");
        //сортировка по имени А-Я
        Arrays.sort(repositoryPerson.get(), Person.NamePersonComparator);
        System.out.println(repositoryPerson.display());

        System.out.println("По Коду");
        //сортировка по коду-id
        Arrays.sort(repositoryPerson.get());
        System.out.println(repositoryPerson.display());

        System.out.println("По Фамилии");
        //сортировка по фамилии А-Я
        Arrays.sort(repositoryPerson.get(), Person.SurnamePersonComparator);
        System.out.println(repositoryPerson.display());

        System.out.println("По Отчеству");
        //сортировка по отчеству А-Я
        Arrays.sort(repositoryPerson.get(), Person.PatronymicPersonComparator);
        System.out.println(repositoryPerson.display());

        System.out.println("По Полу");
        //сортировка по полу А-Я
        Arrays.sort(repositoryPerson.get(), Person.GenderPersonComparator);
        System.out.println(repositoryPerson.display());
    }


}
