package GestaoInvestigacao;

import java.util.Date;

public class Funcionario extends Pessoa {

    Date datainicio;

    @Override
    String getType() {
        return "F";
    }

    public Funcionario(String nome, String email)
    {
    	// Inicializa os atributos de MembroGrupo
        super(nome, email);
     // Inicializa datas de inicio
        datainicio = new Date(); // Por omissao comeca na data corrente
    }
}
