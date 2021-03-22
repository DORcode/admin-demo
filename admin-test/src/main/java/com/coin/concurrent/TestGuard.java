package com.coin.concurrent;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName TestGuard
 * @Description: 保护性暂停模式，join的源码也是如此
 * @Author kh
 * @Date 2021/2/27 17:13
 * @Version V1.0
 **/
@Slf4j(topic = "testguard")
public class TestGuard {
    public static void main(String[] args) {

        GuardObject object = new GuardObject();

        new Thread(() -> {
            log.info("获取结果");
            String o = (String) object.get(2000);
            log.info("结果是", o);
        }, "t1").start();

        new Thread(() -> {
            log.info("设置结果");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            object.set("收到了吗？");
        }, "t2").start();
    }
}

class GuardObject {
    Object result;

    public Object get(long timeout) {
        synchronized (this) {
            long begin = System.currentTimeMillis();
            long pass = 0;
            while (result == null) {
                long wait = timeout - pass;
                if (wait <= 0) {
                    break;
                }
                try {
                    this.wait(wait);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                pass = System.currentTimeMillis() - begin;
            }
            return result;
        }
    }

    public void set(Object o) {
        synchronized (this) {
            this.result = o;
            this.notify();
        }
    }
}
