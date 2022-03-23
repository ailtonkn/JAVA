import java.util.Scanner;

public class exe04 {
	
	
		/* 
		 * Exercício de fixação 4
		 * 
		 * criar um programa para processar as seguintes informações de um aluno:matricula, nome ,nota 1 , nota2, nota 3, nota 4 e nota 5
		 * o sistema devera ler as notas do alçuno em um vetor e a entrada de dados pelo usuario só podera ser nos valores de 0 a 10 
		 *  no final da execução imprimir o seguinte relatório:
		 *  Matrícula: XXXXXX
		 *  Nome: xxx xxx
		 *  Nota (x): xxxxx
		 *  Nota (y): yyyyy
		 *  (...)
		 *
		 */
		
		
		public static void main(String[]args) {
			
			Scanner leitor = new Scanner(System.in);
			
			System.out.println("Informe o Matrícula:");
			String matricula = leitor.nextLine();
			
			System.out.println("Informe o nome:");
			String nome = leitor.nextLine();
			
			double[] notas = new double[5];
			
			double[] peso = {0.05, 0.05, 0.2, 0.2, 0.5};
			
			
			
			
			
			
			
			
			int contador = 0;
			do {
				
				System.out.println("Informar uma nota entre 0 e 10.");
				System.out.println("Digite a " + (contador + 1) + "a nota");
				double temp = leitor.nextDouble();
										
				if (temp >= 0 && temp <= 10 ) {
					
					notas [contador] = temp;
					contador++;
					
					
					
					}else {
						
						System.out.println("A nota " + temp + " é inválida!");
						
						}
					
				}while(contador < 5);
			
				 double notaFinal  = (notas[0]*peso[0]) + (notas[1]*peso[1])+ (notas[2]*peso[2])+ (notas[3]*peso[3])+ (notas[4]*peso[4]);
				 
				System.out.println();
				System.out.println("-------------RELATÓRIO-----------");
				System.out.println("Matrícula: " + matricula);
				System.out.println("Nome: " + nome);
				System.out.println("Nota Final: " + notaFinal);
				if (notaFinal >= 6) {
					System.out.println("Aprovado");
				}else {
					System.out.println("Reprovado");

				}
				for(int i = 0; i < notas.length; i++) {
					
					
				}
		}
	

}