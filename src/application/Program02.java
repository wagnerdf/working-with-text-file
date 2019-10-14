package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

	public class Program02 {
		
		public static void main(String[] args) {
		
		String path = "c:\\Temp\\ino.txt";
		FileReader fr = null;
		BufferedReader br = null;
		
	
		try
		{
			fr = new FileReader(path);      // referenciando o arquivo para leitura
			br = new BufferedReader(fr);    //Referencia o arquivo no BufferedReader deixando mais rapido a leitura
			
			String line = br.readLine();
	
			while (line != null) {          //Percorre todo arquivo
				System.out.println(line);   
				line = br.readLine();
			}
		}
		catch(IOException e){
			System.out.println("Error: " + e.getMessage());
		}
		finally{
			try {
				if (br != null) {
					br.close();
				}
				if (fr != null) {
					fr.close();
				}
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
