package link;

public class DoubleLinkedList {
    public static void main(String[] args) {
        DLList<Integer> mList = new DLList<>();
        mList.add(1);
        mList.add(2);
        mList.add(3);
        mList.add(5);
        mList.addAfter(5,4);
        mList.addBefore(1,6);
        //mList.remove(5);
        mList.printList();
    }
}

class DLList<T>{

    private Node<T> head;
    private Node<T> last;
    private Node<T> temp;
    private int count;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    public void DoubleLinkedList() {
        head = new Node<T>(null);
        last = head;
        count = 0;
    }

    public void DoubleLinkedList(T data) {
        head = new Node<T>(data);
        last = head;
        count = 0;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    //添加
    public void add(T data) {
        if (isEmpty()) {
            head = new Node<T>(data);
            last = head;
            count++;
        } else {
            //插入到尾部
            temp = new Node<T>(data);
            temp.prev = last;
            last.next = temp;
            last = temp;
            count++;
        }
    }

    //在指定的数据后面加入结点
    public void addAfter(T data, T insertData) {
        if (count != 0) {
            temp = head;//假定head不为空
            while (temp != null) {
                if (temp.data.equals(data)) {
                    Node<T> t = new Node<T>(insertData);
                    t.prev = temp;
                    t.next = temp.next;
                    temp.next = t;

                    if (t.next == null) {
                        last = t;
                    }
                    count++;
                }
                temp = temp.next;
            }
        }
    }

    public void addBefore(T data, T insertData) {
        if (count != 0) {
            temp = head;//假定head不为空
            while (temp != null) {
                if (temp.data.equals(data)) {
                    Node<T> t = new Node<T>(insertData);
                    t.next = temp;
                    t.prev = temp.prev;
                    temp.prev = t;

                    if (t.prev == null) {
                        head = t;
                    }
                    count++;
                }
                temp = temp.next;
            }
        }
    }

    //删除
    public void remove(T data) {
        temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) {
                if(temp == head){
                    head = temp.next;
                    head.prev = null;
                    count--;
                }else if (temp == last){
                    last = temp.prev;
                    last.next = null;
                    count--;
                }else{
                    temp.prev.next = temp.next;
                    count--;
                }
            }
            temp = temp.next;
        }
    }

    public void printList() {
        temp = head;
        for (int i = 0; i < count; i++) {
            System.out.println(temp.data + "");
            temp = temp.next;
        }
    }
}




