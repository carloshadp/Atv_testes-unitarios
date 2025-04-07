package org;

import java.util.*;

public class Aluguel {
    private String modelo;
    private double valorDiaria;
    private ArrayList<String> veiculosCaros = new ArrayList<>(List.of("Ferrari", "Lamborghini", "Porsche"));

    public Aluguel(String modelo, double valorDiaria) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("O valor da diária não pode ser negativo");
        }

        this.modelo = modelo;
        try {
            if (veiculosCaros.contains(modelo)) {
                this.valorDiaria = valorDiaria * 4.5;
            } else {
                this.valorDiaria = valorDiaria;
            }
        } catch (Exception e) {
            throw new RuntimeException("Deu xabu amigo", e);
        }
    }

    public String getModelo() {
        return this.modelo;
    }

    public double getValorDiaria() {
        return this.valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria < 0) {
            throw new IllegalArgumentException("O valor da diária não pode ser negativo");
        }
        this.valorDiaria = valorDiaria;
    }

    public double calcularCusto(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("A quantidade de dias deve ser maior que zero");
        }
        return this.valorDiaria * dias;
    }

    public double desconto(int dias) {
        double custo = calcularCusto(dias);
        double descontado = 0.10;
        if (dias >= 7) {
            return custo -= custo * descontado;
        }
        return custo;
    }

    public double calcularMulta(int diasAtraso) {
        if (diasAtraso < 0) {
            throw new IllegalArgumentException("Dias de atraso não podem ser negativos");
        }
        return diasAtraso * (valorDiaria * 1.5);
    }

    public double calcularDescontoProgressivo(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("A quantidade de dias deve ser maior que zero");
        }

        double desconto = 0;
        if (dias > 30) {
            desconto = 0.25;
        } else if (dias > 14) {
            desconto = 0.15;
        } else if (dias > 7) {
            desconto = 0.10;
        }
        return calcularCusto(dias) * (1 - desconto);
    }
}