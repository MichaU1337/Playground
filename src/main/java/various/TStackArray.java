package various;

public class TStackArray<E> {

    int size;
    int[] arr;
    int topElement;

    // constructor having size as parameter
    TStackArray(int size) {
        this.size = size;
        this.arr = new int[size];
        this.topElement = -1;
    }

    // insert an element on a stack
    public void push(int element) {
        if (!isStackFull()) {
            topElement++;
            arr[topElement] = element;
            System.out.println("Element Pushed on Stack is :" + element);
        } else {
            System.out.println("Cannot insert Stack is full...");
        }
    }

    // delete an element from a stack
    public int pop() {
        if (!isEmpty()) {
            int returnedtopElement = topElement;
            topElement--;
            System.out.println("Element Popped from Stack is :" + arr[returnedtopElement]);
            return arr[returnedtopElement];
        } else {
            System.out.println("Stack is empty...");
            return -1;
        }
    }

    // return topmost element from a stack
    public int peek() {
        if (!this.isEmpty())
            return arr[topElement];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    // check if stack is empty
    public boolean isEmpty() {
        return (topElement == -1);
    }

    public boolean isStackFull() {
        return (size - 1 == topElement);
    }

    public static void main(String[] args) {
        TStackArray impl = new TStackArray(10);
        impl.pop();
        System.out.println("--------------");
        impl.push(210);
        impl.push(310);
        impl.push(50);
        impl.push(400);
        impl.push(410);
        impl.push(610);
        impl.push(70);
        impl.push(4);
        impl.push(1);
        impl.push(20);
        impl.push(21);
        System.out.println("------------------");
        impl.pop();
        impl.pop();
        impl.pop();
        System.out.println("------------------------");
    }
}

