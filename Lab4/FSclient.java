
public class FSclient {
/*
 * **************** DEQUEU.Java test 
    public static void main(String[] args) {
        Deque<String> Deque = new Deque<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) Deque.addFirst(item);
            else if (!Deque.isEmpty()) StdOut.print(Deque.removeLast() + " ");
        }
        StdOut.println("(" + Deque.size() + " left on queue)");
    }
*/
    //FixedSizedStack.java test
    public static void main(String[] args) {
         int a = Integer.parseInt(args[0]);
        FixedSizedStack<String> stack = new FixedSizedStack<String>(a);
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop(item) + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }

}
