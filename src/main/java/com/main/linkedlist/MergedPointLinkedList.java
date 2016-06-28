package com.main.linkedlist;

/**
 * Created by mlhamel on 5/11/16.
 */
public class MergedPointLinkedList {

    class Node {
        int data;
        Node next;
    }

    Node insertNode(Node first, int data){
        if(first == null){
            first = new Node();
            first.data = data;
            return first;
        }

        Node tmp = first;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = new Node();
        tmp.next.data = data;

        return first;
    }

    int FindMergeNode(Node headA, Node headB) {

        int cA = countList(headA);
        int cB = countList(headB);

        Node first;
        Node second;
        int diff = Math.abs(cA-cB);

        if(cA > cB) {
            first = headA;
            second = headB;
        } else {
            first = headB;
            second = headA;
        }

        while(--diff >= 0){
            first = first.next;
        }

        while (first.data != second.data){
            first = first.next;
            second = second.next;
        }
        return first.data;
    }

    int countList(Node head){
        Node cur = head;
        int count = 0;
        while (cur.next != null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        MergedPointLinkedList mg = new MergedPointLinkedList();
        Node a = mg.insertNode(null, 1);
        a = mg.insertNode(a,2);
        a = mg.insertNode(a,3);
        a = mg.insertNode(a,4);

        Node b = mg.insertNode(null, 10);
        b = mg.insertNode(b,3);
        b = mg.insertNode(b,4);

        int res = mg.FindMergeNode(a,b);
        System.out.println(res);
    }
}
