/**
 * @author luis
 */
public class StringStack {
    private String[] data;
    private int top;

    public StringStack(int n)
    {
       data = new String[n];

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

    public void push(String item) throws StackFullException
    {
        if(!isFull())
        {
            top++;
            data[top] = item;

        }
        else
            throw new StackFullException("Stack is full"+ top);
    }

    public String pop() throws StackEmptyException
    {
        String x = "";

        if(!isEmpty())
        {
            x = data[top];
            top--;

        }

        else
             throw new StackEmptyException("Stack is empty"+top);

        return x;
    }

    public String peek() throws StackEmptyException
    {
     String x = "" ;

        if(!isEmpty())
            x= data[top];
        else
            System.out.println("Data is empty");
     return x;



    }

    public void printStack(String s)
    {
        System.out.println("Top = "+ top + "\n[");
        for(int i =0;i<=top;i++)
            System.out.println(data[i]+"\t");
    }

}