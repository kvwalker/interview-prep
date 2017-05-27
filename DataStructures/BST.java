public class BST {
	TreeNode root;

	public BST (int v) {
		this.root = new TreeNode(v);
	}

	public void insert (int v) {
		// assumption: don't allow duplicates
		if (root.val == v) {
			return;
		}

		insert(v, root, null);
	}

	public void insert (int v, TreeNode curr, TreeNode currParent) {
		if (search(v, curr)) {
			return;
		}
		if (curr == null) {
			curr = new TreeNode(v);
			if (curr.val < currParent.val) {
				currParent.left = curr;
			} else if (curr.val > currParent.val) {
				currParent.right = curr;
			}
			return;
		}
		if (v < curr.val) {
			// insert to left
			insert(v, curr.left, curr);
		} else {
			insert(v, curr.right, curr);
		}
	}

	public boolean search (int v) {
		if (root.val == v) {
			return true;
		}
		return search(v, root);
	}

	public boolean search (int v, TreeNode curr) {
		if (curr == null) {
			return false;
		}
		if (curr.val == v) {
			return true;
		}
		if (v < curr.val) {
			return search(v, curr.left);
		} else {
			return search(v, curr.right);
		}
	}

	public void printPreOrder () {
		printPreOrder(root);
		System.out.println();
	}

	public void printPreOrder (TreeNode curr) {
		if (curr == null) {
			return;
		}
		System.out.print(curr.val + " ");
		printPreOrder(curr.left);
		printPreOrder(curr.right);
	}

	public void printInOrder () {
		printInOrder(root);
		System.out.println();
	}

	public void printInOrder (TreeNode curr) {
		if (curr == null) {
			return;
		}
		printInOrder(curr.left);
		System.out.print(curr.val + " ");
		printInOrder(curr.right);
	}

	public void printPostOrder () {
		printPostOrder(root);
		System.out.println();
	}

	public void printPostOrder (TreeNode curr) {
		if (curr == null) {
			return;
		}
		printPostOrder(curr.left);
		printPostOrder(curr.right);
		System.out.print(curr.val + " ");
	}

	public boolean remove (int v) {
		if (v < root.val && root.left != null) {
			return remove(v, root.left, root);
		} else if (v > root.val && root.right != null) {
			return remove(v, root.right, root);
		} else if (v == root.val) {
			return remove(v, root, null); // what to do if currParent null
		}
		return false;
	}

	public boolean remove (int v, TreeNode curr, TreeNode currParent) {
		if (curr == null) {
			return false;
		}
		if (curr.val == v) {
			// leaf case
			if (curr.left == null && curr.right == null) {
				if (currParent == null) {
					curr = null;
					return true;
				}
				if (curr.val < currParent.val) {
					currParent.left = null;
				} else {
					currParent.right = null;
				}
				return true;
			} else if (curr.left == null && curr.right != null) {
				// right child
				if (currParent == null) {
					curr = curr.right;
					return true;
				}
				if (curr.val < currParent.val) {
					currParent.left = curr.right;
				} else {
					currParent.right = curr.right;
				}
				return true;
			} else if (curr.left != null && curr.right == null) {
				// left child
				if (currParent == null) {
					curr = curr.left;
					return true;
				}
				if (curr.val < currParent.val) {
					currParent.left = curr.left;
				} else {
\					currParent.left = curr.right;
				}
				return true;
			} else if (curr.left != null && curr.right != null) {
				// both children
				// find minimum value in right subtree and replace deleted value with this
				// then delete minimum value duplicate
				TreeNode temp = curr.right;
				TreeNode tempParent = curr;
				while (temp.left != null) {
					tempParent = temp;
					temp = temp.left;
				}
				// now temp should be the smallest value in the right subtree
				// so replace curr with temp val
				curr.val = temp.val;
				remove(temp.val, temp, tempParent);
				return true;
			}
		}

		if (v < curr.val) {
			return remove(v, curr.left, curr);
		} else {
			return remove(v, curr.right, curr);
		}
	}

	public static void main (String[] args) {
		BST test1 = new BST(10);

		test1.insert(16);
		test1.insert(4);
		test1.insert(2);
		test1.insert(11);
		test1.insert(22);
		for (int i = 0; i < 25; i += 3) {
			test1.insert(i);
		}
		test1.insert(1);
		test1.insert(13);
		test1.printPreOrder();
		test1.remove(22);
		test1.printPreOrder();
		test1.remove(0);
		test1.printPreOrder();
		test1.remove(10);
		test1.printPreOrder();
	}
}

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val;

	public TreeNode (int val) {
		this.val = val;
	}
}