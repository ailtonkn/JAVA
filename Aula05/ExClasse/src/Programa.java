import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Programa {
			//Aluno aluno1 = new Aluno();
			//aluno1.matricula = "12345";
			//aluno1.nome = "Ailton";
			//aluno1.nota1 = 7.87;
			//aluno1.nota2 = 7.5;
			//aluno1.nota3 = 6.87;
			
			//Aluno aluno2 = new Aluno();
			//aluno2.matricula = "070707";
			//aluno2.nome = "Ton";
			//aluno2.nota1 = 7.66;
			//aluno2.nota2 = 6.58;
			//aluno2.nota3 = 8.57;

	public static void main(String[] args) throws FileNotFoundException {
		
		
		//String texto = "texto";
		
		File arquivo = new File("C:\\sw\\ws\\ExClasse\\src\\alunos.csv");
		Scanner leitor = new Scanner(arquivo);
		
		
		
		Aluno[] alunos = new Aluno[5];
		
		while(leitor.hasNext()) {
			
			
			String linha = leitor.nextLine();
			String [] dados = linha.split(";");
			String matricula = dados[0];
			String nome = dados[1];
			String nota1 = dados[2];
			String nota2 = dados[3];
			String nota3 = dados[4];
			
			Aluno aluno = new Aluno();
			aluno.matricula = matricula;
			aluno.nome = nome;
			aluno.nota1 = Double.parseDouble(nota1);
			aluno.nota2 = Double.parseDouble(nota2);
			aluno.nota3 = Double.parseDouble(nota3);
			
			
			
			alunos[contador] = aluno;
			contador++;
			
		
			
			
		}
		
		
		
		for (int i = 0; i < alunos.length; i++) {
			Aluno a = alunos[i];
			System.out.println("Matrícula: " + a.matricula);
			System.out.println("Nome: " + a.nome);
			System.out.println("Nota 1: " + a.nota1);
			System.out.println("Nota 2: " + a.nota2);
			System.out.println("Nota 3: " + a.nota3);
			System.out.println();
		}
		
		leitor.close();

	}

}
