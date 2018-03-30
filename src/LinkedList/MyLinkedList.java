package LinkedList;

import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> implements Iterable<E> {

    private Node<E> firstElement;
    private Node<E> lastElement;

    private int size;

    @Override
    public Iterator<E> iterator() {
        return new NodeIterator<E>(firstElement);
    }

    public static class Node<E>{
        Node<E> previousElement;
        E currentElement;
        Node<E> nextElement;

        public Node(Node<E> previousElement, E currentElement, Node<E> nextElement) {
            this.previousElement = previousElement;
            this.currentElement = currentElement;
            this.nextElement = nextElement;
        }
    }


    public MyLinkedList(){
        clear();
    }

    public MyLinkedList(Collection<? extends E> collection){
        clear();
        addAll(0, collection);
    }

    public int size(){
        return size;
    }

    public int indexOf(E element){
        Iterator iterator = iterator();
        E item;
        int i = 0;
        while (iterator.hasNext()){
            item = (E)iterator.next();
            if (item == element)
                return i;
            i++;
        }
        return -1;
    }

    public void set(int index, E element){
        if (index >= 0 && index < size){
            Node<E> elem = firstElement;
            for (int i = 0; i < index; i++){
                elem = elem.nextElement;
            }
            elem.currentElement = element;
        }
    }

    public void add(E element){
        add(size, element);
    }


    public void add(int index, E element){
        if (index >= 0 && index <= size){
            if (index == size){
                Node<E> newNode = new Node<>(lastElement, element,null);
                if(firstElement == null){
                    firstElement = newNode;
                } else if(lastElement ==  null){
                    firstElement.nextElement = newNode;
                    newNode.previousElement = firstElement;
                    lastElement = newNode;
                } else {
                    Node<E> tempNode = lastElement;
                    newNode.previousElement = tempNode;
                    lastElement = newNode;
                    tempNode.nextElement = lastElement;
                }
            } else {
                Node<E> tempNode = firstElement;
                for(int i = 0; i < index; i++){
                    tempNode = tempNode.nextElement;
                }
                Node<E> before = tempNode.previousElement;
                Node<E> newNode = new Node<>(before, element, tempNode);
                if(before != null)
                    before.nextElement = newNode;
                tempNode.previousElement = newNode;
                if (index == 0)
                    firstElement = newNode;
            }
            size++;
        } else throw new IndexOutOfBoundsException();
    }


    public void remove(int index){
        if (index >= 0 && index < size){
            Node<E> tempNode = firstElement;
            for (int i = 0; i < index; i++)
                tempNode = tempNode.nextElement;
            Node<E> before = tempNode.previousElement;
            Node<E> after = tempNode.nextElement;
            if(before != null)
                before.nextElement = after;
            else
                firstElement = after;
            if (after != null)
                after.previousElement = before;
            else
                lastElement = before;
            size--;
        } else throw new IndexOutOfBoundsException();
    }


    public void clear(){
        size = 0;
        firstElement = null;
        lastElement = null;
    }


    public void addAll(Collection<? extends E> collection){
        addAll(size, collection);
    }

    @SuppressWarnings("unchecked")
    public void addAll(int index, Collection<? extends E> collection){
        if (index >= 0 && index <= size){
            E[] itemsCollection = (E[]) (collection.toArray(new Object[collection.size()]));
            Node<E> afterNode;
            Node<E> beforeNode;
            if (index == size){
                afterNode = null;
                beforeNode = lastElement;
            } else {
                afterNode = firstElement;
                for(int i = 0; i < index; i++){
                    afterNode = afterNode.nextElement;
                }
                beforeNode = afterNode.previousElement;
            }
            for(E item: itemsCollection){
                Node<E> newNode = new Node<E>(beforeNode, item, null);
                if(beforeNode == null)
                    firstElement = newNode;
                else
                    beforeNode.nextElement = newNode;
                beforeNode = newNode;
            }
            if (afterNode == null)
                lastElement = beforeNode;
            else {
                beforeNode.nextElement = afterNode;
                afterNode.previousElement = beforeNode;
            }
            size += collection.size();
        } else throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    public E get(int index){
        if (index >= 0 && index < size) {
            E elem = null;
            Iterator iterator = iterator();
            int i = 0;
            while (iterator.hasNext()){
                if (i == index) {
                    elem = (E) iterator.next();
                    break;
                }
                i++;
                iterator.next();
            }
            return elem;
        } else throw new IndexOutOfBoundsException();
    }
}
