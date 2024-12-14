
public interface Queue<E>
{
    //"front" and "back" should be chosen so that each is the most efficient location to perform
    //that operation for that data structure.
    boolean isEmpty( ); //returns true if nothing in the queue
    void enqueue(E obj ); //places object obj at the back of the queue
    E dequeue( ); //removes and returns object at front of the list
    E peekFront( ); //returns object at the front of the list
    int size(); //returns the number of elements in the queue
    void clear(); //clears all elements from the Queue.  Results in an empty queue.
}