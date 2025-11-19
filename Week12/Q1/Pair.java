public class Pair {
	int value;
	int freq;
	
	public Pair(int v, int f) {
		value = v;
		freq = f;
	}

	public boolean greater(Pair other) {
		if(this.freq > other.freq) return true;
		else if(this.freq < other.freq)return false;
		else return (this.value < other.value) ? true : false; 
	}

		
}
