/**Exerc�cio de fixa��o 1
 * 
 * Criar um programa para processar as seguintes
 * informa��es de umn aluno: matr�cula, nome, nota1, nota2 




*/

public class Programa { //inic�o Programa
	
	public static void main (String[] args) { // inic�o main
		
		String matr�cula = "1234";
		String nome = "Ailton Soares";
		double nota1 = 7.5;
		double nota2 = 6.9;
		double notaFinal = (nota1 + nota2) / 2;
		
		//igual ou superior 6
		if(notaFinal >= 6){
			System.out.println("Matr�cula: " + matr�cula); // concatena��o
			System.out.println("Nome: " + nome);
			System.out.println("Aprovado: (x) Sim ( ) N�o");
			System.out.println("Nota final: " + notaFinal);
			
		} else {
			
			System.out.println("Matr�cula: " + matr�cula); // concatena��o
			System.out.println("Nome: " + nome);
			System.out.println("Aprovado: ( ) Sim (x) N�o");
			System.out.println("Nota final: " + notaFinal);
			
		}
		
	} // fim main

} // fim Programa
