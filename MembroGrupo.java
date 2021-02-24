package GestaoInvestigacao;

public abstract class MembroGrupo extends Pessoa {

	//Atributos necessários da classe

	String nomeTese; //nome da tese
	private GrupoInvestigacao grupoInvestigacao; //cria um objeto do tipo GrupoInvestigação

	//Construtor da classe

	public MembroGrupo(String nome, String email, String nomeTese) {
		// Inicializa atributos de Pessoa
		super(nome, email);
		//Inicializa Titulo de tese
		this.nomeTese = nomeTese;
		// Inicializa grupoInvestigacao
		grupoInvestigacao = null;
	}

	public String getNomeTese() {
		return nomeTese;
	}

	public void setNomeTese(String nomeTese) {
		this.nomeTese = nomeTese;
	}

	public GrupoInvestigacao getGrupoInvestigacao() {
		return grupoInvestigacao;
	}

	public void setGrupoInvestigacao(GrupoInvestigacao grupoInvestigacao) {
		this.grupoInvestigacao = grupoInvestigacao;
	}
	
}
