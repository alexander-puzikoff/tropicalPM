package common;

import java.util.Arrays;

public class MStack<T> {
	@SuppressWarnings("unchecked")
	private T[] array = (T[]) new Object[4];
	private int current_index = 0;
	private int min_index = -1;

	public int size() {
		return this.current_index;
	}

	public void push(T o) {
		this.array[this.current_index] = o;
		this.current_index++;
		if (current_index >= this.array.length / 2) {
			this.array = Arrays.copyOf(this.array, this.array.length * 2);

		}
		// checking min
		if (o instanceof Number) {
			if (this.min_index == -1) {
				this.min_index = 0;
			} else {
				Number cur = (Number) this.array[this.min_index];
				Number newc = (Number) o;
				if (newc.doubleValue() < cur.doubleValue()) {
					this.min_index = this.current_index - 1;
				}
			}
		}
	}

	public T min() {
		if (current_index > 0) {
			return this.array[this.min_index];
		} else {
			return null;
		}
	}

	public T pop() {
		if (this.current_index >= 0) {
			T o = this.array[this.current_index];
			this.array[this.current_index] = null;
			this.current_index--;
			return o;
		} else {
			min_index = -1;
			return null;
		}
	}
}
