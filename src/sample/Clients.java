package sample;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

public class Clients implements Runnable {

private ArrayList<PrintWriter> clientStreams;
static String message;

    public static String encrypt(String text,int s)
    {
        StringBuffer result= new StringBuffer();

        for (int i=0; i<text.length(); i++)
        {
           if(Character.isAlphabetic(text.charAt(i))){
               if (Character.isUpperCase(text.charAt(i)))
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)text.charAt(i) +
                        s - 97) % 26 + 97);
                result.append(ch);
            }
        }
           else
           {
               result.append(text.charAt(i));
           }
        }
        return result.toString();
    }

    public Clients()
{
    this.clientStreams=new ArrayList<PrintWriter>();
}
public void add(PrintWriter printWriter)
{
    clientStreams.add(printWriter);

}
    @Override
    public void run() {
        System.out.println("in run of clinets ");
    if (clientStreams.isEmpty())
    {
        System.out.println("no clients");
        return;}
Iterator iterator=clientStreams.iterator();
    String msg=encrypt(message,2);
while(iterator.hasNext())
{
    try{PrintWriter writer=(PrintWriter) iterator.next();
        writer.println(msg);
        writer.flush();

    }catch (Exception ex)
    {
        ex.printStackTrace();
    }
}
    }
}
