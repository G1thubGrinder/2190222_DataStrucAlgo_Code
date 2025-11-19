public class Heap {
	public void add(int element) {
		if (++size == mData.length) {
			int[] newHeap = new int[2 * mData.length];
			System.arraycopy(mData, 0, newHeap, 0, size);
			mData = newHeap;
		}
		mData[size - 1] = element;
		percolateUp();

		// modified part is to be written below
		if (size < 2) return;
		if(mData[size - 2] > mData[size - 1]) {
			int temp = mData[size - 2];
			mData[size - 2] = mData[size - 1];
			mData[size - 1] = temp;
		}
		size--;
		percolateUp();
		size++;
	}
}
