
public class Sort {
	//Hint: You can create other methods and then use sortFrequency to call them.

	public static Pair[] swap(Pair[] x, int a, int b) {
		Pair temp = x[a];
		x[a] = x[b];
		x[b] = temp;
		return x;
	}

	public static int[] sortFrequency(int[] x) {
		Pair[] frequ = new Pair[10];
		for(int i = 0; i < x.length; ++i) {
			int index = x[i] % 10;
			if(frequ[index] == null) {
				frequ[index] = new Pair(x[i],1);
			}
			else {
				frequ[index].freq++;
			}
		}
		int countNotNull = 0;
		for(int i = 0; i < 10; ++i) {
			if(frequ[i] != null) {
				frequ[countNotNull] = frequ[i];
				countNotNull++;
			}
		}
		for(int i = 0; i < countNotNull - 1; ++i) {
			for(int j = 0; j < countNotNull-1-i; ++j) {
				if(!frequ[j].greater(frequ[j + 1])) swap(frequ, j, j + 1);
			}
		}
		int[] ans = new int[countNotNull];
		for(int i = 0; i < countNotNull; ++i) {
			ans[i] = frequ[i].value;
		}
		return ans;
	}
}
