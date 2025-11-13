import java.util.ArrayList;

public class BSTList {
	public BSTNodeList find(Pairdata v) {
		BSTNodeList tmp = root;
		while(tmp != null) {
			if(tmp.dataList.contains(v)) return tmp;
			else if(tmp.dataList.get(0).first > v.first) tmp = tmp.left;
			else tmp = tmp.right;
		}
		return null;
	}
	public BSTNodeList insert(Pairdata v) {
		if(find(v) != null) return root;
		BSTNodeList tmp = root, prev = null;
		Boolean isLeft = true;
		while(tmp != null) {
			if(tmp.dataList.get(0).first == v.first) {
				tmp.dataList.add(v);
				size++;
				return root;
			}
			else if(tmp.dataList.get(0).first > v.first) {
				prev = tmp;
				isLeft = true;
				tmp = tmp.left;
			}
			else {
				prev = tmp;
				isLeft = false;
				tmp = tmp.right;
			}
		}
		if(tmp == null) {
			ArrayList<Pairdata> newList = new ArrayList<>();
			newList.add(v);
			BSTNodeList newNode = new BSTNodeList(newList,null,null,prev);
			if(isLeft) prev.left = newNode;
			else prev.right = newNode;
		}
		size++;
		return root;
	}
}
