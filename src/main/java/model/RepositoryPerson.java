package model;
import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.IRepository;

import java.util.*;
import java.util.function.Predicate;

import static model.Person.AgeComparator;
import static model.Person.NamePersonComparator;


public  class RepositoryPerson<T> implements IRepository<T> {

    private final int INIT_SIZE = 8;

    private final int CUT_RATE = 2;

    private Object [] personRepos = new Object[INIT_SIZE];
    private int nElems=0;

    public RepositoryPerson(){

    }
    
    public int size()
    {
        return nElems;
    }


    public void add(T person) {
        if (nElems == personRepos.length - 1) {
            resize(personRepos.length * 2);
        }
        personRepos[nElems++] = person;
    }

    public T delete(int value)  // удалить элемент
    {
        T deleteItem = (T) personRepos[value];
        for (int i = value; i < nElems; i++)
            personRepos[i] = personRepos[i + 1];
        personRepos[nElems] = null;
        nElems--;
        if (personRepos.length > INIT_SIZE && nElems < personRepos.length / CUT_RATE)
            resize(personRepos.length / 2);
        return deleteItem;
    }

    @Override
    public T set(int i, T o) {
        if (i < 0 || i >= size()) throw new ArrayIndexOutOfBoundsException();
        T old = (T) personRepos[i];
        personRepos[i] = o;
        return old;
    }

    @Override
    public void add(int index, T person) {
        if (nElems == personRepos.length - 1) {
            resize(personRepos.length * 2);
        }
        for (int i = nElems; i > index; i--) {
            personRepos[i] = personRepos[i - 1];
        }
        personRepos[index] = person;
        nElems++;
    }

    @Override
    public T get(int index) {
        return (T) personRepos[index];
    }

    public Person getPerson(int ind){
        return (Person) personRepos[ind];
    }



    private void resize(int newLength) {
        IPerson[] newArray = new IPerson[newLength];
        System.arraycopy(personRepos, 0, newArray, 0, nElems);
        personRepos = newArray;
    }

    @Override
    public List<T> toList() {
        return(List<T>) Arrays.asList(personRepos);
    }

    @Override
    public void sortBy(Comparator<T> comparator) {
       BubbleSort<T> bubbleSort = new BubbleSort<>();
        bubbleSort.doBubbleSort((T[]) personRepos, comparator);
    }


    @Override
    public IRepository searchBy(Predicate<T> condition) {
        IRepository<T> repository = new RepositoryPerson<>();
        for (int i = 0; i < size(); i++) {
            if (condition.test((T) personRepos[i])) {
                repository.add((T) personRepos[i]);
            }
        }
        return repository;
    }

    public String display(RepositoryPerson repositoryPerson)
    {
        String str="";
        for(int j=0; j<nElems; j++) {
            str +=   repositoryPerson.getPerson(j).outPerson_()+ "\n";

        }
        return str;
    }

    public  void printPerson(RepositoryPerson repositoryPerson) {
        for (int i=0; i< repositoryPerson.size(); i++) {
            System.out.println((repositoryPerson.getPerson(i)).outPerson(repositoryPerson.getPerson(i)));
        }
    }

  /*  public RepositoryPerson searchByAge() {
        return (RepositoryPerson) AgeComparator;
    }

    public RepositoryPerson searchByName() {
        return (RepositoryPerson) NamePersonComparator;
    }*/


}
