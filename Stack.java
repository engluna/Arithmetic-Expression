/**
 * @author Luis Luna aka EngineerLuna
 * Description: Recreating the Stack Class for practice
 * and to understand it better
 */
public class Stack {
    private char[] data;
    private int top;

    public Stack(int n)
    {
       data = new char[n];

       top = -1;//Empty Array

    }

    public boolean isEmpty()
    {
        return(top==-1);
    }

    public boolean isFull()
    {
       if(top==data.length-1)
            return true;
       else
            return false;

    }

    public void push(char item) throws StackFullException
    {
        if(!isFull())
        {
            top++;
            data[top] = item;

        }
        else
            throw new StackFullException("Stack is full"+ top);
    }

    public char pop() throws StackEmptyException
    {
        char x = ' ';

        if(!isEmpty())
        {
            x = data[top];
            top--;

        }

        else
             throw new StackEmptyException("Stack is empty"+top);

        return x;
    }

    public char peek() throws StackEmptyException
    {
     char x = ' ' ;

        if(!isEmpty())
            x= data[top];
        else
            System.out.println("Data is empty");
     return x;



    }
    
    public void printStack(String s)
    {
        System.out.println(s+"\nTop = "+ top + "\n[");
        for(int i =0;i<=top;i++)
            System.out.println(data[i]+" x");
    }

}