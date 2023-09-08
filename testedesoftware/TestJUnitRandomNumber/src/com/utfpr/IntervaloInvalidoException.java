package com.utfpr;

public class IntervaloInvalidoException extends IllegalArgumentException
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7894911124200431511L;

	
	public IntervaloInvalidoException(String msn)
	{
		super(msn);
	}
	
	@Override
	public String toString() {
		return "O intervalo numérico gerado não é valido ";
	}
}// class
