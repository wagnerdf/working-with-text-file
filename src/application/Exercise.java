package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

/**
 *     Fazer um programa para ler o caminho de um arquivo .csv
 * contendo os dados de itens vendidos. Cada item possui um 
 * nome, preço unitário e quantidade, separado por vírgula. Você
 * deve gerar um novo arquivo chamado "summary.csv", localizado
 * em uma subpasta chamada "out" a partir da pasta original do
 * arquivo de origem, contendo apenas o nome e o valor total para
 * aquele item (preço unitário multiplicado pela quantidade),
 * conforme exemplo.
 * 
 * ***** SOURCE FILE:*******
 * TV LED,1290.99,1
 * Video Game Chair,350.50,3
 * iPhone X,900.00,2
 * Samsung Galaxy 9,850.00,2
 * 
 * 
 *  ****** OUTPUT FILE (out/summary.csv)*******
 *  TV LED,1290.99
 *  Video Game Chair,1051.50
 *  iPhone X,1800.00
 *  Samsung Galaxy 9,1700.00
 * 
 * @author Wagner (Prof. Nelio Alves)
 * 
 */


public class Exercise {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String sourceFileStr = sc.nextLine();

		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))) {

			String itemCsv = br.readLine();
			while (itemCsv != null) {

				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				itemCsv = br.readLine();
			}

			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))) {

				for (Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}

		sc.close();
	}
}