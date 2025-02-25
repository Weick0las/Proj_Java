package CorrentePoupanca;

import java.util.Scanner;

abstract class Conta {
    protected double saldo; 

    
    public Conta(double saldo) {
        this.saldo = saldo;
    }

    
    public abstract void sacar(double valor);

    
    public void exibirSaldo() {
        System.out.printf("Saldo Atual: %.2f%n", saldo);
    }
}


class ContaCorrente extends Conta {
    private double limite; 
        
    public ContaCorrente(double saldo, double limite) {
        super(saldo);
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando o saldo e o limite:
        // Dica: Se saldo - valor >= -limite, o saque é permitido.
        if(saldo - valor >= -limite){
            saldo = saldo - valor;
            System.out.printf("Saque realizado: %.2f%n", valor);
        }
        else{
            System.out.println("Saque invalido: Excede limite");
        }

        exibirSaldo(); // Exibe o saldo atualizado
    }
}


class ContaPoupanca extends Conta {

    public ContaPoupanca(double saldo) {
        super(saldo);
    }

    // Implementação do método sacar para Conta Poupança
    @Override
    public void sacar(double valor) {
        // TODO: Implemente a lógica para verificar se o saque é permitido considerando apenas o saldo:
        // Dica: Se saldo >= valor, o saque é permitido.
        if(saldo >= valor){
            saldo = saldo - valor;
        }
        else{
            System.out.println("Saque invalido: Saldo insuficiente"); 
        }

        exibirSaldo(); // Exibe o saldo atualizado
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tipoConta = scanner.next(); 
        scanner.nextLine(); 
        scanner.nextLine(); 
        scanner.next(); 
        double saldoInicial = scanner.nextDouble(); 
        
        Conta conta;

        // TODO: Implemente a lógica para criar uma instância de ContaCorrente ou ContaPoupanca:
        // Dica: Use um if para verificar o tipo da conta.
        if(tipoConta.equalsIgnoreCase("Corrente")){
            double limite = scanner.nextDouble();
            conta = new ContaCorrente(saldoInicial, limite);
        }
            // TODO: Para Conta Corrente, leia também o limite de cheque especial e crie a instância.
            
        else{
            conta = new ContaPoupanca(saldoInicial);
        }
  
            // TODO: Para Conta Poupança, apenas inicialize a conta com o saldo inicial:
        

        while (scanner.hasNextDouble()) {
            double valorSaque = scanner.nextDouble(); 
            conta.sacar(valorSaque); 
        }

        scanner.close(); 
    }
}
