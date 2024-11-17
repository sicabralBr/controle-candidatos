import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {

//        analisarCadastro(1900.00);
//        analisarCadastro(3000.00);
//        analisarCadastro(2000.00);
//        selecaoCandidatos();
//        imprimirListaSelecionados();
        contatoCandidato();
    }

    static void contatoCandidato(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        boolean ligacao = atender();

        for (String candidatoLigacao: candidatos){

            for (int tentativas = 0; tentativas < 3; tentativas++) {

                if (ligacao) {
                    System.out.println("Conseguimos contato com " + candidatoLigacao + " após " + (tentativas + 1) + " tentativa(s).");
                    break;
                }else if (tentativas == 2){
                    System.out.println("Não conseguimos contato com " + candidatoLigacao + ", número máximo de tentativas " + (tentativas + 1) + ".");
                    ligacao = atender();
                }

            }
        }
    }

    static  double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800.00, 2200.00);
    }

    static boolean atender(){
        return new Random().nextInt(3) == 1;
    }

    static void analisarCadastro(double salarioPretendido){
        double salarioBase = 2000.00;

        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato com a contra proposta.");
        }
        else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para o candidato com a contra proposta.");
        }
        else {
            System.out.println("Aguardando o resultado dos demais candidatos.");
        }
    }

    static void selecaoCandidatos(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.00;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou o valor de R$ " + salarioPretendido);

            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato +" foi selecionado para a vaga.");
                candidatosSelecionados ++;
            }
            candidatoAtual ++;
        }
    }

    static void imprimirListaSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento.");

        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("Candidato de número " + (indice + 1) + " é candidato: " + candidatos[indice] + ".");
        }

        for (String candidato: candidatos){
            System.out.println("O candidato selecionado foi: " + candidato);
        }
    }
}