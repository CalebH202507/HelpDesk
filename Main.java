import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main 
{  

   @SuppressWarnings("unchecked")
   public static void main(String[] args) 
     {
   Queue<CustomerRecord> q = null;
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
   //while there are still customers in the queue
   while (q.size()!=0){
        CustomerRecord p1 = q.dequeue();
   
        //Choose the representative with the closest nextAvailTime
        int waitTime = 0;
        int arrivalTime = p1.getArrivalTime();
        int helpTime = p1.getHelpTime();
        if(nextAvailTimeA <= nextAvailTimeB) 
        {
            if (arrivalTime > nextAvailTimeA){
               nextAvailTimeA = arrivalTime;
            }
            waitTime = nextAvailTimeA - arrivalTime;
            nextAvailTimeA+=helpTime;
        } 
        else {
            if (arrivalTime > nextAvailTimeB)
            {
               nextAvailTimeB = arrivalTime;
            }
            waitTime = nextAvailTimeB - arrivalTime;
            nextAvailTimeB += helpTime;
         }
         totalWaitTime += Math.max(0,waitTime);
     }
     System.out.println(totalWaitTime);
   }
 
     @SuppressWarnings({ "unchecked", "rawtypes" })
   public static Queue parseToQueue(String fileName) throws NumberFormatException, IOException 
     {
        Queue queue = new LinkedListQueue<CustomerRecord>(); 
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