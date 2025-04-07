package org;

public class VeiculoTest {
    public static void main(String[] args) {
        System.out.println("Testando meus aluguéis, Avante Palestra! ");

        //_______________________Alugando Onix ________________________________________________
        Aluguel onix = new Aluguel("Onix", 150.0);
        System.out.println("Modelo: " + onix.getModelo());
        System.out.println("Diária: R$" + onix.getValorDiaria());


        System.out.println("Custo normal: R$" + onix.calcularCusto(3));
        System.out.println("Com desconto: R$" + onix.desconto(3));


        System.out.println("Custo normal: R$" + onix.calcularCusto(10));
        System.out.println("Com desconto: R$" + onix.desconto(10));
        System.out.println("Desconto progressivo: R$" + onix.calcularDescontoProgressivo(10));

        //_______________________Alugando Ferrari ________________________________________________

        Aluguel ferrari = new Aluguel("Ferrari", 1000.0);
        System.out.println("Modelo: " + ferrari.getModelo());
        System.out.println("Diária com multiplicador: R$" + ferrari.getValorDiaria());

        System.out.println("Aluguel de 2 Days:");
        System.out.println("Custo normal: R$" + ferrari.calcularCusto(2));
        System.out.println("Multa por 3 dias atraso: R$" + ferrari.calcularMulta(3));

        System.out.println("Recalculando");
        onix.setValorDiaria(180.0);
        System.out.println("Nova diária: R$" + onix.getValorDiaria());
        System.out.println("Custo por 5 dias: R$" + onix.calcularCusto(5));

        System.out.println("Descontos progressivos");
        System.out.println("8 dias: R$" + onix.calcularDescontoProgressivo(8));
        System.out.println("15 dias: R$" + onix.calcularDescontoProgressivo(15));
        System.out.println("31 dias: R$" + onix.calcularDescontoProgressivo(31));

    }
}