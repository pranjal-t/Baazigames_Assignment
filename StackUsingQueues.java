package baazigames;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    Queue<Integer> queue1 = new LinkedList();
    Queue<Integer> queue2 = new LinkedList();

    int val = -1;  //Return -1 if no value exists

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {

        while (!queue1.isEmpty()) {
            val = queue1.poll();
            if (!queue1.isEmpty())
                queue2.add(val);
        }

        return getValue();
    }

    public int peek() {

        while (!queue1.isEmpty()) {
            val = queue1.poll();
            queue2.add(val);
        }

        return getValue();
    }

    private int getValue() {
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }
        return val;
    }


    public static void main(String[] args) {

        StackUsingQueues stack = new StackUsingQueues();
        stack.push(3);
        stack.push(4);
        stack.push(1);
        stack.push(12);

        int peekValue = stack.peek();
        int poppedValue1 = stack.pop();
        int poppedValue2 = stack.pop();
        int poppedValue3 = stack.pop();
        int peekValue2 = stack.peek();

        System.out.println(peekValue);
        System.out.println(poppedValue1);
        System.out.println(poppedValue2);
        System.out.println(poppedValue3);
        System.out.println(peekValue2);
    }
}
