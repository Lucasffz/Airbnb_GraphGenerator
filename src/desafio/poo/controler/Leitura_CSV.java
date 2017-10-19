package desafio.poo.controler;
import desafio.poo.model.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Leitura_CSV {
	private String linha = "";	
	private String arqCSV;
	private BufferedReader conteudo = null;
	private ArrayList<String[]> c = new ArrayList<String[]>();
	private ArrayList<Bairro> bairros = new ArrayList<Bairro>();
	 
	
	
	public Leitura_CSV(String arqCSV){
		int xxx = 0;
		this.arqCSV = arqCSV;
		try {
			conteudo = new BufferedReader(new FileReader(arqCSV));
			while((linha = conteudo.readLine())!= null) {
				xxx++;
				char linhaC[] = linha.toCharArray();
				ArrayList<String> conteudos = new ArrayList<String>();
				String celula = "";
				boolean inQuotes = false;

				for (int i = 0; i < linhaC.length; i++) {
					char cc = linhaC[i];

					if (!inQuotes) {
						if (cc == ',') {
							conteudos.add(celula);
							celula = "";
						} else if (cc == '\"') {
							inQuotes = !inQuotes;
						} else {
							celula += cc;
						}
					} else {
						if (cc == '\"') {
							inQuotes = !inQuotes;
						} else {
							celula += cc;
							if (i == linhaC.length-1) {
								if ((linha = conteudo.readLine()) != null) {
									i = -1;
									linhaC = linha.toCharArray();
									continue;
								}
							}
						}
					}
				}
				String arr[] = new String[conteudos.size()];
				conteudos.toArray(arr);
				c.add(arr);
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList retorneC() {
		return c; 
	}
	
	public ArrayList<Bairro> retornarBairros() {
		try {
		for (int i = 1; i < c.size(); i++) {
			
			
			
			Bairro[] b = new Bairro[c.size()];
			if(bairros.isEmpty()) {
				
				
				b[i] = new Bairro(c.get(i)[5],1);
				this.bairros.add(b[i]);
				
				
			}
			else {
				
				boolean encontrado = false;
				for (int j = 0; j < bairros.size(); j++) {
					
					if(bairros.get(j)== null) {
						break;
					}
					else {
						if(bairros.get(j).getNome().equalsIgnoreCase(c.get(i)[5])) {
							
							int x = bairros.get(j).getQuantidade();
							bairros.get(j).setQuantidade(x+1);
							encontrado = true;
							
							break;
						}
					
					
					
					}
				}
				if(!encontrado) {
						b[i] = new Bairro(c.get(i)[5],1);
						this.bairros.add(b[i]);
					
				}
				
			}
				
			}
		}
		
		catch(java.lang.ArrayIndexOutOfBoundsException e) {
			
		}
		return bairros;
		}
	
	
	
		
	
		
}


		

