package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class BlancoEspineiraSaul_Excepcion4 {

	public static void crearFichero1() throws IOException {
		//declaramos un objeto File...
		File fichero = new File("C:\\ej2016\\ejemplo.txt");
		//...y creamos el fichero asociado
		fichero.createNewFile();
	}
	
	public static void crearFichero2() throws IOException {
		//declaramos un objeto File...
		File fichero = new File("C:\\ej2016\\ejemplo.txt");
		//...y creamos el fichero asociado
		fichero.createNewFile();
		
	}
	
	public static void main(String[] args) {
		try {
			crearFichero1();
		} catch (IOException e) {
			try {
				
				e.printStackTrace(new PrintStream(new FileOutputStream("error.log",true)));
				} catch (FileNotFoundException e1) {
				
				System.out.println(e.getMessage());
				}
			System.out.println(e.getMessage());
		}
		
		try {
			crearFichero2();
		} catch (IOException e) {
			try {
			e.printStackTrace(new PrintStream(new FileOutputStream("error.log",true)));
			} catch (FileNotFoundException e1) {
			
			System.out.println(e1.getMessage());
			}
			System.out.println(e.getMessage());
		}
	}
}
