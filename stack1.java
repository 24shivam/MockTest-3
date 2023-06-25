public class Stack {
    private int maxSize;        // maximum size of the stack
    private int top;            // top of the stack
    private int[] stackArray;   // array to store elements

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;  // stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (top == maxSize - 1) {
            System.out.println("Stack overflow! Cannot push element: " + value);
        } else {
            stackArray[++top] = value;
            System.out.println("Pushed element: " + value);
        }
    }

    // Method to pop an element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack underflow! Cannot pop element.");
            return -1;  // or throw an exception
        } else {
            int poppedElement = stackArray[top--];
            System.out.println("Popped element: " + poppedElement);
            return poppedElement;
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to get the top element without removing it from the stack
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty! Cannot peek.");
            return -1;  // or throw an exception
        } else {
            return stackArray[top];
        }
    }

    // Method to get the size of the stack
    public int size() {
        return top + 1;
    }

    // Method to display the elements of the stack
    public void display() {
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stackArray[i] + " ");
        }
        System.out.println();
    }

    // Test the Stack implementation
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.display();  // should print: 3 2 1
        stack.pop();
        stack.display();  // should print: 2 1
        System.out.println("Top element: " + stack.peek());  // should print: 2
        System.out.println("Stack size: " + stack.size());    // should print: 2
        System.out.println("Is stack empty? " + stack.isEmpty());  // should print: false
        stack.pop();
        stack.pop();
        stack.pop();  // trying to pop from an empty stack
        stack.display();  // should print: Stack is empty!
        System.out.println("Top element: " + stack.peek());  // should print: Stack is empty!
        System.out.println("Stack size: " + stack.size());    // should print: 0
        System.out.println("Is stack empty? " + stack.isEmpty());  // should print: true
    }
}
