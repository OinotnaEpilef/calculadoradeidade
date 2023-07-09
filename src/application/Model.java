/**
 * 
 */
package application;

import java.time.LocalDate;

/**
 * @author Felip
 *
 */
public class Model {
	private int diaNascimento;
	private int mesNascimento;
	private int anoNascimento;
	private int idade;
	
	public int getDiaNascimento() {
		return diaNascimento;
	}
	public void setDiaNascimento(int diaNascimento) {
		this.diaNascimento = diaNascimento;
	}
	public int getMesNascimento() {
		return mesNascimento;
	}
	public void setMesNascimento(int mesNascimento) {
		this.mesNascimento = mesNascimento;
	}
	public int getAnoNascimento() {
		return anoNascimento;
	}
	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Model(String dia, String mes, String ano) {
		this.diaNascimento = Integer.parseInt(dia);
		this.mesNascimento = Integer.parseInt(mes);
		this.anoNascimento = Integer.parseInt(ano);		
	}
	
	public void calcule() {
		LocalDate dataAtual = LocalDate.now();
		int anoAtual = dataAtual.getYear();
		int mesAtual = dataAtual.getMonthValue();
		int diaAtual = dataAtual.getDayOfMonth();
		if (this.mesNascimento > mesAtual) {
			this.setIdade(anoAtual- this.anoNascimento - 1);
		} else if (this.mesNascimento < mesAtual) {
			this.setIdade(anoAtual - this.anoNascimento);
		} else {
			if (this.diaNascimento > diaAtual) {
				this.setIdade(anoAtual - this.anoNascimento -1);
			} else {
				this.setIdade(anoAtual - this.anoNascimento);
			}
		}
	}
	
}
