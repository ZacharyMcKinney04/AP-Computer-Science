public class LinkedLizt<E> implements Lizt<E> {

    private Node<E> head;
    private int size;

    public LinkedLizt() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean add(E obj) {
        if (this.size == 0) {
            this.head = new Node<E>(obj, null);
        } else {
            Node<E> currNode = this.head;
            while (currNode.getNext() != null) {
                currNode = currNode.getNext();
            }
            currNode.setNext(new Node<E>(obj, null));
        }
        this.size++;
        return true;
    }

    @Override
    public void add(int index, E obj) {
        isValidIndex(index);
        int currIndex = 0;
        Node<E> currNode = this.head;
        Node<E> nextNode = null;
        while (currIndex != (index - 1)) {
            currNode = currNode.getNext();
            currIndex++;
        }
        nextNode = currNode.getNext();
        Node<E> addNode = new Node<E>(obj, nextNode);
        currNode.setNext(addNode);
        this.size++;
    }
    
    @Override
    public E get(int index) {
        isValidIndex(index);
        int currIndex = 0;
        Node<E> currNode = this.head;
        while (currIndex != index) {
            currNode = currNode.getNext();
            currIndex++;
        }
        return currNode.getData();
    }
    
    @Override
    public E set(int index, E obj) {
        isValidIndex(index);
        int currIndex = 0;
        Node<E> currNode = this.head;
        while (currIndex < index) {
            currNode = currNode.getNext();
            currIndex++;
        }
        Node<E> temp = new Node<E>(currNode.getData(), currNode.getNext());
        currNode.setData(obj);
        return temp.getData();
    }
    
    @Override
    public E remove(int index) {
        isValidIndex(index);
        int currIndex = 0;
        Node<E> currNode = this.head;
        Node<E> nextNode = null;
        Node<E> nextNode2 = null;
        while (currIndex < (index - 1)) {
            currNode = currNode.getNext();
            currIndex++;
        }
        nextNode = currNode.getNext();
        if (nextNode == null) {
            nextNode2 = null;
        } else {
            nextNode2 = nextNode.getNext();
        }
        currNode.setNext(nextNode2);
        this.size--;
        if (nextNode != null) {
            nextNode.setNext(null);
            return nextNode.getData();
        } else {
            return null;
        }
    }

    private void isValidIndex(int index) {
        if (!(index >= 0 && index < this.size)) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

}
