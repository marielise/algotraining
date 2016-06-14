package com.main;

/**
 * Created by mlhamel on 2/3/16.
 */
public class StackLink<T> {

    private Node first;
    private int n;

    //push, pop, peek, isEmpty

    class Node {
        Node next;
        T value;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void push(T value) {

        Node oldNode = first;
        first = new Node();
        first.value = value;
        first.next = oldNode;
        n++;
    }

    public T pop() {
        if (isEmpty()) return null;

        T val = first.value;
        first = first.next;
        n--;
        return val;
    }

    public T peek(){

        if(isEmpty()) return null;

        return first.value;
    }

    public int size(){
        return n;
    }

    public static void main(String[] args) {

    }
}
