import java.util.LinkedList;
// LIFO Queue which can store Element type E (where Element is any Object type)
public class LinkedListQueue<E> implements Queue<E>
{
    // private LinkedList<E> - can store Element type E (where Element is any Object type)
    private LinkedList<E> list;

    public LinkedListQueue( ) //constructor
    { 
        list = new LinkedList<E>( ); 
    }
    
    public boolean isEmpty(){
        return list.size() == 0;
    }
    public void enqueue(E obj){
        list.add(obj);
    }
    public E dequeue(){
        if(isEmpty()){
            throw new IllegalStateException("The Queue is Empty"); 
        }
        else{
        E temp = list.get(0);
        list.removeFirst();
        return temp;
        }
    }
    public E peekFront(){
        return list.get(0);

    }
    
    public int size(){
        return list.size();
    }
    public void clear(){
        list.clear();
        
    }

}