package tree;

import java.util.List;
import java.util.Stack;

public class HaffmanTree {
    public TreeNode root;

    public HaffmanTree initial(List<TreeNode> nodes) {
        HaffmanTree tree = new HaffmanTree();
        TreeNode Root = HaffmanTree.haffmanCodeTree(nodes);
        tree.root = Root;
        addIndex(tree.root, null);
        return tree;
    }

    private void addIndex(TreeNode locaNode, String index) {
        if (locaNode != null) {
            if (locaNode != root) {
                locaNode.index = index;
            }
            addIndex(locaNode.leftChild, "0");
            addIndex(locaNode.rightChild, "1");
        }
    }

    //创建一个空树
    public void haffmanTree() {
        root = null;
    }

    //霍夫曼编码
    public String Encode(String key) {
        TreeNode locaNode = root;
        String p = "";
        char[] chars = key.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String temp = "" + chars[i];
            //System.out.println(temp);
            p += path(locaNode, temp);
        }
        return p;
    }

    //霍夫曼解码(负责把返回来的值拼接起来)
    public String Decode(String key) {
        TreeNode current = root;
        String result = "";
        String temp;
        for (int i = 0; i <= key.length(); i++) {
            if (!isArrive(current)) {
                temp = key.substring(i, i + 1);
                if (temp.equals("0")) {
                    current = current.leftChild;
                } else if(temp.equals("1")) {
                    current = current.rightChild;
                }else {
                    //如果是空格就跳过，继续循环
                }
            }else {
                result += current.data;
                current = root;
                if(i != key.length()){
                    i--;
                }
            }
        }
        return result;
    }

    public boolean isArrive(TreeNode locaNode) {
        if(locaNode.data == null){
            return false;
        }else {
            return true;
        }
    }

    //查询
    private String path(TreeNode locaNode, String key) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        searchNode(locaNode, s, key);
        String path = "";
        if (!s.empty()) {
            while (!s.empty()) {
                if (s.peek().index != null) {
                    path += s.pop().index;
                } else {
                    s.pop();
                }
            }
            return reverse1(path);
        } else {
            return "";
        }

    }

    private static String reverse1(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    private static boolean searchNode(TreeNode root, Stack<TreeNode> s, String key) {
        if (root == null) {
            return false;
        }
        s.push(root);
        //千万注意java中判断字符串是否相等一定要用equal
        if (key.equals(root.data)) {
            return true;
        }
        boolean b = false;
        //先去左子树找
        if (root.leftChild != null) b = searchNode(root.leftChild, s, key);
        //左子树找不到并且右子树不为空的情况下才去找
        if (!b && root.rightChild != null) b = searchNode(root.rightChild, s, key);
        //左右都找不到，弹出栈顶元素
        if (!b) s.pop();
        return b;
    }

    //哈夫曼编码树
    private static TreeNode haffmanCodeTree(List<TreeNode> nodes) {
        TreeNode newLeftNode = new TreeNode();
        TreeNode newRightNode = new TreeNode();

        // 只要nodes数组中还有2个以上的节点
        while (nodes.size() > 1) {
            quickSort(nodes, 0, nodes.size() - 1);
            //调试使用
            for (int i = 0; i < nodes.size(); i++) {
                System.out.print(nodes.get(i).data + ":" + nodes.get(i).weight);
            }
            System.out.println();

            //获取权值最小的两个节点
            newLeftNode = nodes.get(nodes.size() - 1);

            newRightNode = nodes.get(nodes.size() - 2);


            //两者的父节点
            TreeNode newRootNode = new TreeNode(null, newLeftNode.weight + newRightNode.weight);

            newRootNode.leftChild = newLeftNode;
            newRootNode.rightChild = newRightNode;


            //删除权值最小的两个节点
            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);

            nodes.add(newRootNode);
            quickSort(nodes, 0, nodes.size() - 1);
        }
        return nodes.get(0);
    }

    //按照权重从大到小排列
    private static void quickSort(List<TreeNode> nodes, int start, int end) {
        int si = partition(nodes, start, end);
        if (si > start) {
            quickSort(nodes, start, si - 1);
        }
        if (si < end) {
            quickSort(nodes, si + 1, end);
        }
    }

    //划分函数
    private static int partition(List<TreeNode> nodes, int start, int end) {
        //选最后一个作为基准值
        double pivot = nodes.get(end).weight;
        //比基准数大的角标，用于换位置
        int smallindex = start - 1;
        for (int i = start; i <= end; i++) {
            //小于则不处理
            if (nodes.get(i).weight >= pivot) {
                smallindex++;
                if (i > smallindex) {
                    swap(nodes, i, smallindex);
                }
            }
        }
        return smallindex;
    }

    //交换函数
    private static void swap(List<TreeNode> nodes, int i, int j) {
        TreeNode tmp;
        tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    //打印树
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("=========================================================================");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                TreeNode temp = (TreeNode) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data + "和" + temp.index);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("=========================================================================");
    }

}

class TreeNode {
    public TreeNode leftChild;
    public TreeNode rightChild;
    public String index;       //结点的标记
    public double weight;
    public String data;      //存储的字符

    public TreeNode(String data, double weight) {
        super();
        this.data = data;
        this.weight = weight;
    }

    public TreeNode() {
        super();
    }
}


