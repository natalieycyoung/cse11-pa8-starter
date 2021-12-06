import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Point
{
	int x, y;
	
	Point(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	
	double distance(Point other)
	{
		return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
	}
}

class PointCompare implements Comparator<Point>
{
	public int compare(Point point1, Point point2)
	{
		if (point1.y < point2.y)
		{
			return -1;	// point1 smaller than point2
		}
		else if (point1.y > point2.y)
		{
			return 1;	// point1 greater than point2
		}
		else
		{
			if (point1.x < point2.x)
			{
				return -1;	// point1 smaller than point2
			}
			else if (point1.x > point2.x)
			{
				return 1;	// point1 greater than point2
			}
			else
			{
				return 0;	// point1 same as point2
			}
		}
	}
}

class PointDistanceCompare implements Comparator<Point>
{
	public int compare(Point point1, Point point2)
	{
		Point origin = new Point(0, 0);
	
		if (point1.distance(origin) < point2.distance(origin))
		{
			return -1;
		}
		else if (point1.distance(origin) == point2.distance(origin))
		{
			return 0;
		}
		else
		{
			return 1;
		}
	}
}

class StringCompare implements Comparator<String>
{
	public int compare(String string1, String string2)
	{
		return string1.compareTo(string2);
	}
}

class StringLengthCompare implements Comparator<String>
{
	public int compare(String string1, String string2)
	{
		if (string1.length() < string2.length())
		{
			return -1;
		}
		else if (string1.length() > string2.length())
		{
			return 1;
		}
		else
			return 0;
	}
}

class BooleanCompare implements Comparator<Boolean>
{
	public int compare(Boolean bool1, Boolean bool2)
	{
		if ((bool1 == false) && (bool2 == true))
		{
			return -1;
		}
		else if ((bool1 == true) && (bool2 == false))
		{
			return 1;
		}
		else
			return 0;
	}
}

class ComparatorTests
{
	PointCompare pc = new PointCompare();
	PointDistanceCompare pdc = new PointDistanceCompare();
	StringCompare sc = new StringCompare();
	StringLengthCompare slc = new StringLengthCompare();
	BooleanCompare bc = new BooleanCompare();

	Point point1 = new Point(0, 0);
	Point point2 = new Point(0, 2);
	Point point3 = new Point(2, 0);
	Point point4 = new Point(0, 0);

	// PointCompare
	void testPointCompare(Tester t)
	{
		t.checkExpect(pc.compare(point1, point2), -1);
		t.checkExpect(pc.compare(point1, point3), -1);
		t.checkExpect(pc.compare(point2, point1), 1);
		t.checkExpect(pc.compare(point2, point3), 1);
		t.checkExpect(pc.compare(point1, point4), 0);
	}
	
	// PointDistanceCompare
	void testPointDistanceCompare(Tester t)
	{
		t.checkExpect(pdc.compare(point1, point2), -1);
		t.checkExpect(pdc.compare(point1, point3), -1);
		t.checkExpect(pdc.compare(point2, point1), 1);
		t.checkExpect(pdc.compare(point2, point3), 0);
		t.checkExpect(pdc.compare(point1, point4), 0);
	}
	
	String string1 = "lorem";
	String string2 = "ipsum";
	String string3 = "dolor";
	String string4 = "sit";
	String string5 = "amet";
	String string6 = "lorem";
	
	// StringCompare
	void testStringCompare(Tester t)
	{
		t.checkExpect(sc.compare(string1, string2), 3);
		t.checkExpect(sc.compare(string1, string3), 8);
		t.checkExpect(sc.compare(string2, string1), -3);
		t.checkExpect(sc.compare(string4, string1), 7);
		t.checkExpect(sc.compare(string6, string1), 0);
	}
	
	// StringLengthCompare
	void testStringLengthCompare(Tester t)
	{
		t.checkExpect(slc.compare(string1, string2), 0);
		t.checkExpect(slc.compare(string1, string3), 0);
		t.checkExpect(slc.compare(string2, string5), 1);
		t.checkExpect(slc.compare(string4, string1), -1);
		t.checkExpect(slc.compare(string6, string1), 0);
	}

	boolean bool1 = false;
	boolean bool2 = true;
	boolean bool3 = false;
	
	// BooleanCompare
	void testBooleanCompare(Tester t)
	{
		t.checkExpect(bc.compare(bool1, bool2), -1);
		t.checkExpect(bc.compare(bool2, bool1), 1);
		t.checkExpect(bc.compare(bool1, bool3), 0);
		t.checkExpect(bc.compare(bool2, bool3), 1);
	}
}

class CompareLists<E>
{
	E element;

/*
	CompareLists(E element)
	{
		this.element = element;
	}
*/
	/**
	 * Takes List<E> and Comparator<E>, returns smallest element in
	 * list according to comparator or null if empty list; assume
	 * no null elements in list.
	 *
	 * @param list
	 * @param comparator
	 * @return minimum
	 */
	public static <E> E minimum (List<E> list, Comparator<E> comparator)
	{ 
//		System.out.println(list.get(0).getClass().getName() + " = " + list.get(0));

		E minimum = list.get(0);

		if (list.size() == 0)
		{
			return null;
		}

		for (E item : list)
		{
			if (item.compare(minimum))
			{
				minimum = item;
			}
		}

		return minimum;
	}

	public static void main(String args[])
	{
		String lorem = "lorem";
		String dolor = "dolor";

		System.out.println(lorem.compareTo(dolor));
		System.out.println(dolor.compareTo(lorem));

		Point point1 = new Point(0,0);
		Point point2 = new Point(1,1);
		CompareLists<Point> obj = new CompareLists<Point>();

		System.out.println(obj);


		List<Point> list = new ArrayList();
		//Comparator<Point> comparator = new Comparator();
		list.add(point1);
		list.add(point2);

//		minimum (list, );
	}
}
