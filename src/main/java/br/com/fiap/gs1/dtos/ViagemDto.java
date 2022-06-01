package br.com.fiap.gs1.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ViagemDto {
	@NotBlank
	@NotNull
	private String dataDecolagem;
	@NotBlank
	@NotNull
	private int duracaoEstadia;
	@NotBlank
	@NotNull
	private int assentosDisp;
	@NotBlank
	@NotNull
	private String modeloNave;
	@NotBlank
	@NotNull
	private String primeiroComand;
	@NotBlank
	@NotNull
	private String matriPrimComand;
	@NotBlank
	@NotNull
	private String segundoComand;
	@NotBlank
	@NotNull
	private String matriSegunComand;
	
	public String getDataDecolagem() {
		return dataDecolagem;
	}
	public void setDataDecolagem(String dataDecolagem) {
		this.dataDecolagem = dataDecolagem;
	}
	public int getDuracaoEstadia() {
		return duracaoEstadia;
	}
	public void setDuracaoEstadia(int duracaoEstadia) {
		this.duracaoEstadia = duracaoEstadia;
	}
	public int getAssentosDisp() {
		return assentosDisp;
	}
	public void setAssentosDisp(int assentosDisp) {
		this.assentosDisp = assentosDisp;
	}
	public String getModeloNave() {
		return modeloNave;
	}
	public void setModeloNave(String modeloNave) {
		this.modeloNave = modeloNave;
	}
	public String getPrimeiroComand() {
		return primeiroComand;
	}
	public void setPrimeiroComand(String primeiroComand) {
		this.primeiroComand = primeiroComand;
	}
	public String getMatriPrimComand() {
		return matriPrimComand;
	}
	public void setMatriPrimComand(String matriPrimComand) {
		this.matriPrimComand = matriPrimComand;
	}
	public String getSegundoComand() {
		return segundoComand;
	}
	public void setSegundoComand(String segundoComand) {
		this.segundoComand = segundoComand;
	}
	public String getMatriSegunComand() {
		return matriSegunComand;
	}
	public void setMatriSegunComand(String matriSegunComand) {
		this.matriSegunComand = matriSegunComand;
	}

	
}
