
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Prem
 */
public class StackOfString {

    public static void main(String ar[]){
       InputStream is = null; 
       InputStreamReader isr = null;
       BufferedReader br = null;
       StackOfString s = new StackOfString();
        
       try{
           is = new FileInputStream("D:/prem.txt");
           isr = new InputStreamReader(is);
           br = new BufferedReader(isr);
           String line;
           while((line=br.readLine())!=null){
              // System.out.println(line);
               if(line.equals("-")){
                   System.out.println(s.pop());
               }
               else{
                   s.push(line);
               }
           }
           br.close();
           
       }catch(Exception e){
           System.out.println("Error while reading file line by line:" + e.getMessage());
       }
    }
    
    private Node first = null;
    private class Node
    {
        String item;
        Node next;
    }
    public boolean isEmpty()
    { return first == null; }

    public void push(String item)
    {
    Node oldfirst = first;
    first = new Node();
    first.item = item;
    first.next = oldfirst;
    }

    public String pop()
    {
    String item = first.item;
    first = first.next;
    return item;
    }
}
