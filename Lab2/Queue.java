// Queue implementation using array

package queue;

public class Queue {

    int capacity = 5;
    int arr[] = null;
    int front = 0;
    int rear = -1;

    public Queue() {
        this.arr = new int[capacity];
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.arr = new int[capacity];
    }

    public void enqueue(int data) {
        if (isFull()) {
            System.err.println("Queue is full can't insert");
            return;
        }
        arr[++rear] = data;
        System.out.println(data + " equeued into Queue");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return;
        }
        int data = arr[front];
        for (int i = front; i < rear; i++) {
            arr[i] = arr[i + 1];
        }
        rear--;
        System.out.println(data + " dequeued from Queue");
    }

    public int rear() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return arr[rear];
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty");
            return Integer.MIN_VALUE;
        }
        return arr[front];
    }

    public boolean isFull() {
        return size() == capacity;
    }

    public boolean isEmpty() {
        return size() == front;
    }

    public int size() {
        return rear + 1;
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        System.out.println("After inserting data's");
        System.out.println("Rear Item is :" + q.rear());
        System.out.println("Front Item is :" + q.front());
        q.dequeue();
        q.enqueue(60);
        System.out.println("After inserting 60 into Queue");
        System.out.println("Rear Item is :" + q.rear());
        System.out.println("Front Item is :" + q.front());
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
        q.dequeue();
    }

}