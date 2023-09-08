package com.utfpr;

import java.util.Random;

public class GenRandomNum 
{
	Random random = new Random();

	public int genNumb(int begin, int end)
	{
		return (int)this.random.doubles(begin, end).findAny().getAsDouble();
	}
}
