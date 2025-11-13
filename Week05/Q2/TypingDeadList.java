public class TypingDeadList extends CDLinkedList {
	int score = 0;  //not used in this exam
	DListIterator start = null; // the first position of a word to remove
	DListIterator end = null; // last position of a word to remove

	public TypingDeadList() throws Exception {
		this("");
	}

	public TypingDeadList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	public void removeWord(String w) throws Exception {
		// remove the first occurrence of w
		// if w is not in the list, do nothing
		// reset start and end to null no matter what
		findWord(w);
		if (start == null)
			return;

		int dec = w.length();
		remove(dec);

	}

	public void findWord(String w) throws Exception {
		if (w.length() > this.size) return;
		if (this.size == 0) return;
		start = new DListIterator(header);
		end = new DListIterator(header);
		for(int i = 0; i < w.length() - 1; ++i) {
			end.currentNode = end.currentNode.nextNode;
		}
		while(!end.currentNode.equals(header)) {
			start.currentNode = start.currentNode.nextNode;
			end.currentNode = end.currentNode.nextNode;
			if(end.currentNode.equals(header)) break;
			if(w.charAt(0) != start.currentNode.data) continue;
			if(w.charAt(w.length()-1) != end.currentNode.data) continue;
			DListIterator d = new DListIterator(start.currentNode.nextNode);
			for(i = 1; i < w.length() - 1; ++i) {
				if(w.charAt(i) != (d.currentNode.data)) {break;}
				d.next();
			}
			if(i == w.length() - 1) return;
		}
		start = null;
		end = null;
	}

	public void remove(int dec) throws Exception { // this must be the last method in your code!
		if(start == null || end == null || start.currentNode == header || end.currentNode == header) return;
		DListNode newStart = start.currentNode.previousNode;
		DListNode newEnd = end.currentNode.nextNode;
		newStart.nextNode = newEnd;
		newEnd.previousNode = newStart;
		start = null;
		end = null;
		size -= dec;
	}

}