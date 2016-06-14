package com.main;

/**
 * Created by mlhamel on 2/12/16.
 */
public class QueueLink<T> {

    private int size = 0;
    private Node first;
    private Node last;

    private class Node {
        T val;
        Node next;
    }

    public void enqueue(T val){
        Node oldNode = last;
        last = new Node();
        last.val = val;
        last.next = null;

        if(isEmpty()) first = last;
        else oldNode.next = last;

        size++;
    }

    public T dequeue() {
        if(isEmpty()) return null;

        T val = first.val;

        first = first.next;
        if(isEmpty()) last = null;

        size--;
        return val;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public int size() {
        return size;
    }
}
