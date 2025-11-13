public class BST {
	public void addLeftSubTreeToMin(BST subtree) {
		if(this.root == null) {
			this.root = subtree.root;
			this.size = subtree.size;
		}
		if(subtree.root == null)return;
		TreeIterator ti1 = (TreeIterator) this.findMin();
		TreeIterator ti2 = (TreeIterator) subtree.findMax();
		if(ti1.currentNode.data > ti2.currentNode.data) {
			this.size += subtree.size;
			ti1.currentNode.left = subtree.root;
			subtree.root.parent = ti1.currentNode;
		}
	}

}
