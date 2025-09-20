public class Deck extends DeQLinkedList{
	public int draw() {
		try {
			return this.removeFirst();
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	public int removeNth(int n) {
		DListIterator itr;
		try {
			if(n == 0) {
				itr = new DListIterator(theList.header);
			}
			else {
				itr = (DListIterator) theList.findPrevious(theList.findKth(n));
			}
			itr.next();
			DListNode node = itr.currentNode;
			theList.removeAt(itr);
			return node.data;
		}
		catch(Exception e) {
			return -1;
		}
	}
	
	public void putBottom(int n) {
		try {
			this.insertLast(n);
		} catch(Exception e) {}
	}
	
	//Used in reverseTopN
	public void rotate(int n) {
		if(n <= 0) return;
		try {
			int first = this.removeFirst();
			this.insertLast(first);
			rotate(n-1);
		}
		catch (Exception e){}
		
	}
	
	//Used in reverseTopN
	public void reverse(int n) {
		if(n <= 0) return;
		try {
			int first = this.removeFirst();
			reverse(n-1);
			this.insertLast(first);
		} catch(Exception e) {}
	}
	
	public void reverseTopN(int n) {
		if(n <= 0) return;
		if(n > this.size()) n = this.size();
		reverse(n);
		rotate(this.size() - n);
	}
	
	//Just for Testing
	public String printDeck(){
		DListIterator d = new DListIterator(theList.header);
		String ans = "";
		try {
			d.next();
			while(!d.currentNode.equals(theList.header)) {
				ans += Integer.toString(d.currentNode.data) + " ";
				d.next();
			}
		}
		catch(Exception e) {}
		return ans;
	}
}