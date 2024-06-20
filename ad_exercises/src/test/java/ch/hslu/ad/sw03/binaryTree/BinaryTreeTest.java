package ch.hslu.ad.sw03.binaryTree;

import ch.hslu.ad.sw03.binaryTree.BinaryTree;
import ch.hslu.ad.sw03.binaryTree.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {
    private BinaryTree<Character> tree = null;
    private TreeNode root = null;

    @BeforeEach
    void setUp() {
        var a = new TreeNode<>('A');
        var b = new TreeNode<>('B');
        var c = new TreeNode<>('C');
        var d = new TreeNode<>('D');
        var e = new TreeNode<>('E');
        var f = new TreeNode<>('F');
        var g = new TreeNode<>('G');
        var h = new TreeNode<>('H');
        var i = new TreeNode<>('I');
        var j = new TreeNode<>('J');

        f.setLeft(c);
        f.setRight(i);

        c.setLeft(b);
        c.setRight(d);
        i.setLeft(g);
        i.setRight(j);

        b.setLeft(a);
        d.setRight(e);
        g.setRight(h);

        tree = new BinaryTree<>(f);
        root = f;
    }

    @Test
    void testSearch() {
        assertEquals('H', tree.search('H'));
    }

    @Test
    void testInsert() {
        tree.insert('Z');
        tree.insert('X');

        assertEquals('Z', root.getRight().getRight().getRight().getValue());
        assertEquals('X', root.getRight().getRight().getRight().getLeft().getValue());
    }

    @Test
    void testInorder() {
        tree.inorder();
    }

    @Test
    void testPreOrder() {
        tree.preorder();
    }

    @Test
    void testPostOrder() {
        tree.postorder();
    }
}