package baazigames;

class MyThread {
    boolean flag = false;
    int val;

    synchronized int consume() {
        if (!flag)
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        System.out.println("consume" + val);
        sleepMethod(500);
        flag = false;
        notify();

        return val;
    }

    synchronized int produce(int val) {
        if (flag)
            try {
                wait();
            } catch (Exception e) {
                System.out.println(e);
            }
        this.val = val;
        flag = true;
        System.out.println("produce" + val);
        sleepMethod(500);
        notify();

        return val;
    }
    private void sleepMethod(int millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Producer implements Runnable {
    MyThread producer;

    Producer(MyThread producer) {
        this.producer = producer;
        new Thread(this, "Producer").start();
    }

    public void run() {
        int x = 0, y = 0;
        while (x < 5) {
            producer.produce(y++);
            x++;
        }
    }
}

class Consumer implements Runnable {
    MyThread consumer;

    Consumer(MyThread consumer) {
        this.consumer = consumer;
        new Thread(this, "Consumer").start();
    }

    public void run() {
        int x = 0;
        while (x < 5) {
            consumer.consume();
            x++;
        }
    }
}

class ProducerConsumer {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        Producer p = new Producer(thread);
        Consumer c = new Consumer(thread);
    }
}