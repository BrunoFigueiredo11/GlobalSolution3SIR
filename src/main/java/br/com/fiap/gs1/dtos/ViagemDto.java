package br.com.fiap.gs1.dtos;

import java.text.DecimalFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.fiap.gs1.models.Viagem;

public class ViagemDto {
	@NotBlank(message = "A data de decolagem não pode estar em branco!")
	@NotNull
	private String dataDecolagem;

	private String dataRetorno;

	private int duracaoEstadia;

	private int assentosDisp;
	@NotBlank(message = "O modelo da nave não pode estar em branco!")
	@NotNull
	@Pattern(regexp ="^[a-zA-Z]{4}\\-[0-9]{4}$", message = "Formato invalido Ex. aaaa-9999" )
	private String modeloNave;
	@NotBlank(message = "Insira o nome do primeiro comandante!")
	@NotNull
	private String primeiroComand;
	@NotBlank(message = "Insira a matricula do primeiro comandante!")
	@Pattern(regexp ="^[a-zA-Z]{3}\\-[0-9]{4}\\-[a-zA-Z]{1}+[0-9]+[a-zA-Z]{1}$", message = "Formato invalido Ex. XXX-9999-X9X" )
	@NotNull
	private String matriPrimComand;
	@NotBlank(message = "Insira o nome do segundo comandante!")
	@NotNull
	private String segundoComand;
	@NotBlank(message = "Insira a matricula do segundo comandante!")
	@Pattern(regexp ="^[a-zA-Z]{3}\\-[0-9]{4}\\-[a-zA-Z]{1}+[0-9]+[a-zA-Z]{1}$", message = "Formato invalido Ex. XXX-9999-X9X" )
	@NotNull
	private String matriSegunComand;

	public String getDataRetorno() {
		return dataRetorno;
	}

	public void setDataRetorno(String dataRetorno) {
		this.dataRetorno = dataRetorno;
	}

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

	public void fromViagem(Viagem viagem) {
		String dia = viagem.getDataDecolagem().substring(0, 2);
		String mes = viagem.getDataDecolagem().substring(3, 5);
		String ano = viagem.getDataDecolagem().substring(6, 10);
		this.dataDecolagem = ano + "-" + mes + "-" + dia;
		this.duracaoEstadia = viagem.getDuracaoEstadia();
		this.assentosDisp = viagem.getAssentosDisp();
		this.modeloNave = viagem.getModeloNave();
		this.primeiroComand = viagem.getPrimeiroComand();
		this.matriPrimComand = viagem.getMatriPrimComand();
		this.segundoComand = viagem.getSegundoComand();
		this.matriSegunComand = viagem.getMatriSegunComand();

	}

	// RECEBE A QUANTIDADE DE DIAS DE VIAGEM + DIAS DE HOSPEDAGEM EM MARTE, E FAZ O CALCULO PARA PROJETAR A DATA DE RETORNO.
	public String calculaData(Viagem viagem) {
	
		int dia = Integer.parseInt(viagem.getDataDecolagem().substring(0, 2));
		int mes = Integer.parseInt(viagem.getDataDecolagem().substring(3, 5));
		int ano = Integer.parseInt(viagem.getDataDecolagem().substring(6, 10));
		for (int dias = (520 + viagem.getDuracaoEstadia()); dias > 0;) {
			int fev = 28;
			if ((ano % 4) == 0) {
				fev = 29;
			}
			if (mes == 01 || mes == 03 || mes == 05 || mes == 07 || mes == 8 || mes == 10 || mes == 12) {
				if (dia <= 31) {
					if (dias > 0) {
						if ((dias - (31 - dia)) > 0) {
							dias = dias - (31 - dia);
							if (dias > 0) {
								dia = 01;
								dias--;
								mes++;
							} else if (dias == 0) {
								dia = dia + dias;
								dias = 0;
							}
						} else {
							dia = dia + dias;
							dias = 0;
						}

					} else {
						break;
					}

				}
			} else if (mes == 02) {
				if (dia <= fev) {
					if (dias > 0) {
						if ((dias - (fev - dia)) > 0) {
							dias = dias - (fev - dia);
							if (dias > 0) {
								dia = 01;
								dias--;
								mes++;
							} else if (dias == 0) {
								dia = dia + dias;
								dias = 0;
							}
						} else {
							dia = dia + dias;
							dias = 0;
						}

					} else {
						break;
					}

				}
			} else if (mes == 04 || mes == 06 || mes == 9 || mes == 11) {
				if (dia <= 30) {
					if (dias > 0) {
						if ((dias - (30 - dia)) > 0) {
							dias = dias - (30 - dia);
							if (dias > 0) {
								dia = 01;
								dias--;
								mes++;
							} else if (dias == 0) {
								dia = dia + dias;
								dias = 0;
							}
						} else {
							dia = dia + dias;
							dias = 0;
						}

					} else {
						break;
					}

				}
			}
			if (mes > 12) {
				ano++;
				mes = 01;
			}

		}
		DecimalFormat data = new DecimalFormat("00");
		return ano + "-" + data.format(mes) + "-" + data.format(dia);

	}

}
