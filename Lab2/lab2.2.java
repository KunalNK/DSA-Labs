// Circular Queue Implementation

package circularqueue;

public class CircularQueue {

    int arr[] = null;
    int capacity = 3;

    int front = 0;
    int rear = -1;

    int size = 0;

    public CircularQueue() {
        this.arr = new int[capacity];
    }

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.out.println("Queue is full can't insert");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
        System.out.println(data + " enqueued into queue");
        System.out.println("After enqueued Rear is " + rear);
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int data = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println(data + " dequeued from queue");
        System.out.println("After dequeued front is " + front);
    }

    public int front() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public int rear() {
        if (isEmpty()) {
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }

    public int size() {
        return size;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue();
        System.out.println("Is Queue full : " + q.isFull());
        System.out.println("Is Queue empty : " + q.isEmpty());
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.dequeue();
        q.enqueue(40);
        System.out.println("Size of Queue is " + q.size());
        System.out.println("Front item is " + q.front());
        System.out.println("Rear item is " + q.rear());

    }

}
