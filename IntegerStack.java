/**
 * @author luis
 * Description: Stack class for Integers
 */
public class IntegerStack {
    private int[] data;
    private int top;

    public IntegerStack(int n)
    {
       data = new int[n];

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

    public void push(int item) throws StackFullException
    {
        if(!isFull())
        {
            top++;
            data[top] = item;

        }
        else
            throw new StackFullException("Stack is full "+ top);
    }

    public int pop() throws StackEmptyException
    {
        int x=0;

        if(!isEmpty())
        {
            x = data[top];
            top--;

        }

        else
             throw new StackEmptyException("Stack is empty"+top);

        return x;
    }

    public int peek() throws StackEmptyException
    {
     int x = 0;

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
            System.out.println(data[i]+"\t");
    }

}