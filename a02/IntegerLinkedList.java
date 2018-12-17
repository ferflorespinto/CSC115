/*
 * Name: Jorge Fernando Flores Pinto
 * ID: V00880059
 *
 * This class IntegerLinkedList creates a list of integers using double-link references.
 *
 */

public class IntegerLinkedList implements IntegerList
{
	private int count;
	private IntegerNode head;
	private IntegerNode tail;

	public IntegerLinkedList()
	{

	}

	/*
	 * PURPOSE:
	 *   Add the element x to the front of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addFront(9) returns, then l is {9,1,2,3}.
	 * If l is {} and l.addFront(3) returns, then l is {3}.
	 */
	public void addFront (int x)
	{
		IntegerNode n = new IntegerNode(x);
		if (count == 0) {
			head = n;
			tail = n;
			n.prev = null;
		}
		else {
			head.prev = n;
			n.next = head;
			head = n;
			n.prev = null;

		}
		count++;
	}


	/*
	 * PURPOSE:
	 *   Add the element x to the back of the list.
	 *
	 * PRECONDITIONS:
	 *   None.
	 *
	 * Examples:
	 *
	 * If l is {1,2,3} and l.addBack(9) returns, then l is {1,2,3,9}.
	 * If l is {} and l.addBack(9) returns, then l is {9}.
	 */
	public void addBack (int x)
	{
		IntegerNode n = new IntegerNode(x);
		if (count == 0) {
			head = n;
			tail = n;
			n.prev = null;
		}
		else {
			IntegerNode p = tail;
			p.next = n;
			n.prev = p;
			tail = n;

		}
		count++;
	}

	/*
	 * PURPOSE:
	 *   Add the element x at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for addAt are
	 *   0, 1, 2, 3.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos <= l.size()
	 *
	 * Examples:
	 *
	 * If l is {} and l.addAt(9,0) returns, then l is {9}.
	 * If l is {1} and l.addAt(9,0) returns, then l is {9,1}.
	 * If l is {1,2} and l.addAt(9,1) returns, then l is {1,9,2}
	 * If l is {1,2} and l.addAt(9,2) returns, then l is {1,2,9}
	 */
	public void addAt (int x, int pos)
	{
		IntegerNode n = new IntegerNode(x);
		if (count == 0) {
			head = n;
			tail = n;
			n.prev = null;
			count++;
		}
		else if (pos == 0) {
			addFront(x);

		}
		else if (pos == count) {
			n.prev = tail;
			tail.next = n;
			tail = n;
			count++;
		}
		else {
			IntegerNode cur = head;
			for (int i = 0; i < pos; i++) {
				cur.prev = cur;
				cur = cur.next;

			}
			IntegerNode p = cur.prev;
			p.next = n;
			n.prev = p;
			n.next = cur;
			count++;
		}
	}

	/*
	 * PURPOSE:
	 *	Return the number of elements in the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {7,13,22} l.size() returns 3
	 *	If l is {} l.size() returns 0
	 */
	public int size()
	{
		return count;
	}

	/*
	 * PURPOSE:
	 *   Return the element at position pos in the list.
	 *
	 * PRECONDITIONS:
	 *	pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *	If l is {67,12,13} then l.get(0) returns 67
	 *	If l is	{67,12,13} then l.get(2) returns 13
	 *	If l is {92} then the result of l.get(2) is undefined.
	 *
	 */
	public int  get (int pos)
	{
		IntegerNode cur = head;
		if(pos < count) {
			if (pos == count - 1) {
				return tail.value;

			}
			else if (pos == 0) {
				return head.value;

			}
			else {
				for (int i = 0; i < pos; i++) {
					if (cur.next != null) {
						cur = cur.next;
					}
				}
				return cur.value;
			}
		}

		return -1;
	}

	/*
	 * PURPOSE:
	 *   Remove all elements from the list.  After calling this
	 *   method on a list l, l.size() will return 0
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13} then after l.clear(), l is {}
	 *	If l is {} then after l.clear(), l is {}
	 *
	 */
	public void clear()
	{
		head = null;
		tail = null;
		count = 0;
	}

	/*
	 * PURPOSE:
	 *   Remove all instances of value from the list.
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {67,12,13,12} then after l.remove(12), l is {67,13}
	 *	If l is {1,2,3} then after l.remove(2), l is {1,3}
	 *	If l is {1,2,3} then after l.remove(99), l is {1,2,3}
	 */
	public void remove (int value)
	{
		IntegerNode c = head;
		int check = 0;
		//check is the number of times 'value' is in the list
		while (c.next != null) {
			if(c.value == value) {
				check++;
			}
			c = c.next;

		}
		for (int i = 0; i <= check; i++) {
			IntegerNode n = head;
			while (n.next != null) {
				if(n.value == value) {
					break;
				}
				n = n.next;
			}
			if (n.value == value) {
				if(count != 1) {
					if(n.equals(head)) {
						if (n.next != null) {
							head = n.next;
							head.prev = null;
							count--;
						}

					}
					else if(n.equals(tail)) {
						tail = n.prev;
						tail.next = null;
						count--;
					}
					else {
						IntegerNode q = n.next;
						IntegerNode p = n.prev;
						q.prev = p;
						p.next = q;
						count--;
					}
				}
				else {
					head = null;
					tail =  null;
					count--;
				}
			}				
		}
	}

	/*
	 * PURPOSE:
	 *   Remove the element at position pos in the list.
	 *
	 * Note:
	 *   In a list with 3 elements, the valid positions for removeAt are
	 *   0, 1, 2.
	 *
	 * PRECONDITIONS:
	 *   pos >= 0 and pos < l.size()
	 *
	 * Examples:
	 *
	 * If l is {1} and l.removeAt(0) returns, then l is {}.
	 * If l is {1,2,3} and l.removeAt(1) returns, then l is {1,3}
	 * If l is {1,2,3} and l.removeAt(2) returns, then l is {1,2}
	 */
	public void removeAt (int pos)
	{

		if (head == null) {
			return;
		}
		else if (count != 1) {
			if (pos == 0) {
				head = head.next;
				head.prev = null;
				count--;
			}

			else if (pos < count - 1) {
				IntegerNode prev = head;
				IntegerNode curr = head;
				for (int i = 0; i < pos; i++) {
					prev = curr;
					curr = curr.next;

				}
					prev.next = curr.next;
					curr = curr.next;
					curr.prev = prev;
					count--;
			}
			else if (pos == (count - 1)) {
				IntegerNode p = tail.prev;
				tail = p;
				tail.next = null;
				tail.prev = p.prev;
				count--;
			}
		}
		else {
			head = null;
			tail = null;
			count--;
		}		

	}


	/*
	 * PURPOSE:
	 *	Return a string representation of the list
	 *
	 * PRECONDITIONS:
	 *	None.
	 *
	 * Examples:
	 *	If l is {1,2,3,4} then l.toString() returns "{1,2,3,4}"
	 *	If l is {} then l.toString() returns "{}"
	 *
	 */
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		IntegerNode p = head;
		sb.append("{");
		while(p != null) {
			sb.append(p.value);
			if (p.next != null) {
				sb.append(",");
			}
			p = p.next;
		}
		sb.append("}");
		return sb.toString();
	}
}
