package tree;

import java.util.ArrayList;
import java.util.List;


public class HaffmanTreeText {
    public static void main(String[] args) {
        //链式储存数据
        List<TreeNode> nodes = new ArrayList<TreeNode>();

        nodes.add(new TreeNode(" ", 5));
        nodes.add(new TreeNode("w", 4));
        nodes.add(new TreeNode("l", 4));
        nodes.add(new TreeNode("e", 2));
        nodes.add(new TreeNode("i", 2));
        nodes.add(new TreeNode("r", 1));
        nodes.add(new TreeNode("u", 1));

//        nodes.add(new TreeNode("a", 1));
//        nodes.add(new TreeNode("d", 1));
//        nodes.add(new TreeNode("e", 1));
//        nodes.add(new TreeNode("b", 1));

        HaffmanTree tree = new HaffmanTree();
        tree = tree.initial(nodes);
        //tree.Encode(tree.root,null);
        tree.displayTree();

        System.out.println(tree.Encode("we will we will r u"));
        System.out.println(tree.Decode("00 110 10 00 1111 01 01 10 00 110 10 00 1111 01 01 10 11101 10 11100"));
        System.out.println(tree.Decode("00110100011110101100011010001111010110111011011100"));

    }
}
