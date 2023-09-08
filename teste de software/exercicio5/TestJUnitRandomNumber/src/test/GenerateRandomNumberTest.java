package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.utfpr.GenRandomNum;
import com.utfpr.GenerateRandomNumber;
import com.utfpr.IntervaloInvalidoException;

public class GenerateRandomNumberTest 
{
	Random ran = null;
	
	GenerateRandomNumber genRanNumb = null;
	
	@BeforeEach
	public void instatiations()
	{
		genRanNumb = new GenerateRandomNumber();
		ran = new Random();
	}
	
	/**
	 * Responsável por verificar se o intervalo é válido
	 */
	@Test
	public void verifyRandomNumIsValidTest()
	{
		assertTrue(genRanNumb.isIntervalValid(5, 205));
	}
	
	/**
	 * Responsavel por verificar exceção quando o intervalo for inválido
	 */
	@Test
	public void verifyExceptionRandomNumIsValidTest()
	{
		assertThrows(IntervaloInvalidoException.class, ()->{
			genRanNumb.isIntervalValid(205, 5);
		});
	}
	
	/**
	 * Responsavel por verificar intervalo válido entre dois inteiros
	 */
	@Test
	public void verifyNextRandomNumber()
	{
		GenRandomNum genRandomNum =  mock(GenRandomNum.class);
		
		this.genRanNumb = Mockito.spy(new GenerateRandomNumber(genRandomNum));
		
		when(genRandomNum.genNumb(10, 30)).thenReturn(19);
		
		int resp = this.genRanNumb.nextRandomNumber(10, 30);
		
		verify(this.genRanNumb).isIntervalValid(10, 30);
		
		assertEquals(resp, -1);
	}
	
}// GenerateRandomNumberTest
