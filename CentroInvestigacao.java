package GestaoInvestigacao;

import java.util.ArrayList;

public class CentroInvestigacao {

    //Objeto do tipo Investigador
    Investigador diretor;


    //Aqui é criado arrays para os vários membros
    
    ArrayList <Investigador> investigadores = new ArrayList<>();
    ArrayList <PosDoutorado> posdoutorados = new ArrayList<>();
    ArrayList <AlunoDoutoramento> alunosdoutoramento = new ArrayList<>();
    ArrayList <Funcionario> funcionarios = new ArrayList<>();

    //Array para grupo de investigação
    ArrayList <GrupoInvestigacao> gruposInvestigacao = new ArrayList<>();

    public void init()
    {


    }

    //métodos para adicionar membro, recebendo como parametro um objeto do tipo daquela classe
    public void adicionarMembro(Investigador I)
    {
        investigadores.add(I); // aqui passa o parametro que recebe la em cima e adiciona ao array investigadores
    }

    public void adicionarMembro(PosDoutorado P)
    {
        posdoutorados.add(P);
    }

    public void adicionarMembro(AlunoDoutoramento A)
    {
        alunosdoutoramento.add(A);
    }

    public void adicionarMembro(Funcionario F)
    {
        funcionarios.add(F);
    }

    public void adicionarGrupo(GrupoInvestigacao grupoInv)
    {
    	gruposInvestigacao.add(grupoInv);
    }
    
    public void listarMembrosSemGrupo() {

        //percorre o array investigadores
    	for(Investigador i: investigadores) {
    	    // se estiver nulo
    		if(i.getGrupoInvestigacao()==null)
    		    //Com o método get, acede aos elementos que estão sem grupo
    			System.out.println(i.getNome());
    	}
    	//perocrre array posdoutorados
    	for(PosDoutorado p: posdoutorados) {
    	    //Se algum elemento estiver nullo
    		if(p.getGrupoInvestigacao()==null)
    		    //Apresenta informação
    			System.out.println(p.getNome());
    	}
    	//Percorre arrray alunosdoutoramentos
    	for(AlunoDoutoramento a: alunosdoutoramento) {
    	    //se algum elemento estiver vazio
    		if(a.getGrupoInvestigacao()==null)
    		    //Apresenta dados
    			System.out.println(a.getNome());
    	}    }
    
    public void listarInvestigadores()
    {
        //Percorre o array investigadores até ao fim
    	for (int i=0; i<investigadores.size(); i++) {
    	    //Apresenta todos os investigadores existentes
    		System.out.println(i+" "+investigadores.get(i).getNome());
    	}
    }
    
    public void listarPosDoutorados()
    {
        //Percorre o array posdoutorados até ao fim
    	for (int i=0; i<posdoutorados.size(); i++) {
    	    //Apresenta todos os elementos existentes
    		System.out.println(i+" "+posdoutorados.get(i).getNome());
    	}
    }
    
    public void listarAlunosDoutoramento()
    {
        //Percorre o array investigadores até ao fim
    	for (int i=0; i<alunosdoutoramento.size(); i++) {
    	    //Apresenta todos os elementos existentes
    		System.out.println(i+" "+alunosdoutoramento.get(i).getNome());
    	}
    }
    
    public void listarGruposInvestigacao()
    {
        //Percorre o array gruposInvestigacao até ao fim
    	for (int i=0; i<gruposInvestigacao.size(); i++) {
    	    //Apresenta todos os elementos existentes
    		System.out.println(i+" "+gruposInvestigacao.get(i).getNome());
    	}
    }

    //adicionar membro a um grupo de investigação
    //Recebe como paramêtros. Um objeto do tipo MembroGrupo e GrupoInvestigacao
    //adiciona ao array membros o membro indicado por parametro
    //atualiza no grupo

    public void adicionarMembroGrupo(MembroGrupo membro, GrupoInvestigacao grupo)
    {
    	grupo.membros.add(membro);
    	membro.setGrupoInvestigacao(grupo);
    }

    //método responsável por remover um membro de um grupo
    //array membros e o membro indicado é eliminado
    //o membro indica depois é posto a null
    
    public void removeMembroGrupo(MembroGrupo membro, GrupoInvestigacao grupo) 
    {
    	grupo.membros.remove(membro);
    	membro.setGrupoInvestigacao(null);
    }
    
    public void alterarMembroGrupo(MembroGrupo membro, GrupoInvestigacao grupoAnterior, GrupoInvestigacao grupo) 
    {
    	grupoAnterior.membros.remove(membro); // Remove do grupo anterior
    	grupo.membros.add(membro);            // Adiciona ao grupo novo
    	membro.setGrupoInvestigacao(grupo);   // Actualiza membro com o novo grupo
    }

}
