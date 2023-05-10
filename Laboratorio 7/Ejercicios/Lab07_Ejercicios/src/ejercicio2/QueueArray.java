/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author ADMIN
 */
public class QueueArray<E> implements Queue<E> {
    
    private E[] arr;
    private int maxsize;
    private int size;
    private int front;
    private int rear;

     public QueueArray(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        this.front = 0;
        this.rear = -1;
        this.arr = (E[]) new Object[maxsize];
    }
    
    @Override
    public void enqueue(E x) throws ExceptionIsEmpty{
         if (size == maxsize) {
            throw new ExceptionIsEmpty("Queue is full..");
        }
        rear = (rear + 1) % maxsize;
        arr[rear] = x;
        size++;
        
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty..");
        }
        E result = arr[front];
        front = (front + 1) % maxsize;
        size--;
        return result;
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty..");
        }
        return arr[front];
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Queue is empty..");
        }
        return arr[rear];
        
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);

    }

    @Override
    public String toString() {
         String str = "";
        int count = 0;
        int index = front;
        while (count < size) {
            str += arr[index].toString() + ",";
            index = (index + 1) % maxsize;
            count++;
        }
        return str;
    }
    
    
}
