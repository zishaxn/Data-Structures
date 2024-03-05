package binary_trees;

public class BinaryTree<T> {
    BinaryTree<T> left;
    BinaryTree<T> right;
    T value;

    public BinaryTree(T value){
        this.value=value;
    }

}
