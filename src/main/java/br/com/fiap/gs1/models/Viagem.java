package br.com.fiap.gs1.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Viagem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String dataDecolagem;
	private int duracaoEstadia;
	private int assentosDisp;
	private String modeloNave;
	private String primeiroComand;
	private String matriPrimComand;
	private String segundoComand;
	private String matriSegunComand;

	public Viagem() {

	}


	public Viagem(Long id, String dataDecolagem, int duracaoEstadia, int assentosDisp, String modeloNave,
			String primeiroComand, String matriPrimComand, String segundoComand, String matriSegunComand) {
		super();
		this.id = id;
		this.dataDecolagem = dataDecolagem;
		this.duracaoEstadia = duracaoEstadia;
		this.assentosDisp = assentosDisp;
		this.modeloNave = modeloNave;
		this.primeiroComand = primeiroComand;
		this.matriPrimComand = matriPrimComand;
		this.segundoComand = segundoComand;
		this.matriSegunComand = matriSegunComand;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getDataDecolagem() {
		String ano = dataDecolagem.substring(0,4);
		String mes = dataDecolagem.substring(5,7);
		String dia = dataDecolagem.substring(8,10);
		return dia+"/"+mes+"/"+ano;
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
