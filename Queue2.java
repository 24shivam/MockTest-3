public class Queue {
    private Node front;  // front of the queue
    private Node rear;   // rear of the queue

    // Node class representing each element in the queue
    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Constructor to initialize the queue
    public Queue() {
        front = null;
        rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (front == null);
    }

    // Method to enqueue (add) an element to the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        System.out.println("Enqueued element: " + value);
    }

    // Method to dequeue (remove) an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;  // or throw an exception
        } else {
            int dequeuedElement = front.data;
            front = front.next;

            // If the front becomes null after dequeue, set rear to null as well
            if (front == null) {
                rear = null;
            }

            System.out.println("Dequeued element: " + dequeuedElement);
            return dequeuedElement;
        }
    }

    // Method to display the elements of the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue (front to rear): ");
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Test the Queue implementation
    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.display();  // should print: 1 2 3
        queue.dequeue();
        queue.display();  // should print: 2 3
        System.out.println("Is queue empty? " + queue.isEmpty());  // should print: false
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();  // trying to dequeue from an empty queue
        queue.display();  // should print: Queue is empty!
        System.out.println("Is queue empty? " + queue.isEmpty());  // should print: true
    }
}
