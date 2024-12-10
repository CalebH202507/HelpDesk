import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Queue;

public class Main 
{	
     public static void main(String[] args) 
     {
	Queue<E> q = null;
	try{
		q = parseToQueue("customers.dat");
	}catch(IOException e)
	{
		System.out.println("Error finding or reading file.");
		System.exit(-1);
	}

	int totalWaitTime = 0;
	int nextAvailTimeA= 0;
	int nextAvailTimeB= 0;
		
	//dequeue each customer and calculate his wait-time.
	while (!(q.isEmpty()))
	{
	     //Get next customer's data from the queue
        
	     //Choose the representative with the closest nextAvailTime
	     int waitTime = 0;
             //decide which rep to use
	     if(nextAvailTimeA <= nextAvailTimeB) 
	     {
		//calculate wait time for this customer
		//calculate the nextAvailTimeB
                //keep in mind that in some cases, the customer may arrive AFTER the nextAvailTime

	     }
	     else // if nextAvailTimeB < nextAvailTimeA
             {
		//calculate wait time for this customer
		//calculate the nextAvailTimeA
                //keep in mind that in some cases, the customer may arrive AFTER the nextAvailTime
             }

             totalWaitTime += waitTime;
         }
         System.out.println(totalWaitTime);
     }
 
     public static Queue parseToQueue(String fileName) throws NumberFormatException, IOException 
     {
        Queue queue = new LinkedListQueue<CustomerRecord>(); //change to your Queue
        File file = new File(fileName); 
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        String line; 
        String[] splitRecord;
        while ((line = br.readLine()) != null) 
        {
           splitRecord = line.split(" ");
           queue.enqueue(new CustomerRecord(Integer.parseInt(splitRecord[0]), Integer.parseInt(splitRecord[1])));
        } 
        br.close();
        return queue;
      }
}