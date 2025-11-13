public class StackUtility {
	public static MyStack removeRange(MyStack s, int i, int j) throws Exception {
		if(s instanceof StackArray) {
			StackArray st = new StackArray();
			for(int k = 0; k < i; ++k) {
				st.push(s.top());
				s.pop();
			}
			for(int k = 0; k < j - i + 1; ++k) {
				s.pop();
			}
			for(int k = 0; k < i; ++k) {
				s.push(st.top());
				st.pop();
			}
			return s;
		}
		else if(s instanceof StackLinkedList){
			StackLinkedList st = new StackLinkedList();
			for(int k = 0; k < i; ++k) {
				st.push(s.top());
				s.pop();
			}
			for(int k = 0; k < j - i + 1; ++k) {
				s.pop();
			}
			for(int k = 0; k < i; ++k) {
				s.push(st.top());
				st.pop();
			}
			return s;
		}
		else {
			throw new Exception("s is not a correct class");
		}
	}
}
