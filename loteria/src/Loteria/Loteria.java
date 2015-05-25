package loteria;

import java.io.*;

public abstract class loteria {
	String directorio;
	String loteria;
	File[] archivos;
	
	public loteria(String loteria, String directorio){
		File f = new File(directorio);
		System.out.println(f.getAbsolutePath());
		archivos = f.listFiles();
	}
	
	abstract void premios();
	abstract void leer_archivo();
	
	public static void main(String [] args){
		// System.out.print("Holi =)");
		
	}
}
