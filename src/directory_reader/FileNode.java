package directory_explorer;

import java.util.Map;
import java.util.Collection;
import java.util.HashMap;

/**
 * The root of a tree representing a directory structure.
 */
public class FileNode {

	/** The name of the file or directory this node represents. */
	private String name;
	/** Whether this node represents a file or a directory. */
	private FileType type;
	/** This node's parent. */
	private FileNode parent;
	/**
	 * This node's children, mapped from the file names to the nodes. If type is
	 * FileType.FILE, this is null.
	 */
	private Map<String, FileNode> children;

	/**
	 * A node in this tree.
	 *
	 * @param name
	 *            the file
	 * @param parent
	 *            the parent node.
	 * @param type
	 *            file or directory
	 * @see buildFileTree
	 */
	public FileNode(String name, FileNode parent, FileType type) {
		this.name = name;
		this.parent = parent;
		this.type = type;
		if (this.type == FileType.DIRECTORY) {
			this.children = new HashMap<String, FileNode>();
			
		} else {
			this.children = null;
		}
	}

	/**
	 * Find and return a child node named name in this directory tree, or null
	 * if there is no such child node.
	 *
	 * @param name
	 *            the file name to search for
	 * @return the node named name
	 */
	public FileNode findChild(String name) {
		FileNode result = null;
		boolean exists = this.children.containsKey(name);
		if (exists) {
			result = this.children.get(name);
		} else {
			result = null;
		}
		return result;
	}

	/**
	 * Return the name of the file or directory represented by this node.
	 *
	 * @return name of this Node
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Set the name of the current node
	 *
	 * @param name
	 *            of the file/directory
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Return the child nodes of this node.
	 *
	 * @return the child nodes directly underneath this node.
	 */
	public Collection<FileNode> getChildren() {
		return this.children.values();
	}

	/**
	 * Return this node's parent.
	 * 
	 * @return the parent
	 */
	public FileNode getParent() {
		return parent;
	}

	/**
	 * Set this node's parent to p.
	 * 
	 * @param p
	 *            the parent to set
	 */
	public void setParent(FileNode p) {
		this.parent = p;
	}

	/**
	 * Add childNode, representing a file or directory named name, as a child of
	 * this node.
	 * 
	 * @param name
	 *            the name of the file or directory
	 * @param childNode
	 *            the node to add as a child
	 */
	public void addChild(String name, FileNode childNode) {
		this.children.put(name, childNode);
	}

	/**
	 * Return whether this node represents a directory.
	 * 
	 * @return whether this node represents a directory.
	 */
	public boolean isDirectory() {
		return this.type == FileType.DIRECTORY;
	}

	/**
	 * This method is for code that tests this class.
	 * 
	 * @param args
	 *            the command line args.
	 */
	public static void main(String[] args) {
		System.out.println("Testing FileNode");
		FileNode f1 = new FileNode("top", null, FileType.DIRECTORY);
		FileNode son1 = new FileNode("son1", null, FileType.DIRECTORY);
		FileNode son2 = new FileNode("son2", null, FileType.FILE);
		FileNode son3 = new FileNode("son3", null, FileType.DIRECTORY);
		//System.out.println(f1);
		f1.addChild("son1", son1);
		f1.addChild("son2", son2);
		f1.addChild("son3", son3);
		if (!f1.getName().equals("top")) {
			System.out.println("Error: " + f1.getName() + " should be " + "top");
		}
		System.out.println(f1.children);
		FileNode found = f1.findChild("son1");
		System.out.println("-------");
		System.out.println(found);
	}

}
