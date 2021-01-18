package com.zg.linkedlist;

/**
 * @author zhuguang
 * @Project_name Algorithm
 * @Package_name com.zg.linkedlist
 * @date 2021-01-18-19:28
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        singleLinkedList singleLinkedList = new singleLinkedList();
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.add(hero4);

        //按照编号的顺序添加
        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.list();
        singleLinkedList.update(new HeroNode(3, "小吴", "石麒麟"));
        singleLinkedList.list();

        singleLinkedList.delete(3);
        singleLinkedList.list();


    }
}


class singleLinkedList {
    //    初始化头结点 头结点不要动
    private HeroNode head = new HeroNode(0, "", "");

    //   添加节点到单向链表
//    1 找到链表的最后节点
//    2  将最后这个节点的next指向新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动 需要一个辅助遍历temp
        HeroNode temp = head;
        //遍历链表 找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
//            如果没有找到最后 将temp后移
            temp = temp.next;
        }
//        当退出while循环是 temp就指向链表的最后
        temp.next = heroNode;

    }

    //    第二种添加  查到指定位置
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;//标识添加的编号是否存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.println("编号no已存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }


    //显示链表 遍历
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //temp后移
            temp = temp.next;
        }
    }


    //修改节点信息
    public void update(HeroNode newHeroNode) {
        if (head == null) {
            System.out.println("空链表");
            return;
        }
        //找到需要修改的节点
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                //找到
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        } else {
            System.out.println("没有找到");
        }
    }


    //删除节点

    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("无节点");
        }


    }


}


class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;

    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
