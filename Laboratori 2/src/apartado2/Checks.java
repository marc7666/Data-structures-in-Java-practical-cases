package apartado2;

import java.util.Iterator;

public class Checks {
    public static <E> void removeIf(Iterator<E> it, Check<E> test) {
        while (it.hasNext()) {
            E elem = it.next();
            if (test.test(elem)) {
                it.remove();
            }
        }
    }
}
