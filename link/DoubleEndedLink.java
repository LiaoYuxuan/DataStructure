package link;

public class DoubleEndedLink {

    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        DeList<String> mList = new DeList<String>();
        mList.add("a");
        mList.add("b");
        mList.add("c");
        mList.addBefore("nihao");
        mList.addAfter("wobuhao");
//        mList.add("d");
//        mList.add("e");
//        mList.add("f");
        mList.remove("a");
//        mList.replace(0, "ee");
        System.out.println(mList.get(0));
        System.out.println(mList.get(1));
        System.out.println(mList.get(2));
        System.out.println(mList.get(3));
        System.out.println(mList.size());
    }

}

class DeList<T>{
    private int foot;
    private int count;
    private Node root;
    private Node last;

    //链结点的类
    private class Node{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        //添加结点
        private void add(T data) {
            //递归方法
            if(this.next == null) {
                this.next = new Node(data);
                DeList.this.last = this.next;
            }else {
                this.next.add(data);
            }
        }
        //删除结点类型1
        //存在bug，可能链表中只有一个结点
        private void remove(Node previous , int index) {
            if(index == 0 && DeList.this.count ==1){
                DeList.this.root = null;
                DeList.this.last = null;
                DeList.this.count--;
                return ;
            }
            if( DeList.this.foot++ == index) {
                previous.next = this.next;
                this.next = null;
                //如果删除的结点是最后一个结点的话尾结点改变，否则不变
                if(DeList.this.count == index+1){
                    DeList.this.last = previous;
                }
                DeList.this.count--;
                return ;
            }else {
                //向下一个结点递归
                this.next.remove(this, index);
            }
        }
        //删除结点类型2
        private void remove(Node previous , T data) {
            if(this.data.equals(data)) {
                if(DeList.this.count ==1){
                    DeList.this.root = DeList.this.root.next;
                    DeList.this.last = DeList.this.last.next;
                    DeList.this.count--;
                }else {
                    if (this.next == null) {
                        DeList.this.last = previous;
                    }
                    previous.next = this.next;
                    this.next = null;

                    DeList.this.count--;
                    return;
                }
            }
            //当前结点的下一节点是否为空，若不为空，则向下寻找
            if(this.next != null) {
                this.next.remove(this, data);
            }else {
                return;
            }
        }
        //修改数据
        private void replace(T oldData,T newData) {
            if(this.data.equals(oldData)) {
                this.data = newData;
            }else {
                this.next.replace(oldData, newData);
            }
        }
        //索引修改数据
        private void replace(int index,T newData) {
            if(DeList.this.foot++==index) {
                this.data =  newData;
            }else {
                this.next.replace(index, newData);
            }
        }
        //查询
        private T get(int index) {
            if(DeList.this.foot++==index) {
                return this.data ;
            }else {
                return this.next.get(index);
            }
        }
        //是否包含
        private boolean contains(T data) {
            if(this.data.equals(data)) {
                return true;
            }
            if(this.next != null) {
                return this.next.contains(data);
            }else {
                return false;
            }
        }
    }

    public DeList() {

    }

    //在头节点之前添加一个结点
    //将root 结点的指向改为新添加的结点,将新添加的结点的next指向改为原来的root结点
    public void addBefore(T data){
        Node temp = new Node(data);
        temp.next = root;
        root = temp;
        count ++;
    }
    //在尾节点之后添加一个结点
    //将last 结点的指向改为新添加的结点,将原来的last结点的next指向改为该节点
    public void addAfter(T data){
        Node temp = new Node(data);
        last.next = temp;
        last = temp;
        count ++;
    }

    //取出最后一个结点的值
    public T getlast(){
        return  last.data;
    }


    //检查链表是否为空
    public boolean isEmpty() {
        if(this.count == 0 || this.root == null) {
            return true;
        }
        return false;
    }

    //获取链表长度
    public int size() {
        return this.count;
    }

    //添加
    public void add(T data) {
        //判断当前列表是否为空,若空，则作为根节点
        if(this.isEmpty()) {
            this.root = new Node(data);
        }else {
            this.root.add(data);
        }
        this.count++;
    }
    //删除1
    public void remove(int index) {
        if(this.isEmpty()) {
            return ;
        }
        if(index<0 ||this.count<=index) {
            return ;
        }
        //删除根节点
        if(index == 0) {
            Node temp = this.root;
            this.root = this.root.next;
            //移除结点只需要移除引用关系
            temp.next=null;
            this.count--;
            return ;
        }else {
            this.foot=0;
            this.root.remove(this.root, index);
        }
    }
    //删除2
    public void remove(T data) {
        if(this.isEmpty()) {
            return ;
        }
        if(this.root.data.equals(data)) {
            Node temp = this.root;
            this.root = this.root.next;
            //移除结点只需要移除引用关系
            temp.next=null;
            this.count--;
            return ;
        }else {
            this.root.next.remove(this.root, data);
        }
    }
    //修改1
    public void replace(int index,T data) {
        if(this.isEmpty()) {
            return ;
        }
        if(index<0 ||this.count<=index) {
            return ;
        }
        this.foot = 0;
        this.root.replace(index, data);
    }
    //修改2
    public void replace(T oldData,T newData) {
        if(this.isEmpty()) {
            return ;
        }
        //不用到index时无需初始化foot
        this.root.replace(oldData, newData);
    }
    //查询
    public T get(int index) {
        if(this.isEmpty()) {
            return null;
        }
        this.foot = 0;
        return this.root.get(index);
    }
    //是否包含
    public boolean contains(T data) {
        if(this.isEmpty()) {
            return false;
        }
        return this.root.contains(data);
    }
    //toarry  测试使用
    public Object[] toArry() {
        if(this.isEmpty()) {
            return null;
        }
        int count = this.count;
        Object[] retVal = new Object[count];
        for(int i = 0; i < retVal.length; i++) {
            retVal[i]=this.get(i);
        }
        return retVal;
    }

}