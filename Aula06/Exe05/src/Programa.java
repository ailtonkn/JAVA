import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) throws FileNotFoundException {
		
		File arquivo = new File("C:\\Users\\Ailton\\Desktop\\curso em video Java\\ws-ter-noi-main-Ex05\\Ex05\\src\\grupos-tabulados.txt");
		Scanner leitor = new Scanner(arquivo);
		leitor.nextLine(); //descartar o titulo
		
		
		int grupoA = 0;
		int grupoB = 0;
		int grupoC = 0;
		int grupoD = 0;
		int grupoE = 0;
		int grupoF = 0;
		
		
		
		while(leitor.hasNext()) {
			String linha = leitor.nextLine();
		
			String[] dadosLinha = linha.split("\t");
			
			switch (dadosLinha[0]) {
			
			case "A":
				grupoA += getValor(dadosLinha[1]);
				break;
			case "B":
				grupoB += getValor(dadosLinha[1]);
				break;
			case "C":
				grupoC += getValor(dadosLinha[1]);
				break;
			case "D":
				grupoD += getValor(dadosLinha[1]);
				break;
			case "E":
				grupoE += getValor(dadosLinha[1]);
				break;
			case "F":
				grupoF += getValor(dadosLinha[1]);
				break;
			}
		}
				
		imprimirGrupo("A", grupoA);
		imprimirGrupo("B", grupoB);
		imprimirGrupo("C", grupoC);
		imprimirGrupo("D",grupoD);
		imprimirGrupo("E", grupoE);
		imprimirGrupo("F", grupoF);
		
		int total = grupoA + grupoB + grupoC + grupoD + grupoE + grupoF;
		System.out.println("Valor total: "+ total);
		
		
		
		leitor.close();

	}

	

	private static int getValor(String vlr) {
		
		
		return Integer.parseInt(vlr);
	}
	
	public static void imprimirGrupo(String letra, int vlr) {
		System.out.println("Valor total do grupo "+letra+": "+vlr);
		
	}

}

