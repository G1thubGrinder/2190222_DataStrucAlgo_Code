public class TTree {
	public void predictResult() {
		for(int i = 0; i < level; ++i) {
			for(int j = 0; j < theArray[i].length/2; ++j) {
				if(theArray[i][2*j].ranking < theArray[i][2*j+1].ranking) {
					theArray[i+1][j] = theArray[i][2*j];
				}else {
					theArray[i+1][j] = theArray[i][2*j+1];
				}
			}	
		}
		winner = theArray[level][0];
	}
}
