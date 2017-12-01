package utils;

import java.io.File;

public class pruebas {

	public static void main(String[] args) {
		
		File file = new File("C:\\Users\\Admin\\Pictures\\background-faded-stains-light-3840x2400.jpg");
		System.out.println(new Metodos().getLongfile(file) > 500);
		
	}

}
