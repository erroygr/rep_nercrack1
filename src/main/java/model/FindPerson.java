package model;

import java.util.Optional;

public class FindPerson {

    private Person[] reposPerson;


    public FindPerson( Person[] reposPerson){
        this.reposPerson=reposPerson;
    }


    public Optional<Person> findOnId(int id) {
        for (Person person : reposPerson) {
            if (person.getId() == id)
                return Optional.of(person);
        }
        return Optional.empty();
    }

    public Optional<Person[]> findOnFirstName(String name) {
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        for (Person person : reposPerson) {
            if (person.getFirstName()==name)
                repositoryPerson.add(person);
        }
        return Optional.of(repositoryPerson.get());
    }

    public Optional<Person[]> findOnAge(int age) {
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        for (Person person : reposPerson) {
            if (person.getAge(person.getBirthdate()) == age)
                repositoryPerson.add(person);
        }
        return Optional.of(repositoryPerson.get());
    }


}
