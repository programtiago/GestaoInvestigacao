package GestaoInvestigacao;

import java.util.Date;

public class Investigador extends MembroGrupo {

    private Date datainicio;
    private String titulotese;

    @Override
    String getType() {
        return "I";
    }

    public Investigador(String nome, String email, String nomeTese)
    {
    	// Inicializa os atributos de MembroGrupo
        super(nome, email, nomeTese);
        // Inicializa datas de inicio
        datainicio = new Date(); // Por omissao comeca na data corrente
    }


}
