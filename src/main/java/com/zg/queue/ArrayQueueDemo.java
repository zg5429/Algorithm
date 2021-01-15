package com.zg.queue;

import java.util.Scanner;

/**
 * @author zhuguang
 * @Project_name Algorithm
 * @Package_name com.zg.queue
 * @date 2021-01-14-14:42
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit),退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("h(head),查看队列头的数据");
            System.out.println("g(get)：从队列取出数据");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res  = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':

                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");


    }
}


//使用数组模拟队列
class ArrayQueue {
    private int maxsize;
    private int front; //指向队列头部 分析出front是指向队列头的前一个位置
    private int rear; //指向队列的最后一个元素
    private int[] arr;


    public ArrayQueue(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
        front = -1;
        rear = -1;
    }

    //    判断队列书否满
    public boolean isFull() {
        return rear == maxsize - 1;
    }

    //    判断队列书否为空
    public boolean isEmpty() {
        return front == rear;
    }

    //    添加数据到队列
    public void addQueue(int n) {
//        判断队列书否满
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
//arr[++rear]=n
        rear++;
        arr[rear] = n;
    }

    //    获取队列的数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //    显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的无数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i,arr[i]);
        }
    }

    //显示队列的头数据  注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        return arr[front + 1];
    }


}