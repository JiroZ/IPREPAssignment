import java.util.ArrayList;
import java.util.Stack;
public class PostorderTraversal {
    static class Node
    {
        int data;
        Node left, right;

        Node(int item)
        {
            data = item;
            left = right;
        }
    }

    static class BinaryTree
    {
        Node root;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> postOrderIterative(Node node)
        {
            Stack<Node> nodeStack = new Stack<>();

            if (node == null) {
                return list;
            }
            nodeStack.push(node);
            Node previousNode = null;
            while (!nodeStack.isEmpty())
            {
                Node currentNode = nodeStack.peek();

                if (previousNode == null || previousNode.left == currentNode || previousNode.right == currentNode)
                {
                    if (currentNode.left != null)
                        nodeStack.push(currentNode.left);
                    else if (currentNode.right != null)
                        nodeStack.push(currentNode.right);
                    else
                    {
                        nodeStack.pop();
                        list.add(currentNode.data);
                    }
                }

                else if (currentNode.left == previousNode)
                {
                    if (currentNode.right != null)
                        nodeStack.push(currentNode.right);
                    else
                    {
                        nodeStack.pop();
                        list.add(currentNode.data);
                    }
                }

                else if (currentNode.right == previousNode)
                {
                    nodeStack.pop();
                    list.add(currentNode.data);
                }

                previousNode = currentNode;
            }

            return list;
        }
        
        public static void main(String args[])
        {
            BinaryTree tree = new BinaryTree();

            tree.root = new Node(1);
            tree.root.left = new Node(2);
            tree.root.right = new Node(3);
            tree.root.right.right = new Node(4);
            tree.root.left.right = new Node(5);
            tree.root.left.left = new Node(6);

            ArrayList<Integer> mylist = tree.postOrderIterative(tree.root);

            System.out.println("Post order traversal of binary tree is :");
            System.out.println(mylist);
        }
    }
}
