package com.main;

import java.util.Arrays;

/**
 * Created by mlhamel on 2/3/16.
 */
public class StackArray<T> {

    private T[] arr;
    private int N;

    //push, pop, peek, isEmpty

    public StackArray(){
        arr = (T[]) new Object[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void push(T value) {
        if (N == arr.length)
            resize(arr.length << 1);

        arr[N++] = value;

    }

    private void resize(int size){
        arr = Arrays.copyOf(arr, size);
    }

    public T pop() {
        if (isEmpty()) return null;
        T val = arr[--N];
        arr[N] = null;

        //shrink by 2
        if(N > 0 && N == arr.length / 4)
            resize(arr.length / 2);

        return val;
    }

    public T peek(){

        if(isEmpty()) return null;

        return arr[N-1];
    }

    public int size(){
        return N;
    }

    public static void main(String[] args) {

    }
}
