package lab2.common;

public class Stack<T>{
	private StackNode head;
	private boolean isEmpty;
	
	//Private Helper Class
	private class StackNode{
		private StackNode link;
		private T info;
		private StackNode(T info) {
			this.info = info;
		}
	}
	
	public Stack() {
		head = null;
		isEmpty = true;
	}
	public void pop() {
		if(head.link != null)
			head = head.link;
		else {
			head = null;
			isEmpty = true;
		}
	}
	public void push(T info) {
		isEmpty = false;
		if(head == null)
			head = new StackNode(info);
		else {
			StackNode temp = head.link;
			head.link = new StackNode(info);
			head.link = temp;
		}
	}
	public T top() {
		return head.info;
	}
	public boolean isEmpty() {
		return isEmpty;
	}
	public String toString() {
		String returnString = "";
		Stack<T> tempStack = new Stack<>();
		while(!this.isEmpty()) {
			returnString += this.top();
			tempStack.push(this.top());
			this.pop();
		}
		while(!tempStack.isEmpty()) {
			this.push(tempStack.top());
			tempStack.pop();
		}
		return returnString;
	}

	
}
