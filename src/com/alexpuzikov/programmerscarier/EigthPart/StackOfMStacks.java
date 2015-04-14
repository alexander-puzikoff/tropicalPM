package com.alexpuzikov.programmerscarier.EigthPart;

/**
 * for task 3.3 of third chapter
 * 
 * @author PuzikovAU
 *
 * @param <T>
 */
public class StackOfMStacks<T> {
	private int maxSize = -1;

	private MStack<MStack<T>> ms = null;
	private MStack<T> curStack = null;
	private int currentIndex = 0;
	private int minIndex = -1;
	private int curStackIndex = 1;

	public int getMaxSize() {
		return maxSize;
	}

	public StackOfMStacks(int maxSize) {
		ms = new MStack<MStack<T>>();
		this.maxSize = maxSize;
		this.curStack = new MStack<T>();
		// ms.push(this.curStack);

	}

	public int size() {
		return this.currentIndex;
	}

	public void setMaxSize(int max_size) {
		this.maxSize = max_size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Current index: ");
		sb.append(currentIndex);
		sb.append("\r\n");
		sb.append("Current inner stack index: ");
		sb.append(curStackIndex);
		sb.append("\r\n");

		return sb.toString();
	}

	public void push(T o) {

		if (this.maxSize * this.curStackIndex > this.currentIndex) { // in
																		// current
																		// stack
			this.curStack.push(o);
			this.currentIndex++;
		} else { // new stack
			this.curStackIndex++;
			this.currentIndex++;
			ms.push(this.curStack);
			this.curStack = new MStack<T>();
			this.curStack.push(o);
		}
	}

	public T pop() {

		this.currentIndex--;
		if (this.currentIndex <= (this.maxSize * (this.curStackIndex - 1))) {
			T object = null;
			if (this.curStack != null) {
				object = this.curStack.pop();
			}
			this.curStackIndex--;
			this.curStack = ms.pop();
			return object;
		} else {
			if(this.curStack == null){
				return null;
			}
			return this.curStack.pop();
		}
	}
}
