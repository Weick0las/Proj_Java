package candidatura;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) {
        ArrayList<String> selecionados = selecaoCandidatos();
        imprimirSelecionados(selecionados);
        for(int indice=0; indice < selecionados.size(); indice++){
            entrandoEmContato(selecionados.get(indice));
        }    
    }
    
    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando){
                tentativasRealizadas++;
            }
            else{
                System.out.println("Contato realizado com sucesso");
            }
        } while(continuarTentando && tentativasRealizadas <3);

        if(atendeu){
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        }
        else{
            System.out.println("Não conseguimos contato com " + candidato + "," + "tentativas realizadas = " + tentativasRealizadas);
        }
    }


    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(ArrayList<String> selecionados){
        for(int indice=0; indice < selecionados.size(); indice++){
            System.out.println((indice+1) + " - " + selecionados.get(indice));
        }
    }

    

    static ArrayList<String> selecaoCandidatos(){
        String candidatos[] = {"Felipe", "Marcia", "Julia", "Paulo", "Augusto", "Monica", "Fabricio", "Mirela", "Daniela", "Jorge", "Gabriel", "Luciano", "Pedro", "Matias", "Stephany", "Nickolas", "Eleanor", "Babi", "Elena", "Nathan", "Samara", "Jailson", "Felipe", "Arthur", "Victoria", "Gabriela", "Wagner", "Lucca", "Lucas", "João"};
        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        ArrayList<String> selecionados = new ArrayList<String>();
        while(candidatosSelecionados < 5 && candidatoAtual < candidatos.length){
            
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();
            //System.out.println("O candidato " + candidato + " solicitou este valor de salário " + salarioPretendido);

            if(salarioBase >= salarioPretendido){
                //System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                selecionados.add(candidato);
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
        return selecionados;
    }
    
    
    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    
    
    static void analisarCandidato(double salarioPretendido){
        double salarioBase = 2000.0;
        if(salarioBase > salarioPretendido){
            System.out.println("Ligar para o candidato");
        }
        else if(salarioBase == salarioPretendido){
            System.out.println("Ligar para o candidato com contra proposta");
        }
        else{
            System.out.println("Aguardando resultado dos demais candidatos");
        }
    }
}
