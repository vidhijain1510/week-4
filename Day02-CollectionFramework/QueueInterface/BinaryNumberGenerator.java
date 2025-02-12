/*Generate Binary Numbers Using a Queue
Generate the first N binary numbers (as strings) using a queue.
Example:
N=5 → Output: ["1", "10", "11", "100", "101"].
*/

package com.capgeminitraining.week4.day2.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;

public class BinaryNumberGenerator {
    public static List<String> generateBinaryNumbers(int n) {
        //Initializing the queue
        Queue<String> queue = new LinkedList<>();
        List<String> result = new ArrayList<>();

        //Starting with "1"
        queue.add("1");

        for (int i = 0; i < n; i++) {
            //Performing Dequeue to the front element
            String binaryNum = queue.poll();
            result.add(binaryNum);

            //Performing Enqueue to the next binary numbers by adding "0" and "1" to the current binary number
            queue.add(binaryNum + "0");
            queue.add(binaryNum + "1");
        }
        return result;
    }

    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println(binaryNumbers);
    }
}

