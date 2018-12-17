/*
 * Name: Jorge Fernando Flores Pinto
 * ID: V00880059
 * 
 * This class PhoneNumberList creates a list of phone numbers, depending on how many
 * the user wants to add for a given contact.
 *
 */

public class PhoneNumberList
{
	private static final int INITIAL_SIZE = 2;

	private PhoneNumber[]	storage;
	private int		count;
	private int index;
	private int arraySize;

	//
	// Purpose:
	//	Initialize a new instance of PhoneNumberList
	//
	public PhoneNumberList()
	{
		count = 0;
		storage = new PhoneNumber[0];
		index = 0;
		arraySize = 0;
	}

	//
	// Purpose:
	// 	return the element at position index
	//
	// Pre-Conditions:
	// 	for a PhoneNumberList x:
	//	index >= 0 AND
	//	index < x.size()
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then:
	//	x.get(0) returns "Work:5551212"
	//	x.get(1) returns "Home:4441212"
	//	the result of calling x.get(3) is undefined
	//
	public PhoneNumber get (int index)
	{
		return storage[index];

	}

	//
	// Purpose:
	//	remove the element at position index
	//
	// Pre-Conditions:
	//	for a PhoneNumberList x:
	//		index >= 0 AND
	//		index < x.size()
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then
	//	after x.remove(0), x is {"Home:4441212", "Cell:3331212"}
	//
	public void remove (int index)
	{
		PhoneNumber[] storageCopy = storage.clone();
		storage = new PhoneNumber[count];
		for (int i = 0; i < (storageCopy.length - index - 1); i++) {
			storage[index] = storageCopy[index + 1];

		}
		count--;
	
	}

	//
	// Purpose:
	//	return the number of elements in the list
	//
	// Returns:
	//	the number of elements in the list
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212"}
	//	x.size() returns 2
	// If x is {}
	//	x.size() returns 0
	//
	public int size()
	{
		return count;
	}

	//
	// Purpose:
	//	add the phone number p to the list
	//
	// Comments:
	//
	//	The array you allocated to store PhoneNumbers might
	//	get full, but you are still required to add this
	//	PhoneNumber (until the JVM runs out of memory!)
	//
	//	This means that you should check to see if the array
	//	is currently full.  If it is, allocate a new array
	// 	that is twice as big, then copy the values over
	//	and update the storage reference to be the new array
	//	Finally, add the new PhoneNumber.
	//
	public void add (PhoneNumber p)
	{
		if(count == 0) {
			arraySize = INITIAL_SIZE;
			storage = new PhoneNumber[arraySize];
			storage[0] = p;
			count++;
		}
		else {
			if(count < arraySize) {
				storage[count] = p;
				count++;
			}
			else {
				PhoneNumber[] storageCopy = storage.clone();
				arraySize = arraySize * 2;
				storage = new PhoneNumber[arraySize];
				for (int i = 0; i < storageCopy.length; i++) {
					storage[i] = storageCopy[i];

				}
				storage[count] = p;
				count++;			
			}
		}
	}

	//
	// Purpose:
	//	return the index where p is in the list, -1 otherwise
	//
	// Pre-Conditions:
	//	none
	//
	// Returns:
	//	position of p in the list - an integer between 0 and size() - 1
	//	-1 if p is not in the list
	//
	// Examples:
	//
	// If x is {"Work:5551212", "Home:4441212", "Cell:3331212"} then
	//
	//	PhoneNumber p = new PhoneNumber("5551212");
	//	PhoneNumber q = new PhoneNumber("3331212");
	//	PhoneNumber r = new PhoneNumber("1234567");
	//
	// 	x.find(p) returns 0
	//	x.find(q) returns 2
	//	x.find(r) returns -1
	// 
	//
	public int find (PhoneNumber p)
	{
		boolean found = false;
		int position = 0;
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				if (storage[i].equals(p)) {
					found = true;
					break;
				}
				position++;
			}
		}
		if (found == false) {
			return -1;
		}
		return position;
	}

	//Down here is just for testing!
	/*public static void main(String[] args) {
		boolean passed = true;
		PhoneNumberList l = new PhoneNumberList();
		int	num = 5500000;
		String foo = "";
		for (int i = 0; i < 200; i++)
		{
			l.add(new PhoneNumber(Integer.toString(num+i)));
		}
		for (int i = (200 - 1); i > 0; i--)
		{
			PhoneNumber p = l.get(0);
			l.remove(0);

			if (l.find(p) != -1)
			{
				passed = false;
				foo = "-1";
				break;
			}

			if (l.size() != i)
			{
				passed = false;
				foo = "i" + i;
				break;
			}
		}
		System.out.println(passed);
		System.out.println(foo);
	}*/
}
