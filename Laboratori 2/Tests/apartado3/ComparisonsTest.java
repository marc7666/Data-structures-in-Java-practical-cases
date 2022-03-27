package apartado3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ComparisonsTest {
    @Test
    void mixed1() {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("John Doe", 150_000),
                new Employee("Peter Parker", 12_000),
                new Employee("Bruce Wayne", 999_999),
                new Employee("Clark Kent", 45_000)));
        var expected = List.of(
                new Employee("Peter Parker", 12_000));
        Comparisions.removeLower(employees.iterator(),
                new Person("Noname"));
        assertEquals(expected, employees);
    }

    @Test
    void mixed2() {
        List<Person> people = new ArrayList<>(List.of(
                new Employee("John Doe", 150_000),
                new Employee("Peter Parker", 12_000),
                new Employee("Bruce Wayne", 999_999),
                new Employee("Clark Kent", 45_000)
        ));
        var expected = List.of(
                new Employee("Peter Parker", 12_000));
        Comparisions.removeLower(people.iterator(), new Employee("Noname", 0));
        assertEquals(expected, people);
    }

    @Test
    void employees() {
        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("John Doe", 150_000),
                new Employee("Peter Parker", 12_000),
                new Employee("Bruce Wayne", 999_999),
                new Employee("Clark Kent", 45_000)
        ));
        var expected = List.of(
                new Employee("Peter Parker", 12_000));
        Comparisions.removeLower(employees.iterator(),
                new Employee("Noname", 0));
        assertEquals(expected, employees);
    }

    @Test
    void persons() {
        List<Person> persons = new ArrayList<>(List.of(
                new Person("John Doe"),
                new Person("Peter Parker"),
                new Person("Bruce Wayne"),
                new Person("Clark Kent")
        ));
        var expected = List.of(
                new Person("Peter Parker"));
        Comparisions.removeLower(persons.iterator(), new Person("Noname"));
        assertEquals(expected, persons);
    }
}
