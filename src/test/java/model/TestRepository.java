package model;

import model.Division;
import model.Person;
import model.RepositoryPerson;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static ru.vsu.lab.entities.enums.Gender.MALE;

public class TestRepository {

    private Person person1 = new Person(1,"Иванов","Иван","Иванович", MALE, LocalDate.now(),  new Division(4343,"Продажи"),new BigDecimal("105000"));
    private Person nullPerson = new Person(0, null, null, null, null, null, null, null);

    @Test
    public void testAddOneElement() {
        RepositoryPerson testArray = new RepositoryPerson();
        Assert.assertTrue(testArray.size() == 0);

        testArray.add(person1);
        Assert.assertTrue(testArray.size() == 1);
    }

    @Test
    public void testAddGetAndCheckOneElementFromArray() {
        RepositoryPerson testArray = new RepositoryPerson();
        testArray.add(person1);
        Assert.assertEquals(person1, testArray.get(0));
    }
    @Test
    public void testAddElementByIndexAndCheckIt() {
        RepositoryPerson testArray = new RepositoryPerson();
        testArray.add(nullPerson);
        testArray.add(0, person1);
        Assert.assertEquals(person1, testArray.get(0));
    }

    @Test
    public void testAddAndSetThisElement() {
        RepositoryPerson testArray = new RepositoryPerson();
        testArray.add(nullPerson);
        testArray.set(0, person1);
        Assert.assertEquals(person1, testArray.get(0));
    }

    @Test
    public void testDeleteOneElement() {
        RepositoryPerson testArray = new RepositoryPerson();
        testArray.add(person1);
        Assert.assertTrue(testArray.size() == 1);

        testArray.delete(0);
        Assert.assertTrue(testArray.size() == 0);
    }

    @Test
    public void testArrayToList() {
        RepositoryPerson testArray = new RepositoryPerson();
        Assert.assertTrue((testArray.toList()) instanceof List);
    }

}
