package model;

import model.interf.Gender;

import java.util.function.Predicate;

public class FindPerson {

    private RepositoryPerson reposPerson;


    public FindPerson( RepositoryPerson reposPerson){
        this.reposPerson=reposPerson;
    }

    public  Predicate<Person> isNAME(String name) {
        return  person -> person.getFirstName() == name;
    }

    public  Predicate<Person> isLastName(String LastName) {
        return  person -> person.getLastName() == LastName;
    }

    public  Predicate<Person> isPatronymic(String Patronymic) {
        return  person -> person.getPatronymic() == Patronymic;
    }

    public  Predicate<Person> isId(Integer id) {
        return  person -> person.getId() == id;
    }

    public  Predicate<Person> isDivisionName(String nameDivision) {
        return  person -> person.getDivision().getName() == nameDivision;
    }

    public  Predicate<Person> isAge(int age) {
        return  person -> person.getAge(person.getBirthdate()) == age;
    }

    public  Predicate<Person> isGender(Gender gender) {
        return  person -> person.getGender() == gender;
    }



    public RepositoryPerson searchBy(Predicate<Person> condition) {
        RepositoryPerson  repository = new RepositoryPerson();
        for (int i = 0; i < reposPerson.size(); i++) {
            if (condition.test( reposPerson.getPers(i))) {
                repository.add(reposPerson.getPers(i));
            }
        }
        return repository;
    }
}
