class MyCircularQueue {
    private final int[] queue;
    private int head;
    private int tail;
    private int size;
    private final int capacity;

    public MyCircularQueue(int k) {
        this.capacity = k;
        this.queue = new int[k];
        this.head = -1; // Indicates empty
        this.tail = -1; // Indicates empty
        this.size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        tail = (tail + 1) % capacity;
        queue[tail] = value;
        if (isEmpty()) { // First element added
            head = tail;
        }
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) { // Last element removed
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % capacity;
        }
        size--;
        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[head];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
