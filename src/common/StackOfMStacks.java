package common;

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

	public StackOfMStacks() {
		ms = new MStack<MStack<T>>();
		this.curStack = new MStack<T>();
		// ms.push(this.curStack);

	}

	public int size() {
		return this.currentIndex;
	}

	void setMaxSize(int max_size) {
		this.maxSize = max_size;
	}

	public void push(T o) {

		if (this.maxSize * this.curStackIndex >= this.currentIndex) {
			this.curStack.push(o);
			this.currentIndex++;
		} else {
			this.curStackIndex++;
			this.currentIndex++;
			ms.push(this.curStack);
			this.curStack = new MStack<T>();
		}
	}

	public T pop() {

		this.currentIndex--;
		if (this.currentIndex <= (this.maxSize * this.curStackIndex - 1)) {
			T object = this.curStack.pop();
			this.curStack = ms.pop();
			return object;
		} else {
			return this.curStack.pop();
		}
	}
}
