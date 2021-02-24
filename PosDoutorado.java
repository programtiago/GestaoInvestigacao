package GestaoInvestigacao;

import java.util.Calendar;
import java.util.Date;

public class PosDoutorado extends MembroGrupo {


    private Date bolsaini; // data de inicio da bolsa
    private Date bolsafim; // data de fim da bolsa

    @Override
    String getType() {
        return "P";
    }

    //Construtor da classe

    public PosDoutorado(String nome, String email, String nomeTese) {
    	// Inicializa os atributos de MembroGrupo
        super(nome, email, nomeTese);
        // Inicializa datas de bolsa
        Calendar cal = Calendar.getInstance();
        bolsaini = cal.getTime(); // Bolsa comeca no dia corrente
        System.out.println(bolsaini);
        System.out.println(cal); 
        cal.add(Calendar.YEAR, 1); // Bolsa por omissao de 1 ano 
        bolsafim = cal.getTime();
        System.out.println(bolsafim);
    }
}
