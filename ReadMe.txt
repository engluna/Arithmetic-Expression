Author: Luis Luna
 Description: Created a program that would compute the arithmetic expression in
either POSTfix or Infix notation.

Infix Notation is the common arithmetic and logical formula notation, in which
the operators are in between the operands. It is not as simple to parse by
computers as the PostFix or PreFix notations but is still widely used due to 
its familiarity.
	Example: 3 + 4

PostFix Notation is a mathematical notation in which the operators follow the
operands. It is also known as the Reverse Polish Notation (RPN).
	Example: 3 4 + 



------------------------Results-------------------------------------------------
luis@ubpc:~/Desktop$ java ArithmeticExpression 
Infix or PostFix? Type in one
postfix

Input the POSTfix expression
Type QUIT once done

Enter: 
3
Enter: 
4
Enter: 
5
Enter: 
*
Enter: 
+
Enter: 
quit

PostFix Expression:  3 4 5 * + 
PostFix Expression Value: 23

 

luis@ubpc:~/Desktop$ java ArithmeticExpression 
Infix or PostFix? Type in one
infix

Input the (infix) expression
Type QUIT once done inputting expression

Enter: 
3
Enter: 
+
Enter: 
4
Enter: 
* 
Enter: 
5
Enter: 
quit

InFix Expression  3 + 4 * 5 
PostFix Expression: 3 4 5 * + 
Postfix Expression Value: 23
 

