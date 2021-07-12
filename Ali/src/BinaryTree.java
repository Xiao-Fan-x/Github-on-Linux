import java.time.chrono.IsoChronology;

public class BinaryTree<T extends Comparable<T>> {

    private class Node {
        private Comparable<T> data;//存放comparable，可以比较大小
        private Node parent;    //保存父节点
        private Node left;
        private Node right;

        public Node(Comparable<T> data) {
            this.data = data;
        }

        public boolean containsNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
                return true;
            } else if (data.compareTo((T) this.data) < 0) {
                if (this.left != null) {
                    return this.left.containsNode(data);
                } else {
                    return false;
                }
            } else {
                if (this.right != null) {
                    return this.right.containsNode(data);
                } else {
                    return false;
                }
            }
        }

        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) <= 0) {
                if (this.left == null) {
                    this.left = newNode;
                    newNode.parent = this;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }


        public Node getRemoveNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
                return this;
            } else if (data.compareTo((T) this.data) < 0) {
                if (this.left != null) {
                    return this.left.getRemoveNode(data);
                } else {
                    return null;
                }
            } else {
                if (this.right != null) {
                    return this.right.getRemoveNode(data);
                } else {
                    return null;
                }
            }
        }

        //获取所有数据，中序遍历
        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }
            BinaryTree.this.returnData[BinaryTree.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }

    }

    private Node root;
    private int count;
    private Object[] returnData;
    private int foot = 0;//脚标控制


    public void add(Comparable<T> data) {
        if (data == null) {
            throw new NullPointerException("保存的数据不能为空");
        }
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    public void remove(Comparable<T> data) {
        Node removeNode = this.root.getRemoveNode(data);
        if (removeNode != null) {
            //没有任何子节点
            if (removeNode.left == null && removeNode.right == null) {
                removeNode.parent.left = null;
//                removeNode.parent.right = null;
                removeNode.parent = null;
            } else if (removeNode.left != null && removeNode.right == null) {
                removeNode.left.parent = removeNode.parent;
            } else if (removeNode.left == null && removeNode.right != null) {
                removeNode.right.parent = removeNode.parent;
            } else {
                Node moveNode = removeNode.right;
                while (moveNode.left != null) {
                    moveNode = moveNode.left;
                }
                moveNode.parent.left = null;
                moveNode.parent = removeNode.parent;
                moveNode.right = removeNode.right;
            }
            this.count--;
        }
    }

    public Object[] toArray() {
        if (this.count == 0) {
            return null;
        }
        this.returnData = new Object[this.count];//保存长度为数组长度
        this.foot = 0;//脚标清零
        this.root.toArrayNode();
        return this.returnData;
    }

}