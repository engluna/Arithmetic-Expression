/*
 * Test Case to test the String Stack Class   
 */
import java.util.*;

   public class TestCase
   {
      public static void main(String[] args)
      {
    	  	//Create a new stack of 4 strings
			StringStack  stringList = new StringStack(4);
 			String s = " ";	
 			
 			//Push a few String into Stack
 			stringList.push("Luis");
 			stringList.push("Luna");
 			stringList.push("Francisco");
 			
 			//Pop the top of the stack
 			String b = stringList.pop();
 			
 			if(b.compareTo("Francisco")==0)
 			{
 				s+= " " +b;
 				while(!stringList.isEmpty())
 				{
 					b = stringList.pop();
 					s +=" " + b;
 					
				}
 				//Print what the stack returned
 				System.out.println(s);
				
 				}
 			else {
 				//if this prints, the StringStack is not working
 				System.out.println("Didn't work");
 				
 			}
     }
	  
   }