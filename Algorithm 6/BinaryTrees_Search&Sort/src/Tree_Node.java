public class Tree_Node<E extends Comparable<E>> {
    Tree_Node<E> leftNode;
    Tree_Node<E> rightNode;
    E data_OR_Value;

    public Tree_Node(E inComing_Data) {
        this.data_OR_Value = inComing_Data;
        this.leftNode = null;
        this.rightNode = null;
    }

    public void addNode(E value) {
        if (value.compareTo(this.data_OR_Value) < 0) {
            if (this.leftNode == null) {
                this.leftNode = new Tree_Node<E>(value);
            } else {
                this.leftNode.addNode(value);
            }
        } else if (value.compareTo(this.data_OR_Value) > 0) {
            if (this.rightNode == null) {
                this.rightNode = new Tree_Node<E>(value);
            } else {
                this.rightNode.addNode(value);
            }
        }
    }
}
