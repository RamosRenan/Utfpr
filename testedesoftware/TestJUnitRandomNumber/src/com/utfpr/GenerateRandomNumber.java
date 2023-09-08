package com.utfpr;

import java.util.Random;

public class GenerateRandomNumber 
{	
	GenRandomNum g;
	
	public static void main(String[] args) 
	{

	}
	
	public GenerateRandomNumber()
	{
		this.g = new GenRandomNum();
	}
	
	public GenerateRandomNumber(GenRandomNum g)
	{
		this.g = g;
	}
	
	public int nextRandomNumber(int begin, int end)  
	{
		int d = 0;
		
		if(isIntervalValid(begin, end))
			d = this.g.genNumb(begin, end);
		
		System.out.println(">>>> d: "+d);

		return -1;
	}
	
	public boolean isIntervalValid(int begin, int end)
	{
		if(begin < 0 || end < 0)
			throw new IntervaloInvalidoException("begin é menor que zero");
		
		if(end < begin)
			throw new IntervaloInvalidoException("argumentos inválidos, final é menor que o valor inicial");
		else 
			return true;
	}
}
