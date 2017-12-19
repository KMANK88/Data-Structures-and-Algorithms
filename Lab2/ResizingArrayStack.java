/******************************************************************************
 *  Compilation:  javac ResizingArrayStack.java
 *  Execution:    java ResizingArrayStack < input.txt
 *  Dependencies: StdIn.java StdOut.java
 *  Data files:   http://algs4.cs.princeton.edu/13stacks/tobe.txt
 *  
 *  Stack implementation with a resizing array.
 *
 *  % java ResizingArrayStack < tobe.txt
 *  to be not that or be (2 left on stack)
 *
 ******************************************************************************/

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a; // array of items
    private int n; // number of elements on stack

    /**
     * Initializes an empty stack.
     */
    public ResizingArrayStack() {
        a = (Item[]) new Object[2]; // why is this Object type necessary?
        // It is necessary because we can later call an Item and not be stuck
        // with in or string.
        // any other initialization?
        n = 0; // makes an array empty. Zero elements
    }

    /**
     * Is this stack empty?
     */
    public boolean isEmpty() {
        if (n == 0) {
            return true;
        } else
            return false;
        // how to test?
    }

    /**
     * Returns the number of items in the stack.
     */
    public int size() {
        return n;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {

        // textbook implementation
        Item[] temp = (Item[]) new Object[capacity];
        // that's your new Item array of size "capacity"
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
        // how to copy the contents of _a_ into temp,
        // then make temp the active array?
    }

    /**
     * Adds the item to this stack.
     */
    public void push(Item item) {
        // How to stick the item at the end of the list?
        // Watch out for the special case of running out of space ( double size
        // of array if necessary)
        if (n == a.length) {
            resize(a.length * 2);
        }
        a[n++] = item;

    }

    /**
     * Removes and returns the item most recently added to this stack.
     */
    public Item pop() {
        // How to avoid loitering?
        // when to shrink allocated array?
        // How do you get the item from the end of the list,
        if (isEmpty()) {
            throw new NoSuchElementException("The Stack is empty.");
        }

        Item thing = a[n - 1];
        a[--n] = null;
        if (n == a.length / 2) {
            resize(a.length / 2);
        }
        return thing;
    }

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO
     * order.
     */
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n - 1; // doing this because we're looking starting at the top
                       // of the stack
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public boolean hasNext() {
            // how to check?
            if (i > 0) {
                return true;

            } else
                return false;
        }

        public Item next() {
            // how to walk along the list, starting from "top" of stack ?
            // watch out for next() call when there is no next item

            if (!hasNext()) {
                throw new NoSuchElementException("Nothing is next.");
            }
            return a[--i];
        }
    }

    /**
     * Unit tests the {@code Stack} data type.
     */
    public static void main(String[] args) {
        ResizingArrayStack<String> stack = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-"))
                stack.push(item);
            else if (!stack.isEmpty())
                StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
