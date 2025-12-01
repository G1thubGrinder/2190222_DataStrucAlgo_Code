
public class Treap {
	TreapNode root;
	int size;
	public Treap() {
		this.root = null;
		this.size = 0;
	}
	
	public TreapNode BSTinsert(TreapNode cur, TreapNode t) {
		if(t.bstValue < cur.bstValue) {
			if(cur.left == null) {
				cur.left = t;
				t.parent = cur;
				size++;
				return cur;
			} else return BSTinsert(cur.left, t);
		}
		else if(t.bstValue > cur.bstValue) {
			if(cur.right == null) {
				cur.right = t;
				t.parent = cur;
				size++;
				return cur;
			} else return BSTinsert(cur.right, t);
		}
		else return new TreapNode(-999,-999);
	}
	
	public TreapNode traverseUp(TreapNode a, TreapNode i) {
		if(i == a.right) {
			if(a == root) {
				root = i;
			}
			else {
				TreapNode A = a.parent;
				if(A.right == a) A.right = i;
				else A.left = i;
				i.parent = A;
			}
			TreapNode i1 = i.left;
			i.left = a;
			a.parent = i;
			if(i1 != null) {
				a.right = i1;
				i1.parent = a;
			}
		}
		else {
			if(a == root) {
				root = i;
			}
			else {
				TreapNode A = a.parent;
				if(A.right == a) A.right = i;
				else A.left = i;
				i.parent = a.parent;
			}
			TreapNode i2 = i.right;
			i.right = a;
			a.parent = i;
			if(i2 != null) {
				a.left = i2;
				i2.parent = a;
			}
		}
		return i;
	}
	
	public TreapNode insert(int v, int h) {
		TreapNode i = new TreapNode(v,h);
		if(root == null) {
			root = i;
			size++;
		}
		TreapNode a = BSTinsert(root, i);
		if(a.bstValue == -999 && a.heapValue == -999) return null;
		while(root != i) {
			if(i.parent.heapValue < i.heapValue) break;
			i = traverseUp(i.parent,i);
		}
		return i;
	}
}
