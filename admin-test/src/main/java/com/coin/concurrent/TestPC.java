package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.Random;

/**
 * @ClassName TestPC
 * @Description: TODO
 * @Author kh
 * @Date 2021/3/6 21:00
 * @Version V1.0
 **/

@Slf4j(topic = "TestPC")
public class TestPC {

    public static void main(String[] args) {
        MessageQueue messageQueue = new MessageQueue(10);
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            new Thread(() -> {

                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final Message message = new Message(random.nextInt(100), Thread.currentThread().getName());
                    messageQueue.set(message);
                }

            }, "produce" + i).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {

                while (true) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info(messageQueue.take().toString());
                }

            }, "comsume" + i).start();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

@Slf4j(topic = "MessageQueue")
class MessageQueue {
    private LinkedList<Message> list = new LinkedList<>();
    private long capcity;

    public MessageQueue(long capcity) {
        this.capcity = capcity;
    }

    public Message take() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    log.info("队列中无数据，");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Message first = list.removeFirst();
            list.notifyAll();
            return first;
        }
    }

    public void set(Message msg) {
        synchronized (list) {
            while (list.size() == capcity) {
                try {
                    log.info("队列已满");
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            list.addLast(msg);
            list.notifyAll();
        }
    }
}

class Message {
    int id;
    String msg;

    public Message(int id, String msg) {
        this.id = id;
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                '}';
    }
}
