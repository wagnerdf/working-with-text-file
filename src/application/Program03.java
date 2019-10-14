package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Program03 {

	public static void main(String[] args) {
		
		String[] lines = new String[] {"Good morning","Good afternoon","Good night"};
		
		String path = "c:\\Temp\\out.txt";
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){   //O path sendo true não sera crido novo arquivo, o texto sera criado abaixo do arquivo se o mesmo não existir ao executar sequidas vezes
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
			catch(IOException e ) {
				e.printStackTrace();
			}
	}
}
