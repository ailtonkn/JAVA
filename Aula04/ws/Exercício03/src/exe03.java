import java.util.Scanner;

public class exe03 {
	
	
		/* 
		 * Exerc�cio de fixa��o 3
		 * 
		 * criar um programa para processar as seguintes informa��es de um aluno:matricula, nome ,nota 1 , nota2, nota 3, nota 4 e nota 5
		 * o sistema devera ler as notas do al�uno em um vetor e a entrada de dados pelo usuario s� podera ser nos valores de 0 a 10 
		 *  no final da execu��o imprimir o seguinte relat�rio:
		 *  Matr�cula: XXXXXX
		 *  Nome: xxx xxx
		 *  Nota (x): xxxxx
		 *  Nota (y): yyyyy
		 *  (...)
		 *
		 */
		
		
		public static void main(String[]args) {
			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Informe o Matr�cula:");
			String matricula = leitor.nextLine();
			
			System.out.println("Informe o nome:");
			String nome = leitor.nextLine();
			
			double[] notas = new double[5];
			
			int contador = 0;
			do {
				
				System.out.println("Informar uma nota entre 0 e 10.");
				System.out.println("Digite a " + (contador + 1) + "a nota");
				double temp = leitor.nextDouble();
										
				if (temp < 0 || temp <= 10) {
					
					System.out.println("A nota " + temp + " � inv�lida!");
					
					}else {
						notas [contador] = temp;
						contador++;
						}
					
				}while(contador < 5);
				System.out.println();
				System.out.println("-------------RELAT�RIO-----------");
				System.out.println("Matr�cula: " + matricula);
				System.out.println("Nome: " + nome);
				
				for(int i = 0; i < notas.length; i++) {
					
					
				}
		}
	

}
