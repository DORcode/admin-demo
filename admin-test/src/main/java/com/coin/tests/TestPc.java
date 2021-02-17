package com.coin.tests;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

/**
 * @ClassName TestPc
 * @Description: TODO
 * @Author kh
 * @Date 2021/2/16 21:05
 * @Version V1.0
 **/
@Slf4j(topic = "testpc")
public class TestPc {

    public static void main(String[] args) {
        log.info("aaa");

        Queue queue = new Queue();
        new Thread(new Producer(queue), "producer").start();
        new Thread(new Cosumer(queue), "cosumer").start();

        new Thread(new Cosumer(queue), "cosumer2").start();
    }
}

class Cosumer implements Runnable {

    Queue queue;

    public Cosumer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            if (queue.linkedList.size() > 0 || queue.isEnd == false) {
                System.out.println(Thread.currentThread().getName() + "queue.pop(); = " + queue.pop());
            }
        }

    }
}

class Producer implements Runnable {

    Queue queue;

    public Producer(Queue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            this.queue.push(i);
        }
    }
}

class Queue {
    LinkedList<String> linkedList = new LinkedList<>();

    boolean isEnd = false;

    public synchronized void push(int i) {

        if (i == 999) {
            isEnd = true;
        }

        System.out.println(Thread.currentThread().getName()  + i);
        this.linkedList.push(i + "");
        if (linkedList.size() > 0) {
            notifyAll();
        }



        if (linkedList.size() == 100) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized String pop() {

        if (linkedList.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        notifyAll();
        return linkedList.pollLast();
    }
}
