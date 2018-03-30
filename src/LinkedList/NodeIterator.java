package LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NodeIterator<E> implements Iterator<E>{

    private MyLinkedList.Node<E> current;

    public NodeIterator(MyLinkedList.Node first){
        this.current = new MyLinkedList.Node<E>(null,null, first);
    }

    @Override
    public boolean hasNext() {
        return (current.nextElement != null);
    }

    @Override
    public E next() {
        if (hasNext()){
            current = current.nextElement;
            return current.currentElement;
        }
        else throw new NoSuchElementException();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}