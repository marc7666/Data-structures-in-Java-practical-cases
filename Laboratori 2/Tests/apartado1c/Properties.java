package apartado1c;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Properties {
    @Test
    void reflexivity() {
        Person p = new Person("John Doe");
        assertEquals(p, p);
    }

    @Test
    void symmetry1() {
        Person p1 = new Person("John Doe");
        Person p2 = new Person("John Doe");
        assertEquals(p1, p2);
        assertEquals(p2, p1);
    }

    @Test
    void symmetry2() {
        Person p1 = new Person("John Doe");
        Person p2 = new Person("Jane Doe");
        assertNotEquals(p1, p2);
        assertNotEquals(p2, p1);
    }

    @Test
    void transitivity() {
        Person p1 = new Person("John Doe");
        Person p2 = new Person("John Doe");
        Person p3 = new Person("John Doe");
        assertEquals(p1, p2);
        assertEquals(p2, p3);
        assertEquals(p1, p3);
    }

    @Test
    void nullParameter() {
        Person p = new Person("John Doe");
        assertNotEquals(p, null);
    }

    @Test
    void interoperable() {
        Person p = new Person("John Doe");
        Employee e = new Employee("John Doe", 25_000);
        assertEquals(p, e);
        assertEquals(e, p);
    }

    @Test
    void noTransitivity() {
        Employee e1 = new Employee("Clint Eastwood", 25_000);
        Employee e2 = new Employee("Clint Eastwood", 75_000);
        Person p = new Person("Clint Eastwood");
        assertEquals(e1, e2);
        assertEquals(e2, p);
        assertEquals(e1, p);
        assertNotEquals(e1.getSalary(), e2.getSalary());

        /**
         * If we supose:
         * e1 = x
         * e2 = y
         * p = z
         * (x R y) && (y R z) => (x R z) ==> At the name level
         * (x.getSalary() !R y.getSalary()) ==> At the salary level ==> We've lost the transitivity
         * */
    }
}
