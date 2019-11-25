
import model.Division;
import model.Person;
import model.RepositoryPerson;
import model.interf.Gender;
import org.joda.time.format.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class ReadFromFile {

    private Scanner scanner;
    private Map<String, Division> divisionMap = new HashMap<>();

    public ReadFromFile(Scanner scanner) {
        this.scanner=scanner;
    }


    public RepositoryPerson parserPerson() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        RepositoryPerson repositoryPerson = new RepositoryPerson();
        scanner.nextLine();

        while (scanner.hasNext()) {

            Person person = new Person();
            String[] subStr = scanner.nextLine().split(";");

            person.setId(Integer.valueOf(subStr[0]));
            person.setFirstName(subStr[1]);
            person.setGender(Gender.valueOf(subStr[2]));
            person.setBirthdate(LocalDate.parse(subStr[3], formatter));

            person.setDivision(getDivision(subStr[4]));
            person.setSalary(BigDecimal.valueOf(Integer.parseInt(subStr[5])));
            repositoryPerson.add(person);


        }

        return repositoryPerson;
    }

    public Division getDivision(String line) {
        if (divisionMap.containsKey(line)) {
            return divisionMap.get(line);
        } else {
            Division resDiv = new Division(Division.randId(), line);
            divisionMap.put(line, resDiv);
            return resDiv;
        }


    }
}
