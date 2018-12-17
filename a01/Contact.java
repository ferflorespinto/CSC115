/*
 * Name: Jorge Fernando Flores Pinto
 * ID: V00880059
 * 
 * This class Contact creates a contact with a list of phone numbers. The contact 
 * has a name, and a list of numbers. The class can also add and remove phone numbers
 * from the contact, by using methods from the class PhoneNumberList.
 *
 */

public class Contact
{
	private String name;
	private PhoneNumberList	numbers;
	
	// Purpose:
	//	initialize this instance of Contact
	// 	with no PhoneNumber
	//
	public Contact (String theName)
	{
		// You must allocate a PhoneNumberList here
		numbers = new PhoneNumberList();
		name = theName;


	}
	
	// Purpose:
	//	initialize this instance of Contact
	//	add p to the list of phone numbers associated with 
	//	this Contact
	//
	public Contact (String theName, PhoneNumber p)
	{
		numbers = new PhoneNumberList();
		if(numbers != null) {
			numbers.add(p);
			name = theName;

		}
	}

	// Purpose: 
	//	return the name associated with this instance
	//
	public String getName ()
	{
		return name;
	}

	// Purpose:
	//	change the name associated with this instance to be newName
	//
	public void setName(String newName)
	{
		name = newName;
	}

	// Purpose:
	//	add a new phone number to this contact
	//	there is no maximum number of phone numbers that can be
	//	assigned to a contact.
	//
	public void addNumber (PhoneNumber p)
	{
		numbers.add(p);
	}

	// Purpose:
	//	remove p from the list of PhoneNumbers associated with this contact
	//	if p is not in the list, do nothing.
	//
	public void removeNumber (PhoneNumber p)
	{
		int pos = numbers.find(p);
		if (pos != -1) {
			numbers.remove(pos);
		}
	}

	// Purpose:
	//	return the count of PhoneNumbers associated with this contact
	//
	public int getNumberCount()
	{
		return numbers.size();

	}
	
	// Purpose:
	//	return the phone at index pos from this contact
	//	
	// Pre-condition:
	//	pos >= 0 AND
	//	pos < this.getNumberCount()
	//
	public PhoneNumber getNumber (int pos)
	{
		return numbers.get(pos);
		// NOTE NOTE NOTE
		// 
		// This line needs to be removed.  It is only
		// so the tester works.  You should NOT
		// allocate a new PhoneNumber in this method
	}

	// Purpose:
	//	return a String representation of this contact	
	//
	public String toString()
	{
		String s = name;
		
		for (int i=0;i<numbers.size();i++)
		{
			s += "\n";
			s += numbers.get(i);
		}
		return s;
	}
	
	//Down here just for testing!
	/*public static void main(String[] args) {
		System.out.println("Testing Contact");
		PhoneNumber p1 = new PhoneNumber("5551212", "Work");
		PhoneNumber p2 = new PhoneNumber("7771212", "Home");
		PhoneNumber p3 = new PhoneNumber("8881212", "Cell");
		Contact c2 = new Contact("Susan Jones", p1);
		System.out.println(c2.getNumberCount());
		c2.removeNumber(p1);


	}*/
}
