package model.interf;

import model.Person;
import model.RepositoryPerson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Predicate;

public interface IRepository {

     void add(Person person);
     Person[] get();
     void delete(int index);
     IPerson set(int index, IPerson person);
     void add(int index, IPerson person);
     ArrayList<Person> toList();

    //Should not use toList method
     void sortBy(Comparator<Person> comparator );



    RepositoryPerson searchByName(Predicate<Person> condition);
    RepositoryPerson searchByFirstName(Predicate<Person> condition);
    RepositoryPerson searchByPatronymicName(Predicate<Person> condition);
    RepositoryPerson searchByGender(Predicate<Person> condition);
    RepositoryPerson searchByAge(Predicate<Person> condition);


}
