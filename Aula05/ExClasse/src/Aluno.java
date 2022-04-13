
public class Aluno {

	public String matricula;
	public String nome;
	public double nota1;
	public double nota2;
	public double nota3;
	public double getNotaFinal() {
		// TODO Auto-generated method stub
		return (nota1 + nota2 + nota3) / 3;
	}

}
