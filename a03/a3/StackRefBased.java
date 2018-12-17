/*
 * MazeSolver.java
 *
 * UVic CSC 115, Spring 2017
 *
 * Name: Jorge Fernando Flores Pinto
 * ID: V00880059
 *
 * This class StackRefBased makes a generic Stack (reference-based), and can add more elements to
 * the stack or remove them.
 */

public class StackRefBased<T> implements Stack<T> {
    int count;
    StackNode<T> top;

    public StackRefBased() {

    }
    //Returns the size of the stack
    public int size() {
        return count;

    }
    //Checks if the stack is empty
    public boolean isEmpty() {
        return top == null;

    }
    //Adds elements to the top of the stack
    public void push(T data) {
        StackNode<T> s = new StackNode<T>(data);
        if (top == null) {
           top = s;
           count++;
        }
        else {
            s.next = top;
            top = s;
            count++;
        }       
    }
    //Removes (and returns) elements that are at the top of the stack
    public T pop() throws StackEmptyException {
        StackNode<T> temp = top;
        if (top != null) {
            top = top.next;
            count--;
            return temp.data;
        }
        else {
            throw new StackEmptyException();
        }
    }
    //Returns the top element of the stack
    public T peek() throws StackEmptyException {
        if (top == null) {
           throw new StackEmptyException();
        }
        else {
           return top.data;
        }
    }
    //Empties the stack
    public void makeEmpty() {
        top = null;
        count = 0;

    }
    //Turns the stack into a string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(StackNode<T> s = top; s != null; s = s.next) {
            if (s.next == null) {
                sb.append(s);
            }
            else {
                sb.append(s + " ");
            }
        }
        return sb.toString();
    }
}

