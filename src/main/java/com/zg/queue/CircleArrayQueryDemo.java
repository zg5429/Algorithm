package com.zg.queue;

import java.lang.annotation.Retention;
import java.util.Scanner;

/**
 * @author zhuguang
 * @Project_name Algorithm
 * @Package_name com.zg.queue
 * @date 2021-01-14-15:46
 */
public class CircleArrayQueryDemo {
    public static void main(String[] args) {
        //设置为4 其队列有效数据为3
        CirlArray cirlArray = new CirlArray(4);
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
            switch (key) {
                case 's':
                    cirlArray.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    int value = scanner.nextInt();
                    cirlArray.addQueue(value);
                    break;
                case 'g':
                    try {
                        int res = cirlArray.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':

                    try {
                        int res = cirlArray.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");


    }
}

class CirlArray {
    private int maxsize;
    private int front; //指向队列头部第一个元素  front的初始值0
    private int rear;//指向队列的最后一个元素的后一个位置 初始值为0
    private int[] arr;

    public CirlArray(int maxsize) {
        this.maxsize = maxsize;
        arr = new int[maxsize];
    }

    //    判断队列书否满
    public boolean isFull() {
        return (rear + 1) % maxsize == front;
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
//        直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxsize;
    }


    //    获取队列的数据,出队列
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1. 先把front对应的值保留到一个临时变量
        int value = arr[front];
        //2. 将fronthouyi
        front = (front + 1) % maxsize;
        //3. 将临时保存的变量返回
        return value;
    }


    //    显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空的无数据");
            return;
        }

        //从front开始遍历 遍历多少个元素
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxsize, arr[i % maxsize]);

        }


    }


    //求出当前队列的有效数据的个数
    public int size() {
        return (rear + maxsize - front) % maxsize;
    }


    //显示队列的头数据  注意不是取出数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取数据");
        }
        return arr[front];
    }


}
