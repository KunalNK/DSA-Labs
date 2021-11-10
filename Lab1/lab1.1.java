// Stack Implementation using array

package stack;

public class Stack {
	
	int arr[] = null;
	int capacity = 5;
	int top = -1;
	
	public Stack() {
		this.arr = new int[capacity];
	}
	
	public Stack(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	
	public void push(int data) {
		if(isFull()) {
			return;
		}
		arr[++top] = data;
	}
	
	public void pop() {
		if(isEmpty()) {
			return;
		}
		int data = arr[top--];
	}
	
	public int peek() {
		if(isEmpty()) {
			return -1;// You can add any logic here
		}
		return arr[top];
	}
	
	public boolean isFull() {
		return size() == capacity;
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public int size() {
		return top+1;
	}
	
	
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(25);
		s.push(40);

		System.out.println("Before Removing Elements");
		System.out.println("Is Stack is Full - "+ s.isFull());
		System.out.println("Is Stack is Empty - "+ s.isEmpty());
		System.out.println(s.peek()+" peek from Stack");
		System.out.println(s.peek()+" peek from Stack");
		System.out.println("After Removing Elements");
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		System.out.println("Is Stack is Full - "+ s.isFull());
		System.out.println("Is Stack is Empty - "+ s.isEmpty());
		
	}
}
