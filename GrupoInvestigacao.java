package GestaoInvestigacao;

import java.util.ArrayList;
import java.util.List;

public class GrupoInvestigacao {

	private String nome;
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private Investigador coordenadorGrupo; //objeto do tipo Investigador

	//Array list para os membros do grupo
	List<MembroGrupo> membros = new ArrayList<MembroGrupo>();
	
	public GrupoInvestigacao(String nome) {
		this.nome = nome;
	}

	//método pra definir coordenador
	
	public void definirCoordenador(Investigador coordenador) {
		coordenadorGrupo = coordenador;
	}
	
	public void adicionarMembro(Investigador inv) {
		membros.add(inv);
	}


}
