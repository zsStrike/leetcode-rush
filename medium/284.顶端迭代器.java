import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	Queue<Integer> queue;
	int max;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iterator = iterator;
		this.queue = new LinkedList<>();
		this.max = 5;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (queue.isEmpty()) {
			while (iterator.hasNext() && queue.size() < max) {
				queue.offer(iterator.next());
			}
		}
		return queue.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!queue.isEmpty()) {
			return queue.poll();
		}
		return iterator.next();
	}
	
	@Override
	public boolean hasNext() {
	    return !queue.isEmpty() || this.iterator.hasNext();
	}
}
// @lc code=end

