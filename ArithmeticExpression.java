/*	Luis Luna
 * Description: Created a program that would compute the arithmetic expression 
 * that in POSTfix or Infix Notation
 * 
 * Example: 
 * 		POSTFix Expression: 3 4 + (all of its operators follow its operands)
 * 		INfix Expression:	3 + 4 (Operators are in between operands)
 * 
 * 
 */
   import java.util.*;
   public class ArithmeticExpression
   {
      public static boolean isIntegerToken(String s)
      {
      		
         boolean result =false;
      	
         if(s.charAt(0)=='-'|| s.charAt(0)=='+')
         {
            for(int j = 1; j < s.length();j++)
            {
               char c = s.charAt(j);
            				
               if(c >= '0'&&c<= '9')
                  result = true;
               else 
               {
                  result = false;
                  break;
               }
            }
         }
         
         else 
         {
            for(int j = 0; j < s.length();j++)
            {
               char c = s.charAt(j);
               if(c >= '0' &&c<= '9')
                  result = true;
               else 
               {
                  result = false;
                  break;
               }
            }
         }
       return result;						
      }//End isIntegerToken
  //--------------------------------------------------
   
      public static boolean isOperatorToken(String s)
      {
         boolean result = false;
      		
         if(s.length() > 1)
            result = false;
         else
         {
            if(s.charAt(0)=='-'||s.charAt(0)=='+'||s.charAt(0)=='/'||s.charAt(0)=='%'||s.charAt(0)=='*')
               result = true;
         }
         return result;
      }//END isOperatorToken
   //--------------------------------------------------
      public static int postFixEvaluation(String postfixExpr) throws SyntaxErrorException
      {
         IntegerStack s = new IntegerStack(postfixExpr.length());
         StringTokenizer  t = new StringTokenizer(postfixExpr);
         int result = 0;
         String a = " ";
      		
         while(t.hasMoreTokens())
         {
            a = t.nextToken();
            if(isIntegerToken(a))
            {
               if(a.charAt(0)=='+')
               {	
                  String b = Character.toString(a.charAt(1));
                  s.push(Integer.parseInt(b));
               }
               else
                  s.push(Integer.parseInt(a));
            }	
            else if(isOperatorToken(a))
            {
               int first = 0;
               int second =0;
               if(s.isEmpty())
                  throw new SyntaxErrorException("String is empty");
               else
               {
                  first =s.pop();
                  if(s.isEmpty())
                  {
                     throw new SyntaxErrorException("Expression is invalid");
                  }
                  else {
                     second = s.pop();
                     if(a.compareTo("+")==0)
                        s.push(first + second);
                     else if(a.compareTo("-")==0)
                        s.push(second - first);
                     else if(a.compareTo("*")==0)
                        s.push(first * second);
                     else if(a.compareTo("/")==0)
                        s.push(second / first);
                     else if(a.compareTo("%")==0)
                        s.push(second % first);
                  }
               }
            }
            else 
               throw new SyntaxErrorException("Not an operand or integer");
         }
      		
      	result = s.pop();
      	//check if stack is Empty
         if(!s.isEmpty())
            throw new SyntaxErrorException("Expression is not valid! Try again");
      		
         return result;
      }//END postFixEvaluation
   //--------------------------------------------------	
      public static String infixToPostFix(String infixExpr) throws SyntaxErrorException
      {
         StringStack stack = new StringStack(infixExpr.length());
         String PE = "";
         String a = "" ;
         StringTokenizer  t = new StringTokenizer(infixExpr);
      
         while(t.hasMoreTokens())
         {
            a = t.nextToken();
            if(isIntegerToken(a))
            {
               PE +=a+" ";
            }
            else if(a.compareTo("(")==0)
               stack.push(a);
            else if(a.compareTo(")")==0)
            {
            	String b = stack.peek();
               while(b.compareTo("(")!=0)
               {
                  PE += stack.pop()+ " ";
                  b = stack.peek();
               }
               stack.pop();
            }
            else if(isOperatorToken(a))
            {
            	 while(!stack.isEmpty()&&precedence(a) <= precedence(stack.peek()))
               {
                  PE += stack.pop()+ " ";
               }
            						
               stack.push(a);
            }
            else 
               throw new SyntaxErrorException("Not an operator: "+ a + " Try again!");
         }
         if(stack.isEmpty())
         {	
            throw new SyntaxErrorException("Not in the right format!: " + PE);
			}
         while(!stack.isEmpty())
         {
            PE+= stack.pop()+ " ";
         }
         return PE;
      
      }
   // //--------------------------------------------------
      public static int precedence(String a)
      {
         int i = 0;
         if(a.compareTo("(")==0)
            i=0;
         else if(a.compareTo("+")==0||a.compareTo("-")==0)
            i = 1;
         else if(a.compareTo("*")==0||a.compareTo("/")==0||a.compareTo("%")==0)
            i = 2;
         return i;
      }
   // //--------------------------------------------------
      public static void main(String[] args)
      {
      	//Create Scanner 
         Scanner input = new Scanner(System.in);
      	
      	//Create String where to input the inputed string
         String string = "";
         String s= "";
      	//Create a String to verify if the following input 
      	//will be infix or postfix
         String inPost = "";
      	System.out.println("Infix or PostFix Notation? Type in one");
         inPost = input.nextLine();
      	
      
         if(inPost.compareToIgnoreCase("PostFix")==0)
         {
				System.out.println("\nInput the POSTfix expression");
            System.out.println("Type QUIT once done");
				System.out.println();
         	
            while(string.compareToIgnoreCase("Quit")!=0)
            {
               s+= string + " ";
               System.out.println("Enter: ");
               string = input.nextLine();
            }
            try
            {
               System.out.println("\nPostFix Expression: " + s);
               System.out.println("PostFix Expression Value: " + postFixEvaluation(s)); 	
            }
               catch ( SyntaxErrorException g)
               {
                  System.out.println(g);
               }
         }
         
         else if(inPost.compareToIgnoreCase("Infix")==0)
         {
            System.out.println("\nInput the (infix) expression");
            System.out.println("Type QUIT once done inputting expression");
				System.out.println();
         	
            while(string.compareToIgnoreCase("Quit")!=0)
            {
               s+= string + " ";
               System.out.println("Enter: " );
               string = input.nextLine();
            }
         	
            System.out.println("\nInFix Expression " + s);
            try
            {
               System.out.println("PostFix Expression: " + infixToPostFix(s));
            }
               catch ( SyntaxErrorException g)
               {
                  System.out.println(g);
               }
         	
            try
            {
               System.out.println("Postfix Expression Value: " + postFixEvaluation(infixToPostFix(s)));
            }
               catch ( SyntaxErrorException g)
               {
                  System.out.println(g);
               }
         }
         else
            System.out.println("Sorry, could not recognize input. Try again!");
      
      }//END main
   
   }//END ArithmeticExpression

	