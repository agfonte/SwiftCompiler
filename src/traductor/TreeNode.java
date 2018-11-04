package traductor;

import java.util.LinkedList;

/**
 * Created by Razor on 7/4/2017.
 * SwiftCompiler
 */
public class TreeNode<T> {
    public T item;
    public TreeNode<T> parent;
    public LinkedList<TreeNode<T>> childrens;

    public TreeNode(T item, TreeNode<T> parent) {
        this.item = item;
        this.parent = parent;
        childrens = new LinkedList<>();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TreeNode) {
            return item.equals(obj);
        }
        return false;
    }

    @Override
    public String toString() {
        return item.toString();
    }
}
