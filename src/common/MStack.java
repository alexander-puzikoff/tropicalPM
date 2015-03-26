package common;

public class MStack {
	Object[] array = new Object[4];
	int current_index = 0;
	int min_index = 0;

	public int size() {
		return this.current_index;
	}

	public void push(Object o) {
		this.array[this.current_index] = o;
		this.current_index++;
	}

	public Object min() {
		if (current_index > 0) {
			return this.array[this.min_index];
		} else {
			return null;
		}
	}

	public Object pop() {
		if (this.current_index >= 0) {
			Object o =this.array[this.current_index];
			this.array[this.current_index] = null;
			this.current_index--;
			return o;
		} else {
			return null;
		}
	}
}
