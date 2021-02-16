package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		String strpath = "D:\\Biblioteca\\Documentos\\Cursos Udemy\\Java Completo - Prof. Nélio Alves\\ExercicioPastas\\Dados.csv";
		List<Product> products = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(strpath))) {
			String line = br.readLine();

			while (line != null) {
				
				String[] vect = line.split(",");
				String name = vect[0];
				double unitPrice = Double.parseDouble(vect[1]);
				int quantity = Integer.parseInt(vect[2]);

				Product product = new Product(name, unitPrice, quantity);
				products.add(product);
				line = br.readLine();
			}
			
			File path = new File(strpath);
			String strpath2 = path.getParent();
			
			boolean success = new File(strpath2 + "\\out").mkdir();
			System.out.println("Diretório Criado: " + success);
			
			String path2 = strpath2+ "\\out\\summary.csv";
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
				
				for(Product p : products) {
					bw.write(p.toString2());
					bw.newLine();
					System.out.println(p.toString2());
				}
				
			}catch(IOException e) {
				e.printStackTrace();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
