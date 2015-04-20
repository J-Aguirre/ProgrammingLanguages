package loteria;

import java.io.*;

public class loteria {
	String directorio;
	String loteria;
	
	public loteria(String loteria, String directorio){
		File f = new File(directorio);
		System.out.println(f.getAbsolutePath());
	}
	
	public static void main(String [] args){
		// System.out.print("Holi =)");
		loteria lot = new loteria("Quina", "Apuestas");
		
		
	}
}
