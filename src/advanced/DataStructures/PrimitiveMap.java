import java.util.*;
//made by Nihal Shivannagari (so it might not work)

//this is extremely primitive and isn't very spatially efficient
public class PrimitiveMap
{
	private int maximum;
	private int minimum;
	private int[] map;

	//gap between max value and min value must be under 2*10^9
	public PrimitiveMap(int maxValue,int minValue)
	{
		maximum=maxValue;
		minimum=minValue;
		map=new int[maximum-minimum+1];
	}

	//returns how many of this value there are
	public int contains(int value)
	{
		return map[value-minimum];
	}

	//can't add over 2*10^9 of the same value
	public  void add(int value)
	{
		map[value-minimum]++;
	}

	//will return how many of that value is left
	//if a value is removed when there is nothing there, nothing will happen
	public int remove(int value)
	{
		if(map[value-minimum]>0)
		{map[value-minimum]--;}
		return map[value-minimum];
	}
}