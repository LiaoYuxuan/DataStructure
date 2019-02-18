package tree;

import java.util.Stack;

//左小右大的二叉树
public class BinaryTree {
    private Node root;

    //创建一个空树
    public void tree() {
        root = null;
    }

    //查询
    public Node find(int key) {
        Node current = root;
        while (key != current.iData) {
            if (key < current.iData) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    //插入(id为索引,dd为值)
    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent; //与current相关的父节点
            while (true) {
                parent = current;//初始化赋值
                if (id < current.iData) {
                    current = current.leftChild;
                    //当前结点为空，说明可以插入
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    //删除
    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (current.iData != key) {
            parent = current;
            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            //没有该数据
            if (current == null) {
                return false;
            }
        }

        //删除操作
        //1.没有左右子树
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        //2.如果无右结点，只有左结点
        else if (current.rightChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        }
        //3.如果无左结点，只有右结点
        else if (current.leftChild == null) {
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        }
        //4.既有左结点，又有右结点
        else {
            Node successor = findSuccessor(current);

            //找到继承者后
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;

        }
        return true;
    }

    //寻找继承者（只能从右子树中寻找）
    private Node findSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;
        while (current != null) {
            //一路向左
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        //如果继承者不是当前被删除结点的右子节点，说明存在右子树
        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    //前序遍历
    private void preOrder(Node locaNode) {
        if (locaNode != null) {
            System.out.print(locaNode.iData + "  ");
            preOrder(locaNode.leftChild);
            preOrder(locaNode.rightChild);
        }
    }

    //中序遍历
    private void inOrder(Node locaNode) {
        if (locaNode != null) {
            inOrder(locaNode.leftChild);
            System.out.print(locaNode.iData + "  ");
            inOrder(locaNode.rightChild);
        }
    }

    //后序遍历
    private void postOrder(Node locaNode) {
        if (locaNode != null) {
            postOrder(locaNode.leftChild);
            postOrder(locaNode.rightChild);
            System.out.print(locaNode.iData + "  ");
        }
    }

    public void tranverse(int type) {
        switch (type) {
            case 1:
                System.out.println("pre:");
                preOrder(root);
                System.out.println();
                break;
            case 2:
                System.out.println("in:");
                inOrder(root);
                System.out.println();
                break;
            case 3:
                System.out.println("post:");
                postOrder(root);
                System.out.println();
                break;
            default:
                break;
        }
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
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
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

class Node {
    public Node leftChild;
    public Node rightChild; //链表的性质
    public int iData;       //数组的性质：索引值
    public double dData;

    public void displayNode() {
        System.out.println("{");
        System.out.println(iData);
        System.out.println(",");
        System.out.println(dData);
        System.out.println("}");

    }
}
