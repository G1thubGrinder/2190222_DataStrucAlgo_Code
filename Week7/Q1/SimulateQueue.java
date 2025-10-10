public class SimulateQueue {

	CustomerInfo[][] allEvents; //events in each and every queue
 
	MyQueue[] allQueues; // queues of people, corresponding to the events

	public SimulateQueue(CustomerInfo[][] allEvents, MyQueue[] allQueues) {
		super();
		this.allEvents = allEvents;
		this.allQueues = allQueues;
	}

	public void stateBeforeTimeT(int t) throws Exception {
		MyQueue[] newQueue = new MyQueue[allQueues.length];
		for(int i = 0; i < allQueues.length; ++i) {
			newQueue[i] = new QueueArray();
			for(int j = 0; j < allEvents[i].length; ++j) {
				if(allEvents[i][j].time >= t) break;
				if(allEvents[i][j].event == 1) {
					newQueue[i].insertLast(allEvents[i][j].time);
				}
				else {
					newQueue[i].removeFirst();
				}
			}
		}
		allQueues = newQueue;
	}
}
