
public class SinglyLinkedList<E> implements Cloneable {
    public static void main(String[] args)
    {
   
        SinglyLinkedList<Integer> testList = new SinglyLinkedList<Integer>();
        testList.addFirst(2);
        testList.addLast(2);
        testList.addLast(4);
        testList.addLast(6);
        testList.addLast(8);
        testList.addLast(8);
        testList.addLast(8);
        testList.addLast(10);
        testList.addLast(12);
        testList.addLast(14);
        testList.addLast(8);
        testList.addLast(16);
        testList.addLast(8);
        testList.addLast(4);
        testList.addLast(4);


        int size = testList.size();
        System.out.println(testList);

        // Node n =testList.head;
        // for (int i = 0; i < size-1 ; i++) {
        //     System.out.println(n.getElement());
        //     n=n.getNext();
        // }
        //testList.removeMid(2);
        testList.find_tekrrari(testList);
        System.out.println(testList);


       
    }
     
    private static class Node<E> {
       private E element;  
       private Node<E> next ;         
       public Node(E e, Node<E> n) 
       {
         element = e;
         next = n;
       }
       public E getElement() { return element; }
       public Node<E> getNext() { return next; }
       public void setNext(Node<E> n) { next = n; }
     } 


     private Node<E> head = null;           
     private Node<E> tail = null;        

     private int size = 0;                     
     public SinglyLinkedList()
    {

    }            
     public int size() 
    { 
        return size; 
    }
     public boolean isEmpty() 
     { 
        return size == 0; 
    }
     
     public E first() 
     {           
       if (isEmpty()) return null;
       return head.getElement();
     }
   
     public E last() 
     {              
       if (isEmpty()) return null;
       return tail.getElement();
     }
   
     public void addFirst(E e) 
     {                
       head = new Node<>(e, head);          
       if (size == 0)
         tail = head;                          
       size++; 
     }
   
    
     public void addLast(E e) 
     {                 
       Node<E> newest = new Node<>(e, null);    
       if (isEmpty())
         head = newest;                         
       else
         tail.setNext(newest);                  
       tail = newest;                           
       size++;
     }
   
    
     public E removeFirst()
      {                   
       if (isEmpty()) return null;              
       E answer = head.getElement();
       head = head.getNext();                   
       size--;
       if (size == 0)
         tail = null;                           
       return answer;
     }
     public void removeLast()
      {    
        Node head_re=head;    
        for(int q=0;q<size-2;q++){
          head_re=head_re.getNext();

        }          
        head_re.setNext(null); 
        tail=head_re;
      
     }

     public void removeMid(int index)
      {        
        Node head_ma=head;  
        Node head_baadi=head;   
        Node head_vasat=head;

    //    if (isEmpty()) return null;              
    //    E answer = head.getElement();
       for(int j=0;j<index-1;j++)
       {
           head_ma = head_ma.getNext();
           //System.out.println(head_ma.getElement());
       }
       //System.out.println();
        for(int j=0;j<index;j++)
       {
           head_vasat = head_vasat.getNext();
           //System.out.println(head_vasat.getElement());
       }
       //System.out.println();
       for(int j=0;j<index+1;j++)
       {
           head_baadi = head_baadi.getNext();
           //System.out.println(head_baadi.getElement());
       }
       head_ma.setNext(head_baadi);
       head_vasat.setNext(null);
       
       size--;
                          
       
       if (size == 0)
         tail = null;                           
    //    return null;
     }
     public void find_tekrrari(SinglyLinkedList s1)
     {
        
        Node n =head.getNext();
        Node n_head =head;
        for (int j=0;j<size-1;j++)
        {
        
        //n=n_head;
        for (int i = 0; i < size-j-1 ; i++) 
        {
            System.out.print("n_head:");
            System.out.println(n_head.getElement());
            System.out.print("n:");
            System.out.println(n.getElement());
            if (n.getElement()==n_head.getElement())
            {
              if(j==0){
                System.out.println(s1);
                //n=n_head.getNext();
                n_head=n_head.getNext();
                //System.out.println(n_head.getElement());
                s1.removeFirst();
                System.out.println(s1);
                
                //break;

              }
              // else if(j==size-2){
              //    System.out.println(s1);
              //   //n=n_head.getNext();
              //   n_head=n_head.getNext();
              //   //System.out.println(n_head.getElement());
              //   s1.removeLast();
              //   System.out.println(s1);
                
              //   //break;
              // }
              else{
                System.out.println(s1);
                //n=n_head.getNext();
                n_head=n_head.getNext();
                //System.out.println(n_head.getElement());
                s1.removeMid(j);
                System.out.println(s1);
                
                //break;

              }
                
                
            }
            //System.out.println(s1);
            n=n.getNext();
        }
        if(j!=size-1){
          n=n_head.getNext().getNext();
        n_head=n_head.getNext();

        }
        
        
    }   
    s1.removeLast();
    
     }
   
    
   
   
     public String toString() {
       StringBuilder sb = new StringBuilder("(");
       Node<E> walk = head;
       while (walk != null) {
         sb.append(walk.getElement());
         if (walk != tail)
           sb.append(", ");
         walk = walk.getNext();
       }
       sb.append(")");
       return sb.toString();
     }
   }
   