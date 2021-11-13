// QueueStack Implementation using java

package queuestack;

import stack.Stack;

public class QueueStack {

    private Stack enqueue_stack = null;
    private Stack dequeue_stack = null;

    int capacity = 5;

    public QueueStack() {
        this.enqueue_stack = new Stack(capacity);
        this.dequeue_stack = new Stack(capacity);
    }

    public QueueStack(int capacity) {
        this.capacity = capacity;
        this.enqueue_stack = new Stack(capacity);
        this.dequeue_stack = new Stack(capacity);
    }

    public void enqueue(int data) {
        if (enqueue_stack.isFull()) {
            System.out.println("Queue is full can't insert");
            return;
        }
        enqueue_stack.push(data);
        System.out.println(data + " enqueued into Queue");
    }

    public void dequeue() {
        if (enqueue_stack.isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        while (!enqueue_stack.isEmpty()) {
            dequeue_stack.push(enqueue_stack.peek());
            enqueue_stack.pop();
        }
        int data = dequeue_stack.peek();
        dequeue_stack.pop();

        while (!dequeue_stack.isEmpty()) {
            enqueue_stack.push(dequeue_stack.peek());
            dequeue_stack.pop();
        }
        System.out.println(data + " dequeued from Queue");
    }

    public int rear() {
        if (enqueue_stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return enqueue_stack.peek();
    }

    public int front() {
        if (enqueue_stack.isEmpty()) {
            return Integer.MIN_VALUE;
        }
        while (!enqueue_stack.isEmpty()) {
            dequeue_stack.push(enqueue_stack.peek());
            enqueue_stack.pop();
        }
        int data = dequeue_stack.peek();

        while (!dequeue_stack.isEmpty()) {
            enqueue_stack.push(dequeue_stack.peek());
            dequeue_stack.pop();
        }
        return data;
    }

    public boolean isFull() {
        return enqueue_stack.isFull();
    }

    public boolean isEmpty() {
        return enqueue_stack.isEmpty();
    }

    public int size() {
        return enqueue_stack.size();
    }

    public static void main(String[] args) {
        QueueStack qs = new QueueStack();
        System.out.println("Is Queue full " + qs.isFull());
        System.out.println("Is Queue empty " + qs.isEmpty());
        qs.enqueue(10);
        qs.enqueue(20);
        qs.enqueue(30);
        qs.enqueue(40);
        qs.enqueue(50);
        System.out.println("Rear Item is " + qs.rear());
        System.out.println("Front Item is " + qs.front());
        qs.dequeue();
        System.out.println("Size of Queue is " + qs.size());

    }

}
