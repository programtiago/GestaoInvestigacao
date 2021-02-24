package GestaoInvestigacao;

import java.util.Date;

//package GestaoInvestigacao;

public class AlunoDoutoramento extends MembroGrupo {

    String titulotese;
    private Date bolsaini; // data de inicio da bolsa opcional
    private Date bolsafim; // data de fim da bolsa opcional

    @Override
    String getType() {
        return "A";
    }

    public AlunoDoutoramento(String nome, String email, String nomeTese)
    {
    	// Inicializa os atributos de MembroGrupo
        super(nome, email, nomeTese);
        bolsaini = null;
        bolsafim = null;
    }
}
