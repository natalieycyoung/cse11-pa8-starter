import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;
import java.lang.Math.*;

class CompareDoubles implements Comparator<Double>
{
	public int compare(Double n, Double m)
	{
		if (n > m)
		{
			return 1;
		}
		else if (m > n)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}

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
		double distance1 = Math.sqrt(Math.pow(point1.x, 2) + Math.pow(point1.y, 2));	// abs()?
		double distance2 = Math.sqrt(Math.pow(point2.y, 2) + Math.pow(point2.y, 2));	// abs()?
	
		if (distance1 < distance2)
		{
			return -1;
		}
		else if (distance1 == distance2)
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
	{}
}
