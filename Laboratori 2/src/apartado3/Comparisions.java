package apartado3;

import java.util.Iterator;

public class Comparisions {
    public static <E extends Comparable<? super E>> void removeLower(Iterator<? extends E> it, Comparable<E> reference){
        while (it.hasNext()){
            E element = it.next();
            if (reference.compareTo(element) > 0){
                it.remove();
            }
        }
    }
}
