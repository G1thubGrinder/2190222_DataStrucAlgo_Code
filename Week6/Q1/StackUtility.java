public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		StackLinkedList s3 = new StackLinkedList();
		while(!s1.isEmpty() && !s2.isEmpty()) {
			int n1 = s1.top();
			s1.pop();
			if(s1.isEmpty()) break;
			int n2 = s1.top();
			s1.pop();
			Boolean operation = (s2.top() >= 0) ? true : false;
			s2.pop();
			if(operation) {
				s3.push(n1 + n2);
			}
			else {
				s3.push(Math.abs(n1 - n2));
			}
		}
		String ans = "";
		while(!s3.isEmpty()) {
			ans += alphabets.charAt(s3.top());
			s3.pop();
		}
		return ans;
	}
}