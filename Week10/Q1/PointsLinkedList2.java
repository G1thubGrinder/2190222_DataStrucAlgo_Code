public class PointsLinkedList2 extends PointsLinkedList{
	public boolean pointValueExist(Point p) throws Exception {
		if (header.nextNode == null) return false;
		PointListIterator pi = new PointListIterator(header.nextNode);
		while(pi.currentNode.data != null) {
			Point newP = pi.currentNode.data;
			if(newP.value == p.value && ((newP.nextValue != p.nextValue)||(newP.preValue != p.preValue))){
				return true;
			}
			pi.next();
		}
		return false;
	}
}