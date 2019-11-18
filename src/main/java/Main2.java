
import model.Division;
import model.Person;
import model.RepositoryPerson;
import model.interf.Gender;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.math.BigDecimal;
import java.util.Arrays;


public class Main2 {

    public static void main(String[] args) {

        String delimeter = ";";
       String delimeter1 = ".";

        Person person;
        RepositoryPerson repositoryPerson=new RepositoryPerson();
        try (BufferedReader br = new BufferedReader(new FileReader("persons.csv"))) {
            //чтение построчно
            String s;
            while ((s = br.readLine()) != null) {
                String[] subStr;
                subStr = s.split(delimeter);
              int[] sub1= Arrays.stream( subStr[3].split("[,;:.!?\\s]+")).mapToInt(Integer::parseInt).toArray();

      //          System.out.println(sub1[0]+" "+sub1[1]+" "+sub1[2]);

                person=new Person();
                person.setId(Integer.valueOf(subStr[0]));
                person.setFirstName(subStr[1]);
                person.setGender(Gender.valueOf(subStr[2]));
               person.setBirthdate(new DateTime(sub1[2],sub1[1],sub1[1],0,0));

                person.setDivision(new Division(subStr[4]));
                person.setSalary(new BigDecimal(subStr[5]));
                repositoryPerson.add(person);

              System.out.println(repositoryPerson.display1());
            }
        } catch (IOException ex) {

          System.out.println(ex.getMessage());
        }


       // Arrays.sort(repositoryPerson.get(), Person.AgeComparator);
        //System.out.println(repositoryPerson.display1());
    }
}
