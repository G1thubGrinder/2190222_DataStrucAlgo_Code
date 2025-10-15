
public class BankQueue { // must work for any implementation of DeQ
	DeQ[] counters;
	DeQ special;

	public BankQueue(DeQ[] counters, DeQ special) {
		super();
		this.counters = counters;
		this.special = special;
	}

	//Write this method
	public void distribute() throws Exception {
		float people = 0;
		for(int i = 0;i < counters.length; ++i) {
			people += counters[i].size();
		}
		int neededQueueLength = Math.round(people/(counters.length + 1));
		for(int i = 0; i < counters.length; ++i) {
			if(special.size() >= neededQueueLength) break;
			DeQ newQueue = new DeQArray();
			int len = counters[i].size();
			for(int j = 0; j < len - neededQueueLength; ++j) {
				newQueue.insertFirst(counters[i].removeLast());
			}
			len = special.size();
			int len2 = newQueue.size();
			for(int j = 0; j < neededQueueLength - len && j < len2; ++j) {
				special.insertLast(newQueue.removeFirst());
			}
			while(!newQueue.isEmpty()) {
				counters[i].insertLast(newQueue.removeFirst());
			}
		}
		if(special.size() == 0) {
			special.insertFirst(counters[counters.length - 1].removeLast());
		}
	}

}
