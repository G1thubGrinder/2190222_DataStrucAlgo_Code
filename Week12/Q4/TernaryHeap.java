public class TernaryHeap extends Heap{
	@Override
	protected void percolateUp() {
		int parent;
		int child = size - 1;
		int temp;
		while (child > 0) {
			parent = (child - 1)/3;
			if (mData[parent] <= mData[child]) break;
			temp = mData[parent];
			mData[parent] = mData[child];
			mData[child] = temp;
			child = parent;
		}
	}
	
	@Override
	protected void percolateDown(int start) {
		int parent = start;
		int child = 3 * parent + 1;
		int temp;
		while (child < size) {
			if(child < size - 1 && mData[child] > mData[child + 1]) {
				child++;
				if(child < size - 1 && mData[child] > mData[child + 1]) child++;
			}
			else if(child < size - 2 && mData[child] > mData[child + 2]) child += 2;	
			if(mData[parent] <= mData[child])break;
			temp = mData[child];
			mData[child] = mData[parent];
			mData[parent] = temp;
			parent = child;
			child = 3 * parent + 1;
		}
	}
}
