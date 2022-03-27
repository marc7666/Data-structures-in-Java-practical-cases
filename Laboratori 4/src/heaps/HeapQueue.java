package heaps;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class HeapQueue<V, P extends Comparable<? super P>> implements PriorityQueue<V, P> {
    private final ArrayList<Triplet<V, P>> triplets;
    private long nextTimeStamp = 0L;


    static class Triplet<V, P extends Comparable<? super P>> implements Comparable<Triplet<V, P>> {
        private final P priority;
        private final V value;
        private final long timeStamp;

        public Triplet(P priority, V value, long timeStamp) {
            this.priority = priority;
            this.value = value;
            this.timeStamp = timeStamp;
        }

        @Override
        public int compareTo(Triplet<V, P> o) {
            if (this.priority == null) {
                return -1;
            } else if (o.priority == null) {
                return 1;
            } else if (this.priority.compareTo(o.priority) > 0) {
                return 1;
            } else if (this.priority.compareTo(o.priority) < 0) {
                return -1;
            } else if (this.priority.equals(o.priority)) {
                if (this.timeStamp < o.timeStamp) {
                    return 1;
                } else if (this.timeStamp > o.timeStamp) {
                    return -1;
                }
            }
            return 0;
        }
    }

    public HeapQueue() {
        this.triplets = new ArrayList<>();
    }

    @Override
    public void add(V value, P priority) {
        Triplet<V, P> triplet = new Triplet<>(priority, value, nextTimeStamp);
        triplets.add(triplet);
        nextTimeStamp += 1;
        int i = size();
        while (hasParent(i)) {
            if (triplet.compareTo(getParent(i)) > 0) {
                swap(i, triplet, getParent(i));
            }
            i = parent(i);
        }
    }

    private Triplet<V, P> getParent(int index) {
        if (index % 2 == 0) {
            return triplets.get((index / 2));
        } else {
            return triplets.get((index / 2) - 1);
        }
    }

    boolean hasParent(int index) {
        return isValid(parent(index));
    }

    private void swap(int sonIndex, Triplet<V, P> son, Triplet<V, P> parent) {
        int parentIndex = parent(sonIndex);
        this.triplets.set(parentIndex, son);
        this.triplets.set(sonIndex, parent);
    }

    static int parent(int index) {
        if (index % 2 == 0) { //Left son
            return (index / 2);
        } else { //Right son
            return (index / 2) - 1;
        }
    }

    @Override
    public V remove(){
        if (size() == 0){
            throw new NoSuchElementException("Empty HeapQueue");
        }
        V returnTriplet = triplets.get(1).value;
        triplets.set(1, triplets.get(size()-1));
        triplets.remove(size()-1);
        removeCheck(1);
        return returnTriplet;
    }

    private void removeCheck(int index){
        if (this.hasLeft(index)){
            Triplet<V,P> triplet = triplets.get(index);
            Triplet<V,P> biggestTriplet = triplets.get(left(index));
            //Compare between both children
            if (this.hasRight(index)){
                Triplet<V,P> right = triplets.get(right(index));
                if (right.compareTo(biggestTriplet) > 0){
                    biggestTriplet = right;
                }
            }
            //Compare with parent
            if (triplet.compareTo(biggestTriplet) < 0){
                int indexOfBiggestTriplet = triplets.indexOf(biggestTriplet);
                swap(index, indexOfBiggestTriplet);
                removeCheck(indexOfBiggestTriplet);
            }
        }
    }

    private void swap(int index, int otherIndex){
        Triplet<V,P> temp = triplets.get(index);
        triplets.set(index, triplets.get(otherIndex));
        triplets.set(otherIndex, temp);
    }

    boolean hasRight(int index) {
        return isValid(right(index));
    }

    boolean hasLeft(int index) {
        return isValid(left(index));
    }

    boolean isValid(int index) {
        return 1 <= index && index <= size();
    }

    static int left(int index) {
        return 2 * index;
    }

    static int right(int index) {
        return 2 * index + 1;
    }

    @Override
    public V element() {
        if (size() == 0) {
            throw new NoSuchElementException("Empty HeapQueue");
        }
        Triplet<V, P> triplet = triplets.get(1);
        return triplet.value;
    }

    @Override
    public int size() {
        return triplets.size() - 1; //The subtraction is because the position with index 0 is not used. => That position is established with value and priority null.
    }

}
