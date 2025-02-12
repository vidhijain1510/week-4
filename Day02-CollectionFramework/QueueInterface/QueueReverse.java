/*Reverse a Queue
Reverse the elements of a queue using only queue operations (e.g., add, remove, isEmpty).
Example:
Input: [10, 20, 30] → Output: [30, 20, 10].*/

package com.capgeminitraining.week4.day2.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverse {
    public static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        //Performing Dequeue to all elements and pushing them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

        //Performing Pop to elements from the stack and Performing enqueue them back
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);

        System.out.println("Original Queue: " + queue);
        reverseQueue(queue);
        System.out.println("Reversed Queue: " + queue);
    }
}

