package GestaoInvestigacao;

public class MyCenter {

    public static void main(String[] args) {

        //Ã‰ instanciado um objeto do tipo Centro de InvestigaÃ§Ã£o

        CentroInvestigacao myCenter = new CentroInvestigacao();

        Integer opcao; //variÃ¡vel para a opção no menu


        do {

            System.out.print("Gestao Centro de Investigação:\n1 - Criar novo membro\n2 - Eliminar membro\n" +
                    "3 - Criar grupo de Invenstigação\n4 - Listar membros sem grupo\n5 - Definir diretor do centro\n6 - Associar membro Grupo\n7 - Sair\n");
            opcao=Menu.lerIntMsg("Escolha uma opção: ");

            switch(opcao)
            {
                case 1:
                    String tipo = Menu.lerStringMsg("Indique que tipo de membro deseja criar : \n I- Investigador\n P- Pós-Douturado\n A- Aluno de Doutoramento\n F- Funcionário");
                    String nome = Menu.lerStringMsg("Insira o seu nome");
                    String email = Menu.lerStringMsg("Insira o seu email");
                    String nomeTese=null;


                    // Se for investigador ou Pos doutorado ou aluno tem de inserir o nome da tese

                    if(tipo.equals("I") ||tipo.equals("i") || tipo.equals("P") || tipo.equals("p") || tipo.equals("A") || tipo.equals("a")) {
                    	nomeTese = Menu.lerStringMsg("Insira o nome da Tese");
                    }

                    if (tipo.equals("I") || tipo.equals("i"))
                    {
                        System.out.println("INVESTIGADOR");
                        // Ã© criado um objeto do tipo investigador (que recebe como paramentros nome, email e nome da tese)
                        Investigador investigador = new Investigador(nome,email, nomeTese);

                        //adiciona ao array investigador este membro
                        myCenter.adicionarMembro(investigador);
                    }
                      else if(tipo.equals("P") || tipo.equals("p"))
                        {
                            System.out.println("PÓS-DOUTORADO");
                            PosDoutorado pd = new PosDoutorado(nome, email, nomeTese);
                            myCenter.adicionarMembro(pd);
                        }
                        else if (tipo.equals("A") || tipo.equals("a"))
                            {
                                System.out.println("ALUNO DOUTORAMENTO");
                                AlunoDoutoramento ad = new AlunoDoutoramento(nome, email, nomeTese);

                                //adiciona ao array aluno doutorado este membro
                                myCenter.adicionarMembro(ad);
                            }

                    else
                            {
                                System.out.println("FUNCIONÁRIO");
                                Funcionario func = new Funcionario(nome, email);

                                //adiciona ao array funcionario este membro
                                myCenter.adicionarMembro(func);
                            }
                    break;

                case 2:

                    //declara uma string para saber o tipo que vai ser removido
                    String tipoRem = Menu.lerStringMsg("Indique que tipo de membro a remover : \n I- Investigador\n P- Pós-Douturado\n A- Aluno de Doutoramento\n F- Funcionário");
                    switch(tipoRem) {
                        case "i":
                        case "I":
                            //lista toodos os investigadores
                        	myCenter.listarInvestigadores();
                        	// o número respetivo pra identficar o investigador
                        	int invRem = Menu.lerIntMsg("Diga o numero do Investigador a remover: ");

                        	// Cria uma referência do tipo investigador
                            //vai buscar o número que foi escolhido e passa para o array

                            if (invRem >= myCenter.investigadores.size())
                            {
                                   System.out.println("O número de investigador que inseriu está incorreto ou não existe");
                                   break;

                            }


                            Investigador invRemObj = myCenter.investigadores.get(invRem);


                        	if(invRemObj.getGrupoInvestigacao()!=null) { // Remover o investigador do Grupo de investigacao
                        		invRemObj.getGrupoInvestigacao().membros.remove(invRemObj);
                        	}

                        	if(myCenter.diretor == invRemObj) // Se for o diretor remove a referencia do centro
                        		myCenter.diretor=null;


                        	break; 
                        	
                        case "p":
                        case "P":
                            //lista todos os pos doutorados
                        	myCenter.listarPosDoutorados();
                        	int pdRem = Menu.lerIntMsg("Diga o número do Pos Doutorado a remover: ");

                            if (pdRem >= myCenter.posdoutorados.size())
                            {
                                System.out.println("O número de Pós Doutorado que inseriu está incorreto ou não existe");
                                break;

                            }

                        	PosDoutorado pdRemObj = myCenter.posdoutorados.get(pdRem);
                        	if(pdRemObj.getGrupoInvestigacao()!=null) { // Remover o investigador do Grupo de investigacao
                        		pdRemObj.getGrupoInvestigacao().membros.remove(pdRemObj);
                        	}
                        	break; 
                        case "a":                      
                        case "A":                      
                        	myCenter.listarAlunosDoutoramento();
                        	int adRem = Menu.lerIntMsg("Diga o número do Aluno Doutoramento a remover: ");

                        	if (adRem <= myCenter.posdoutorados.size())
                            {
                        		System.out.println("O número de Aluno em Doutoramento que inseriu estÃ¡ incorreto ou nÃ£o existe");
                                break;
                            }

                        	AlunoDoutoramento adRemObj = myCenter.alunosdoutoramento.get(adRem);
                        	if(adRemObj.getGrupoInvestigacao()!=null) { // Remover o Aluno Doutoramento do Grupo de investigacao
                        		adRemObj.getGrupoInvestigacao().membros.remove(adRemObj);
                        	}
                        	break; 
                    }

                    break;

                case 3:
                	String strGrupo = Menu.lerStringMsg("Diga o nome do Grupo");
                	GrupoInvestigacao grupo = new GrupoInvestigacao(strGrupo);  // Perguntar nome do grupo
                    myCenter.adicionarGrupo(grupo); 
                    break;

                case 4:
                	myCenter.listarMembrosSemGrupo();
                    break;

                case 5:
                	myCenter.listarInvestigadores();
                	int invdir = Menu.lerIntMsg("Diga o numero do investigador diretor");
                	myCenter.diretor = myCenter.investigadores.get(invdir);
                    break;

                case 6:
                    // cria uma variável do tipo string pra apresentar um menu de escolha
                    String tipoAssoc = Menu.lerStringMsg("Indique que tipo de membro a Associar : \n I- Investigador\n P- PÃƒÂ³s-Douturado\n A- Aluno de Doutoramento\n F- FuncionÃƒÂ¡rio");
                    switch(tipoAssoc) {

                        // Se jÃ¡ pertencer a um grupo - if object != null

                        case "I":

                            //chama o mÃ©todo para listar todos os investigadores
                        	myCenter.listarInvestigadores();
                        	int invnum = Menu.lerIntMsg("Selecione o numero de um Investigador para associar um Grupo");

                        	//É criado uma referência para o tipo investigador pra poder remover o objeto especifico
                        	Investigador invObj = myCenter.investigadores.get(invnum);
                        	GrupoInvestigacao grupoAnterior = invObj.getGrupoInvestigacao();

                	        myCenter.listarGruposInvestigacao();
                	        int grpnum = Menu.lerIntMsg("Selecione o numero de um grupo para associar o investigador");

                	        // referência do tipo grupo investigação para saber a que grupo associar
                	        GrupoInvestigacao grpObj = myCenter.gruposInvestigacao.get(grpnum);


                	        if(grupoAnterior == null) { // Adiciona o investigador a um novo grupo
                	        	myCenter.adicionarMembroGrupo(invObj, grpObj);
                	        	System.out.println("Adicionado a um novo grupo");
                	        }
                	        else  // Muda o Investigador de Grupp
                	        {
                	        	myCenter.alterarMembroGrupo(invObj, grupoAnterior, grpObj);
                	        	System.out.println("Alterado para outro grupo");
                	        }
                            break;
                        case "P":
                            //chama o método para listar todos os Pos Doc
                            myCenter.listarPosDoutorados();
                            //Variável para ler a opção
                            int pnum = Menu.lerIntMsg("Selecione o numero de um Pos Doutorado para associar a um Grupo");

                            //objeto do tipo posdoutorado que depois vai receber o numero de index no array
                            PosDoutorado pObj = myCenter.posdoutorados.get(pnum);
                            GrupoInvestigacao grupopObjAnterior = pObj.getGrupoInvestigacao();
                            
                            //Lista os grupos de investigação disponiveis
                            myCenter.listarGruposInvestigacao();
                            
                            //variável para ler o numero do grupo para onde adicionar o objeto do tipo pos doutorado
                            int pgrpnum = Menu.lerIntMsg("Selecione o numero do grupo para associar um Pós Doutorado");

                            //Ã© criada uma variável do tipo GrupoInvestigacao que vai receber o numero do grupo
                            GrupoInvestigacao pgrpObj = myCenter.gruposInvestigacao.get(pgrpnum);
                            
                	        if(grupopObjAnterior == null) { // Adiciona o Pos Doc a um novo grupo
                	        	myCenter.adicionarMembroGrupo(pObj, pgrpObj);
                	        	System.out.println("Adicionado a um novo grupo");
                	        }
                	        else  // Muda o Pos Doc de Grupp
                	        {
                	        	myCenter.alterarMembroGrupo(pObj, grupopObjAnterior, pgrpObj);
                	        	System.out.println("Alterado para outro grupo");
                	        }
                        	break;
                        case "A":

                            myCenter.listarAlunosDoutoramento();
                            int anum = Menu.lerIntMsg("Selecione o numero de um Aluno em Doutoramento para associcar a um Grupo");

                            AlunoDoutoramento aObj = myCenter.alunosdoutoramento.get(anum);
                            GrupoInvestigacao grupoAAnterior = aObj.getGrupoInvestigacao();

                            myCenter.listarGruposInvestigacao();

                            int agrpnum = Menu.lerIntMsg("Selecione o numero do grupo para associar um Aluno em Doutoramento");

                            GrupoInvestigacao agrpObj = myCenter.gruposInvestigacao.get(agrpnum);

                            if(grupoAAnterior == null) { // Adiciona o AlunoDoutoramento a um novo grupo
                	        	myCenter.adicionarMembroGrupo(aObj, agrpObj);
                	        	System.out.println("Adicionado a um novo grupo");
                	        }
                	        else  // Muda o Aluno Doutoramento de Grupo
                	        {
                	        	myCenter.alterarMembroGrupo(aObj, grupoAAnterior, agrpObj);
                	        	System.out.println("Alterado para outro grupo");
                	        }
                            break;
                    }

                    break;

                case 7:

                    System.out.println("Obrigado pela utilização. Até breve !");
                    System.exit(0);
                    break;

                default:

                    System.out.println("Opção inválida !!!");
            }

        }while (opcao != 7);
    }
}
