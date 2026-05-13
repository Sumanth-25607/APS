class MyCircularDeque {
    private final int[] deque;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[k];
        front = 0;
        rear = -1; // Initialize rear to -1 to handle the first insertion easily
        size = 0;
    }

    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + capacity) % capacity; // Circular movement backward
        deque[front] = value;
        size++;
        if (size == 1) { // Special case for the first element
            rear = front;
        }
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % capacity; // Circular movement forward
        deque[rear] = value;
        size++;
        if (size == 1) { // Special case for the first element
            front = rear;
        }
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity; // Circular movement forward
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + capacity) % capacity; // Circular movement backward
        size--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deque[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deque[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
