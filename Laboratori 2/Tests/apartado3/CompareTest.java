package apartado3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CompareTest {
    @Test
    void CompareToTestWithPersons() {
        Person p1 = new Person("Marc Cervera");
        Person p2 = new Person("marc cervera");
        Person p3 = new Person("MaRc CeRvErA");
        assertEquals(0, p1.compareTo(p2));
        assertEquals(0, p1.compareTo(p3));
        assertEquals(0, p2.compareTo(p3));
    }

    @Test
    void CompareToWithEmployees() {
        Employee e1 = new Employee("Marc Cervera", 25_000);
        Employee e2 = new Employee("sergi cervera", 25_000);
        Employee e3 = new Employee("MARC CERVERA", 25_000);
        Employee e4 = new Employee("SERGI CERVERA", 25_000);
        Employee e5 = new Employee("Sergi Cervera", 25_000);
        Employee e6 = new Employee("marc cervera", 25_000);
        assertEquals(0, e1.compareTo(e3));
        assertEquals(0, e2.compareTo(e4));
        assertEquals(0, e1.compareTo(e6));
        assertEquals(0, e2.compareTo(e5));
        assertEquals(0, e6.compareTo(e3));
        assertEquals(0, e5.compareTo(e4));
    }

    @Test
    void CompareToTestMixted() {
        Person p1 = new Person("marc cervera");
        Employee e1 = new Employee("Marc Cervera", 25_000);
        Person p2 = new Person("Sergi Cervera");
        Employee e2 = new Employee("sergi cervera", 25_000);
        Person p3 = new Person("MaRc CeRvErA");
        Employee e3 = new Employee("MARC CERVERA", 25_000);
        Person p4 = new Person("SeRgI cErVeRa");
        Employee e4 = new Employee("SERGI CERVERA", 25_000);
        assertEquals(0, p1.compareTo((Person) e1));
        assertEquals(0, p2.compareTo((Person) e2));
        assertEquals(0, p3.compareTo((Person) e3));
        assertEquals(0, p4.compareTo((Person) e4));
    }
}
