import java.util.Iterator;
import java.util.*;

public class MyLinkedListImproved <T extends Comparable<T>> implements Iterable{
    
    private Node first,last;
    private int length;
    
    public MyLinkedListImproved(){
	
    }

    //helper method
    private Node getNode(int index){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = first;
	if (index == length - 1){
	    return last;
	}
	else if (index == 0){
	    return first;
	}
	for (int i = 0;i < index;i++){
	    current = current.getNext();
	}
	return current;
    }

    //add to the end
    public boolean add(T value){
	Node n = new Node(value);
	if (length == 0){
	    first = n;
	    last = n;
	}
	last.setNext(n);
	n.setPrev(last);
	last = n;
	length ++;
	return true;
    }

     //find the size
    public int size(){
	return length;
    }

     //visuals 
    public String toString(){
	Node current = first;
	String str = "[";
	for (int i = 0;i < length;i++){
	    str += current.getValue();
	    if (i < length - 1){
		str += ",";
	    }
	    current = current.getNext();
	}
	str += "]";
	return str;
    }

    //return Node value;
    public T get(int index){
	return getNode(index).getValue();
    }

    //set at specific index
    public T set(int index,T newValue){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
        Node current = getNode(index);
	T old = current.getValue();
	current.setValue(newValue);
	return old;
    }

    //find the index, return -1 if not found
    public int indexOf(T value){
	int i = -1;
	Node current = first;
	for (int c = 0;c < length;c++){
	    if (current.getValue().equals(value)){
		i = c;
		return i;
	    }
	    current = current.getNext();
	}
	return i;
    }

    public void add(int index, T value){
	if (index > length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	if (index == length){
	    add(value);
	    return;
	}
	else if (index == 0){
	    Node now = new Node(value);
	    first.setPrev(now);
	    now.setNext(first);
	    first = now;
	    length++;
	    return;
	}
	Node old = getNode(index);
	Node now = new Node(value);
	now.setPrev(old.getPrev());
	now.setNext(old);
	old.getPrev().setNext(now);
	old.setPrev(now);
	length++;
    }

    //remove first occurance
    public boolean remove(T value){
	Node current = first;
	for (int i = 0;i < length;i++){
	    if (current.getValue().equals(value)){
		return remove(i);
	    }
	    current = current.getNext();
	}
	return false;
    }

    //remove at specific index
    public boolean remove(int index){
	if (index >= length || index < 0){
	    throw new IndexOutOfBoundsException();
	}
	Node current = getNode(index);
	if (index == length - 1){
	    last = current.getPrev();
	    last.setNext(null);
	    length--;
	    return true;
	}
	else if (index == 0){
	    first = current.getNext();
	    first.setPrev(null);
	    length--;
	    return true;
	}
	else{
	    Node before = current.getPrev();
	    Node after = current.getNext();
	    before.setNext(after);
	    after.setPrev(before);
	    length--;
	    return true;
	}
    }

    //Node class
    private class Node<T>{
	private Node next,prev;
	private T data;
	
	public Node(T d){
	    data = d;
	    next = null;
	    prev = null;
	}
	
	private Node getNext(){
	    return next;
	}
	
	private Node getPrev(){
	    return prev;
	}
	
	private T getValue(){
	    return data;
	}

	private void setValue(T value){
	    data = value;
	}
	
	private void setNext(Node next){
	    this.next = next;
	}
	
	private void setPrev(Node prev){
	    this.prev = prev;
	}
	
	public String toString(){
	    String str = "";
	    str += this.getValue();
	    return str;
	}
    }

    //make iterator
    //public Iterator<T> iterator(){
    //	return new 
    //}
}
