package traductor;

import java.util.LinkedList;

/**
 * Convenience Tree Structure for controlling the method hierarchy on Swift. Created by Razor on 7/4/2017.
 *
 * @author Razor
 */
public class SwiftMethodTree {

    private TreeNode<SwiftMethod> root;
    private TreeNode<SwiftMethod> current;

    /**
     * Builds a {@link SwiftMethodTree} with a root
     *
     * @param root the root node of type {@link TreeNode}
     */
    public SwiftMethodTree(TreeNode<SwiftMethod> root) {
        this.root = root;
        current = root;
    }

    /**
     * Get the {@link SwiftMethod} that's being processing at the time
     *
     * @return the current SwiftMethod
     */
    public SwiftMethod getCurrentMethod() {
        return current.item;
    }


    /**
     * Get the root of the actual tree, probably the main function
     *
     * @return the tree root
     */
    public TreeNode<SwiftMethod> getRoot() {
        return root;
    }


    /**
     * Add the {@link SwiftMethod} as a dependency of the current, then makes it
     * the current
     *
     * @param swiftMethod the new SwiftMethod to be added
     */
    public void addSwiftMethod(SwiftMethod swiftMethod) {
        TreeNode<SwiftMethod> newNode = new TreeNode<>(swiftMethod, current);
        current.childrens.add(newNode);
        current = newNode;
    }

    /**
     * This make the current method to end his processing, the parent method
     * became the current method
     *
     * @return the {@link SwiftMethod} that was closed
     */
    public SwiftMethod closeCurrent() {
        SwiftMethod method = current.item;
        current = current.parent;
        return method;
    }

    /**
     * This make sure that a method call is accessible by the current method
     *
     * @param functionSignature the funtion signature provided by {@link SwiftMethod}.toString()
     * @return the {@link SwiftMethod} that was closed
     */
    public boolean isAccessible(String functionSignature) {
        if (current.item.toString().equals(functionSignature)) {
            return true;
        }
        //Just look in the first level of the tree TODO Can't call nested function of level 2 or more
        LinkedList<TreeNode<SwiftMethod>> list = current.childrens;
        while (!list.isEmpty()) {
            SwiftMethod method = list.pop().item;
            if (functionSignature.equals(method.toString())) {
                return true;
            }
        }
        return false;
    }
}
