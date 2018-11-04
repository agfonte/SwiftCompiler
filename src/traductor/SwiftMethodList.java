package traductor;

import java.util.ArrayList;

/**
 * Convenience Tree Structure for controlling the method hierarchy on Swift. Created by Razor on 7/4/2017.
 *
 * @author Razor
 */
public class SwiftMethodList {

    private ArrayList<SwiftMethod> root;
    private SwiftMethod current;

    /**
     * Builds a {@link SwiftMethodList} with a root
     *
     * @param root the root node of type {@link SwiftMethod}
     */
    public SwiftMethodList(SwiftMethod root) {
        this.root = new ArrayList<>();
        this.root.add(root);
        current = root;
    }

    /**
     * Get the {@link SwiftMethod} that's being processing at the time
     *
     * @return the current SwiftMethod
     */
    public SwiftMethod getCurrentMethod() {
        return current;
    }


    /**
     * Get the root of the actual tree, probably the main function
     *
     * @return the tree root
     */
    public ArrayList<SwiftMethod> getRoot() {
        return root;
    }


    /**
     * Add the {@link SwiftMethod} as a dependency of the current, then makes it
     * the current
     *
     * @param swiftMethod the new SwiftMethod to be added
     */
    public void addSwiftMethod(SwiftMethod swiftMethod) {
        root.add(swiftMethod);
        current = swiftMethod;

    }

    public void closeCurrent() {
        root.remove(root.size() - 1);
        current = root.get(root.size() - 1);
    }

    public int getSize() {
        return root.size();
    }
}
