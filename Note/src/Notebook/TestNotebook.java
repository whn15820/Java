package Notebook;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestNotebook {

	@Test
	public void testtoString(){
		Notebook notebook =new Notebook("red",2);
		System.out.println(notebook.toString());
		
	}

}
