package HW.Week4.Q1;

public class ShiftableList extends CDLinkedList {

	public ShiftableList() throws Exception {
		this("");
	}

	public ShiftableList(String s) throws Exception {
		// initialize the list
		// each data comes from each character in s
		int n = s.length();
		DListIterator d = new DListIterator(header);
		for (int i = n - 1; i >= 0; i--) {
			insert(s.charAt(i), d);
		}

	}

	//change the nth data (counting from header) to be a new first 
	//data of the list 
	public void shift(int n) throws Exception {
		DListIterator i1;
		try {
			i1 = (DListIterator) findPrevious(this.findKth(n-1));
			DListNode n1 = i1.currentNode;
			DListNode n2 = n1.nextNode;
			DListNode m1 = header.nextNode;
			DListNode m2 = header.previousNode;
			header.nextNode = n2;
			header.previousNode = n1;
			n1.nextNode = header;
			n2.previousNode = header;
			m1.previousNode = m2;
			m2.nextNode = m1;
		}
		catch(Exception e){
			System.err.println("");
		}
	}
	// shift the list such that the data at position newStart becomes the first data
	// for list a,b,c,d,e,f
	// if newStart is pointing at c, 
	// the new list will be c,d,e,f,a,b
	public void shift(DListNode newStart) {
		DListNode n2 = newStart.previousNode;
		DListNode m1 = header.nextNode;
		DListNode m2 = header.previousNode;
		header.nextNode = newStart;
		header.previousNode = n2;
		n2.nextNode = header;
		newStart.previousNode = header;
		m1.previousNode = m2;
		m2.nextNode = m1;
	}
}
