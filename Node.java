public class Node{
  public Node(String value){
    data = value;
  }
  private String data;
  private Node next, prev;

  public String get(){
    return data;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrev(){
    return prev;
  }

  public String set(String element){
    String temp = data;
    data = element;
    return temp;
  }

  public Node setNext(Node element){
    Node temp = next;
    next = element;
    return temp;
  }

  public Node setPrev(Node element){
    Node temp = prev;
    prev = element;
    return temp;
  }
}
