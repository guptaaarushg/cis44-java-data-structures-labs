import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements Iterable<E> {

    private static class Node<E> implements Position<E> {
        E element;
        Node<E> prev;
        Node<E> next;

        Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() {
            if (next == null) throw new IllegalStateException();
            return element;
        }
    }

    private Node<E> header = new Node<>(null, null, null);
    private Node<E> trailer = new Node<>(null, header, null);
    private int size = 0;

    public LinkedPositionalList() {
        header.next = trailer;
    }

    private Node<E> validate(Position<E> p) {
        if (!(p instanceof Node)) throw new IllegalArgumentException();
        Node<E> node = (Node<E>) p;
        if (node.next == null) throw new IllegalArgumentException();
        return node;
    }

    private Position<E> position(Node<E> node) {
        if (node == header || node == trailer) return null;
        return node;
    }

    private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
        Node<E> newest = new Node<>(e, pred, succ);
        pred.next = newest;
        succ.prev = newest;
        size++;
        return newest;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public Position<E> first() { return position(header.next); }
    public Position<E> last() { return position(trailer.prev); }
    public Position<E> before(Position<E> p) { return position(validate(p).prev); }
    public Position<E> after(Position<E> p) { return position(validate(p).next); }

    public Position<E> addFirst(E e) { return addBetween(e, header, header.next); }
    public Position<E> addLast(E e) { return addBetween(e, trailer.prev, trailer); }
    public Position<E> addBefore(Position<E> p, E e) { return addBetween(e, validate(p).prev, validate(p)); }
    public Position<E> addAfter(Position<E> p, E e) { return addBetween(e, validate(p), validate(p).next); }

    public E set(Position<E> p, E e) {
        Node<E> node = validate(p);
        E old = node.element;
        node.element = e;
        return old;
    }

    public E remove(Position<E> p) {
        Node<E> node = validate(p);
        Node<E> pred = node.prev;
        Node<E> succ = node.next;
        pred.next = succ;
        succ.prev = pred;
        size--;
        E old = node.element;
        node.element = null;
        node.prev = node.next = null;
        return old;
    }

    private class PositionalListIterator implements Iterator<E> {
        private Node<E> cursor = header.next;

        public boolean hasNext() { return cursor != trailer; }

        public E next() {
            if (!hasNext()) throw new NoSuchElementException();
            E elem = cursor.getElement();
            cursor = cursor.next;
            return elem;
        }
    }

    public Iterator<E> iterator() { return new PositionalListIterator(); }
}
