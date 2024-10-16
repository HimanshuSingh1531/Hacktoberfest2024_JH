// StackNode class representing each node in the stack
class StackNode<T> {
    T data;
    StackNode<T> next;

    public StackNode(T data) {
        this.data = data;
        this.next = null;
    }
}

// Stack class implementing the stack functionality
public class Stack<T> {
    private StackNode<T> top; // Top of the stack
    private int size;         // Size of the stack

    public Stack() {
        top = null;
        size = 0;
    }

    // Method to add an element to the stack
    public void push(T data) {
        StackNode<T> newNode = new StackNode<>(data);
        newNode.next = top; // Link the new node to the previous top
        top = newNode;      // Update the top to the new node
        size++;
        System.out.println(data + " pushed to the stack.");
    }

    // Method to remove and return the top element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot pop.");
        }
        T data = top.data;
        top = top.next; // Update top to the next node
        size--;
        System.out.println(data + " popped from the stack.");
        return data;
    }

    // Method to return the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty. Cannot peek.");
        }
        return top.data; // Return the top element
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the stack
    public int size() {
        return size;
    }

    // Method to display the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        StackNode<T> current = top;
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Display the stack
        stack.display();

        // Peek at the top element
        System.out.println("Top element is: " + stack.peek());

        // Pop elements from the stack
        stack.pop();
        stack.pop();

        // Display the stack
        stack.display();

        // Check stack size
        System.out.println("Stack size: " + stack.size());
    }
}
