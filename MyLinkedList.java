import java.util.*;
public class MyLinkedList{

  private int size;
  private Node start, end;

  public MyLinkedList(){
    size = 0;
  }

  public int size(){
    return size;
  }

  public boolean add(String value){
    Node nu = new Node(value);
    if(size == 0){
      start = nu;
    }
    else{
      end.setNext(nu);
      nu.setPrev(end);
    }
    end = nu;
    size += 1;
    return true;
  }

  public void add(int index, String value){
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException("Invalid value");
    }
    Node place = start;
    Node newNode = new Node(value);
    if(index == 0){
      start.setPrev(newNode);
      newNode.setNext(start);
      start = newNode;
      size++;
      return;
    }
    for(int i = 0; i < index-1; i++){
      place = place.getNext();
    }
    newNode.setPrev(place);
    newNode.setNext(place.getNext());
    place.setNext(newNode);
    place.getNext().setPrev(newNode);
    if(index == size){
      end = newNode;
    }
    size++;
  }

  public String get(int index){
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException("Invalid value");
    }
    Node place = start;
    for(int i = 0; i < index; i++){
      place = place.getNext();
    }
    return place.get();
  }

  public String set(int index, String value){
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException("Invalid value");
    }
    Node place = start;
    for(int i = 0; i < index; i++){
      place = place.getNext();
    }
    String temp = place.get();
    place.set(value);
    return temp;
  }

  public String toString(){
    Node place = start;
    String ret = "";
    for(int i = 0; i < size; i++){
      ret = ret + place.get() + ", ";
      place = place.getNext();
    }
    if(size == 0){
      return "{}";
    }
    return  "{" + ret.substring(0, ret.length()-2) + "}";
  }

  public String remove(int index){
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException("Invalid value");
    }
    if(size == 1){
      String outta = start.get();
      start = null;
      end = null;
      size--;
      return outta;
    }
    if(index == 0){
      String outta = start.get();
      start = start.getNext();
      start.setPrev(null);
      size--;
      return outta;
    }
    if(index == size-1){
      String outta = end.get();
      end = end.getPrev();
      end.setNext(null);
      size--;
      return outta;
    }
    Node place = start;
    for(int i = 0; i < index; i++){
      place = place.getNext();
    }
    String temp = place.get();
    place.getPrev().setNext(place.getNext());
    place.getNext().setPrev(place.getPrev());
    size--;
    return temp;
  }

  public void extend(MyLinkedList other){
    this.end.setNext(other.start);
    other.start.setPrev(this.end);
    this.end = other.end;
    size = this.size + other.size;
    other.start = null;
    other.end = null;
    other.size = 0;
  }
}
