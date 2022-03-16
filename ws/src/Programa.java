/**Exercício de fixação 1
 * 
 * Criar um programa para processar as seguintes
 * informações de umn aluno: matrícula, nome, nota1, nota2 




*/

public class Programa { //inicío Programa
	
	public static void main (String[] args) { // inicío main
		
		String matrícula = "1234";
		String nome = "Ailton Soares";
		double nota1 = 7.5;
		double nota2 = 6.9;
		double notaFinal = (nota1 + nota2) / 2;
		
		//igual ou superior 6
		if(notaFinal >= 6){
			System.out.println("Matrícula: " + matrícula); // concatenação
			System.out.println("Nome: " + nome);
			System.out.println("Aprovado: (x) Sim ( ) Não");
			System.out.println("Nota final: " + notaFinal);
			
		} else {
			
			System.out.println("Matrícula: " + matrícula); // concatenação
			System.out.println("Nome: " + nome);
			System.out.println("Aprovado: ( ) Sim (x) Não");
			System.out.println("Nota final: " + notaFinal);
			
		}
		
	} // fim main

} // fim Programa
