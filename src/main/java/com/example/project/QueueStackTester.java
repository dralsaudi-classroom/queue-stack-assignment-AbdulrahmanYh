package com.example.project;

public class QueueStackTester {
    public static <T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq)
    {
        // Write the recursive static method split that splits a queue of n elements into two
        // queues. The elements with odd orders (i.e. 1st, 3rd, 5th ...) should be put in the
        // first queue and elements with even orders (i.e. 2nd, 4th, 6th ...) should be put in
        // the second queue. The original queue should remain unchanged at the end of the
        // method.
        // Example. Given the queue (A, B, C, D, E), split results in oq (A, C, E), and eq(B, D).
    	recsplit(q, oq, eq, q.length(), 1);

	}

	private static <T> void recsplit(Queue<T> q, Queue<T> oq, Queue<T> eq, int length, int pos) {
		if (pos > length)
			return;

		T e = q.serve();
		q.enqueue(e);
		if (pos % 2 == 1)
			if (!oq.full())
				oq.enqueue(e);
		if (pos % 2 == 0)
			if (!eq.full())
				eq.enqueue(e);
		recsplit(q, oq, eq, length, pos + 1);

	}    
    
    public static <T> void remove(LinkedPQ<T> pq, int p)
    {
      
        // Write a static method remove that removes every element in the priority queue
        // having priority less than p.
        // Example. Given pq: [A, 10], [D, 8], [B, 5], [E, 3], [C, 2] remove(pq, 5) results in
        // pq: [A, 10], [D, 8], [B, 5].
    	LinkedPQ<T> pq2 = new LinkedPQ<T>();
		int count = pq.length();
		for (int i = 0; i < count; i++) {
			PQElement<T> x = pq.serve();
			if (x.p >= p)
				pq2.enqueue(x.data, x.p);
		}
		int count2 = pq2.length();
		for (int j = 0; j < count2; j++) {
			PQElement<T> z = pq2.serve();
			pq.enqueue(z.data, z.p);
		}
}    
    
    public static <T> boolean search(Stack<T> st, T e)
    {
        // Write the recursive static method search that searches for an element e in a stack st
        // and returns true if it’s found or false otherwise. st should not change at the end of
        // the method. You are not allowed to use any auxiliary data structures.
        // Example. Given the stack st (top-to-bottom): 5, 7, 5, 3, 2. search(st, 3) returns
        // true while search(st, 1) returns false.
    
		return recsearch(st, e, false);

	}

	private static <T> boolean recsearch(Stack<T> st, T e, boolean found) {

		if (st.empty())
			return false;

		T x = st.pop();
		if (x == e) {
			st.push(x);
			return true;
		}
		found = recsearch(st, e, found);
		st.push(x);
		return found;

}    
    
}
