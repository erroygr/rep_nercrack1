import model.*;
import org.joda.time.DateTime;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.entities.enums.Gender;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Predicate;

import static ru.vsu.lab.entities.enums.Gender.FEMALE;
import static ru.vsu.lab.entities.enums.Gender.MALE;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {



        String separator = File.separator;
        String filePath = "src" + separator + "main" + separator + "resources" + separator + "persons.csv";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

/*
        Person person1=new Person(1,"Иванов","Иван","Иванович", MALE, LocalDate.parse("10.04.1998", formatter),  new Division(4343,"Продажи"),new BigDecimal("105000"));
        Person person2=new Person(2,"Петров","Петр","Петрович",MALE,LocalDate.parse("14.12.2000", formatter), new Division(41133,"Сервис"),new BigDecimal("155000"));
        Person person3=new Person(3,"Иванчюк","Елена","Валерьевна",FEMALE,LocalDate.parse("24.06.1999", formatter), new Division(56755,"Разработка"),new BigDecimal("167000"));
        Person person4=new Person(4,"Кисилева","Елена","Петровна",FEMALE,LocalDate.parse("11.11.2001", formatter), new Division(12345,"Тех.отдел"),new BigDecimal("30460"));


        RepositoryPerson repositoryPerson=new RepositoryPerson();

        repositoryPerson.add(person1);
        repositoryPerson.add(person2);

        System.out.println(repositoryPerson.display(repositoryPerson));
       repositoryPerson.add(person3);
        System.out.println(repositoryPerson.display(repositoryPerson));
       repositoryPerson.add(person4);

        System.out.println(repositoryPerson.display(repositoryPerson));
        System.out.println("Кол-во записей: "+repositoryPerson.size());

        System.out.println("Удалить запись: 4");
        repositoryPerson.delete(person3.getId());
        //repositoryPerson.delete(person3.getId());

        System.out.println(repositoryPerson.display(repositoryPerson));
        System.out.println("Кол-во записей: "+repositoryPerson.size());


        repositoryPerson.add(person3);
        System.out.println(repositoryPerson.display(repositoryPerson));
        System.out.println("Кол-во записей: "+repositoryPerson.size());


        System.out.println("По Возрасту");
        //сортировка по возрасту по возрастанию
       // repositoryPerson.searchByAge();
        System.out.println(repositoryPerson.display(repositoryPerson));

        System.out.println("По Имени");
        //сортировка по имени А-Я
       // repositoryPerson.searchByName();
        System.out.println(repositoryPerson.display(repositoryPerson));*/


////////////////////////////////////////////////////////////////////////////////////////////////////
/*        System.out.println("По Коду");
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
        System.out.println(repositoryPerson.display());*/
//////////////////////////////////////////
     /*   FindPerson findPerson = new FindPerson(repositoryPerson);

        System.out.println("\n Ищем человека с Кодом 1: ");
        repositoryPerson.printPerson(findPerson.searchBy(findPerson.isId(1)));*/
//////////////////////////////////////////////
      //  System.out.println("\n Поиск по возрасту: 18 лет");
       // repositoryPerson.printPerson(findPerson.searchBy(findPerson.isAge(18)));

       // System.out.println("\n Поиск по имени Елена: ");
        //repositoryPerson.printPerson(findPerson.searchBy(findPerson.isNAME("Елена")));

      //  System.out.println("\n Поиск по полу MALE: ");
       // repositoryPerson.printPerson(findPerson.searchBy(findPerson.isGender(MALE)));



        // ЧТЕНИЕ файла
        Scanner scanner = new Scanner(new File(filePath));
        ReadFromFile readFromFile = new ReadFromFile(scanner);


        PersonFactory factory = new PersonFactory();

        RepositoryPerson factoryRepositoryPerson = (RepositoryPerson) readFromFile.parse(factory);
                        //(RepositoryPerson) factory.createRepository(factory.createPerson().getClass()));

        System.out.println(factoryRepositoryPerson.display(factoryRepositoryPerson));

       // RepositoryPerson repositoryPerson1 =  readFromFile.parserPerson();
       // System.out.println(repositoryPerson1.display(repositoryPerson1));


      //  repositoryPerson1.add(new Person());
      //  factoryRepositoryPerson.get(0);
       // System.out.println(repositoryPerson1.get(0).toString());


    }




}
