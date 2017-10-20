
package desafio.poo.view;
import desafio.poo.controler.*;
import desafio.poo.model.*;

import com.restfb.BinaryAttachment;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;
public class Main {
	

	public static void main(String[] args) throws FileNotFoundException {
		Gerador_Grafico gerador = new Gerador_Grafico();
		Scanner input = new Scanner(System.in);
		int op = -1;
		int op2 = -1;
		int op3 = -1;
		
		while(op!=0) {
			menu1();
			op = input.nextInt();
			switch(op) {
			case 1:
				Leitura_CSV csv = new Leitura_CSV("doc//Vancouver.csv");
				
				while(op2!=0) {
					System.out.println("-------------");
					menu2();
					op2 = input.nextInt();
					switch(op2) {
					case 1:
						gerador.criarGraficoBarra(csv.retornarBairros());
						System.out.println("Gerando gráfico...");
						break;
					case 2:
						gerador.criarGraficoPizza(csv.retornarBairros());
						System.out.println("Gerando gráfico...");
						break;
					case 3:
						gerador.criarGrafico3D(csv.retornarBairros());
						System.out.println("Gerando gráfico...");
						break;
					case 0:
						break;
					default:
						System.out.println("Opção inválida");
						break;
					}
				
				}
				break;
			
			case 2:
				System.out.print("Digite o nome do arquivo CSV com o formato: (Não esqueça do caminho.)");
				System.out.print(">> ");
				String arq = input.next();
				Leitura_CSV csv2 = new Leitura_CSV(arq);
				while(op3!=0) {
					menu2();
					op3 = input.nextInt();
					switch(op3) {
					case 1:
						gerador.criarGraficoBarra(csv2.retornarBairros());
						System.out.println("Gerando gráfico...");
						break;
					case 2:
						gerador.criarGraficoPizza(csv2.retornarBairros());
						System.out.println("Gerando gráfico...");
						break;
					case 3:
						gerador.criarGrafico3D(csv2.retornarBairros());
						System.out.println("Gerando gráfico...");
						break;
					case 0:
						break;
					default:
						System.out.println("Opção inválida");
						break;
					}
				}
				
			case 0:
				System.out.println("Encerrando.");
				break;
			default:
				System.out.println("Opção inválida.");
						
			}
					
			break;		
		}
		Scanner sc = new Scanner(System.in).useDelimiter("\\n");
		
		System.out.println("Hora de compartilhar o gráfico... ");
		
		String caminho = "C:\\Users\\lucas\\eclipse-workspace\\Airbnb_GraphGenerator\\";
		
		String grafico = gerador.getarqg();
		
		System.out.println("Insira seu token de acesso ao facebook: ");
		String token = sc.next();
	
		System.out.println("Escreva seu post: ");
		String message = sc.next();
		
		System.out.println("Insira o ID do usuario que deseja marcar: ");
		String tagID = sc.next();
		
		System.out.println("Insira o nome do usuario que deseja marcar: ");
		String tagText = sc.next();
		
		System.out.println(caminho + grafico);
		FaceTag photoTag = new FaceTag(tagID, tagText);
		
		
		System.out.println("Postando...");
		Face.postarNoFb(token, caminho, grafico, message, photoTag);
		System.out.println("Encerrando Programa.");

		
}
	



public static void menu1() {
	System.out.println("Digite a sua opção: ");
	System.out.println("1 - utilizar CSV da cidade de Vancouver;");
	System.out.println("2 - utilizar CSV de outra cidade;");
	System.out.println("0 - sair.");
	System.out.print(">> ");
	
}


public static void menu2() {
	System.out.println("1 - Gerar gráfico de Barra;");
	System.out.println("2 - Gerar gráfico de pizza/torta;");
	System.out.println("3 - Gerar gráfico de Barra 3D;");
	System.out.println("0 - Sair.");
	System.out.print(">> ");
	
}



}