package model;

import model.interf.IPerson;
import model.interf.IRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

import static model.Person.*;

public class RepositoryPerson implements IRepository {


    private Person [] personRepos;
private int nElems=0;

    public RepositoryPerson(int max){
    personRepos=new Person[max];
}

    public int size()
    {
        return nElems;
    }


    public int find(int searchKey)   //найти
    {
        int lowerBound = 0;
        int upperBound = nElems-1;
        int curIn;

        while(true)
        {
            curIn = (lowerBound + upperBound ) / 2;
            if(personRepos[curIn].getId()==searchKey) {
                return curIn;
            } else if(lowerBound > upperBound)
                return nElems;
            else
            {
                if(personRepos[curIn].getId() < searchKey)
                    lowerBound = curIn + 1;
                else
                    upperBound = curIn - 1;
            }
        }
    }

    public Person[] get() {
        return personRepos;
    }

    public void add( Person person){

        if (size() >= personRepos.length) {
            int newSize =2+ personRepos.length;

            Person[] newData = new Person[newSize];
            System.arraycopy(personRepos, 0, newData,0, personRepos.length);
            personRepos = newData;
        }
        personRepos[nElems] = person;
        nElems++;
    }


    public void delete(int value)  // удалить элемент
    {
        int searchKey  = find(value);
        for ( int j = 0; j < nElems; j++)
        {
        if (personRepos[j].getId() == searchKey)
            break;
                }
        for (int k = searchKey; k < nElems - 1; k++) //сдвиг последующих элементов
            personRepos[k] = personRepos[k + 1];
        nElems--;

    }


    public String display()
    {
        String str="";
        for(int j=0; j<nElems; j++) {
            str +=  personRepos[j].outPerson() + "\n";

        }
        return str;
    }

    public String display1()
    {
        String str="";
        for(int j=0; j<nElems; j++) {
            str +=  personRepos[j].outPerson1() + "\n";

        }
        return str;
    }




    @Override
    public IPerson set(int index, IPerson person) {
        return null;
    }

    @Override
    public void add(int index, IPerson person) {

    }

    @Override
    public ArrayList<Person> toList() {
        return (ArrayList<Person>) Arrays.asList(personRepos);
    }


    @Override
    public void sortBy(Comparator<Person> comparator) {

    }

    @Override
    public RepositoryPerson searchByName(Predicate<Person> condition) {
        return (RepositoryPerson) NamePersonComparator;
    }

    @Override
    public RepositoryPerson searchByFirstName(Predicate<Person> condition) {
        return (RepositoryPerson) SurnamePersonComparator;
    }

    @Override
    public RepositoryPerson searchByPatronymicName(Predicate<Person> condition) {
        return (RepositoryPerson) PatronymicPersonComparator;
    }

    @Override
    public RepositoryPerson searchByGender(Predicate<Person> condition) {
        return (RepositoryPerson) GenderPersonComparator;
    }

    @Override
    public RepositoryPerson searchByAge(Predicate<Person> condition) {
        return (RepositoryPerson) AgeComparator;
    }

}
