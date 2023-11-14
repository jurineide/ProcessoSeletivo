package Candidaturas;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        selecaoCandidatos();
        imprimirSelecionados();
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA","PAULO","AUGUSTO"};
        for (String candidato:candidatos ) {
            entrandoContato(candidato);
        }

    }
    static void entrandoContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuaTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuaTentando = !atendeu;
            if (continuaTentando)
                tentativasRealizadas ++;
            else
                System.out.println("contato realizado com sucesso");

        }while (continuaTentando && tentativasRealizadas <3);
        if (atendeu)
            System.out.println("conseguimos contato com o candidato "+ candidato + "na "+ tentativasRealizadas + "tentativa");
        else
            System.out.println("não conseguimos contato ");

    }
    static boolean atender(){
        return new Random().nextInt(3)==1;
    }
    static void imprimirSelecionados(){
        String[] candidatos = {"FELIPE", "MARCIA", "JULIA","PAULO","AUGUSTO"};
        System.out.println("imprimindo a lista de candidatos informando o indice do elemento");
        for (int indice=0; indice< candidatos.length;indice++){
            System.out.println("o candidato de numero "+ (indice +1) + " é " + candidatos[indice]);
        }
        for (String candidato:candidatos) {
            System.out.println(" o candidato selecionado foi "+ candidato);
            
        }
    }
    static void selecaoCandidatos(){
        String [] candidatos={"FELIPE", "MARCIA","JULIA","PAULO","AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase= 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual<candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("o Candidato"+ candidato + "solicitou esse valor" + salarioPretendido);

            if(salarioBase >= salarioPretendido ){
                System.out.println("O candidato" + candidato + "foi selecionado para a vaga");
                candidatosSelecionados ++;
            }
            candidatoAtual++;
        }
    }
    static double valorPretendido(){

        return ThreadLocalRandom.current().nextDouble(1800,2200);
    }
    static void analisarCandidato (double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido) {
            System.out.println("Ligar para o Candidato");
        }else if (salarioBase==salarioPretendido) {
            System.out.println("Ligar para candidato com proposta");
        }else {
            System.out.println("Aguardar");
        }


    }
}
