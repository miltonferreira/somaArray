package soma.application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		//lerScanner(sc); // ler informacoes do Scanner
		
		//lerArquivo("c:\\temp\\soma.txt", 10, 10); // ler informacoes de arquivo txt

		sc.close();
	}
	
	public static void lerScanner(Scanner sc) {
		
		System.out.println("Insira o tamanho de linhas: ");
		int l = sc.nextInt();
		
		System.out.println("Insira o tamanho de colunas: ");
		int c = sc.nextInt();
		
		int[][] mat = new int[l][c];

		double soma = 0.0;
		
		//Informação <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
		// mat.length percorre a linha da matriz
		// mat[i].length percorre a coluna da matriz

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				System.out.println("Insira o numero na Linha: " + i + " Coluna " + j);
				mat[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				soma += mat[i][j];
			}
		}

		System.out.println("Total: " + soma);
		
	}
	
	// path é o caminho do arquivo no windows, l = linha c = coluna
	public static void lerArquivo(String path, int l, int c) {
		
		int index = 0;	//percorre o array que recebe as informacoes lidas do arquivo
		double soma = 0.0; //faz soma total dos valores dos arrays
		int[][] mat = new int[l][c];

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {

				String[] fields = line.split(",");
				
				for (int i = 0; i < mat.length; i++) {
					for (int j = 0; j < mat[i].length; j++) {
						
						mat[i][j] = (int) Double.parseDouble(fields[index]);
						index ++;
					}
				}
				
				line = br.readLine(); // ler a proxima linha de informacoes
			}
			
			for (int i = 0; i < mat.length; i++) {
				for (int j = 0; j < mat[i].length; j++) {
					soma += mat[i][j];
				}
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		System.out.println("Total: " + soma);
		
	}

}
