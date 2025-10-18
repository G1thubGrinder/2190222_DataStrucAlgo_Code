import java.util.*;
public class BST {
	public int height() {
		if(this.root == null) return -1;
		if(root.left == null && root.right == null)return 0;
		int cnt = 0;
		Queue<BSTNode> q = new LinkedList<>();
		q.add(this.root);
		while(!q.isEmpty()) {
			int len = q.size();
			for(int i = 0; i < len; ++i) {
				BSTNode newRoot = q.poll();
				if(newRoot.left != null)q.add(newRoot.left);
				if(newRoot.right != null)q.add(newRoot.right);
			}
			cnt++;
		}
		return cnt - 1;
	}

	public ArrayList<Integer> recur(ArrayList<Integer> bst, BSTNode node){
		if(node.left != null) {
			bst.add(node.left.data);
			bst = recur(bst, node.left);
		}
		if(node.right != null) {
			bst.add(node.right.data);
			bst = recur(bst, node.right);
		}
		return bst;
	}
	
	public void insertMedian(List<Integer> arr) {
		if(arr.size() == 0) return;
		if(arr.size() == 1) {
			this.insert(arr.get(0));
			return;
		}
		int mid = arr.size()/2;
		this.insert(arr.get(mid));
		insertMedian(arr.subList(0, mid));
		insertMedian(arr.subList(mid+1,arr.size()));
	}

	public void makeBalancedTree() {
		if(root == null ||(root.left == null && root.right == null)) return;
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(root.data);
		arr = recur(arr, root);
		arr.sort(Comparator.naturalOrder());
		this.makeEmpty();
		insertMedian(arr);
	}
}
