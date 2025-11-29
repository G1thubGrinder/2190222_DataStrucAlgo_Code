import java.util.Arrays;

public class BSTRecursive {
	public int size(BSTNode n) {
		if(n == null) return 0;
		return 1 + size(n.right) + size(n.left) ;
	}
	int lastPos = -1;         // to remember a marked position in the array "temp".
	int[] temp = new int[10]; // This array will store result we get from calling nonAVLNodes(n). Assume the number of nodes do not exceed 10.
	public int[] nonAVLNodes(BSTNode n) {
		if(n == null) return temp;
		if(!isAVL(n)) {
			lastPos++;
			temp[lastPos] = n.data;
		}
		temp = nonAVLNodes(n.right);
		temp = nonAVLNodes(n.left);
		Arrays.sort(temp);
		return temp;
	}
}

