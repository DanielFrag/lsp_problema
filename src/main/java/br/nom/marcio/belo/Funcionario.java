package br.nom.marcio.belo;

import java.math.BigDecimal;

public abstract class Funcionario
{
    private String nome;
    private BigDecimal salarioAnual;

    protected Funcionario(String nome, BigDecimal salarioAnual) {
        this.nome = nome;
        this.salarioAnual = salarioAnual;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalarioAnual() {
        return salarioAnual;
    }

    /**
     * Taxa percentual na qual o sal�rio anualizado ser� reajustado
     * @param taxa valor maior que 0 e menor ou igual a 10.
     */
    public abstract void reajustar( BigDecimal taxa);

    /**
     *
     * @return
     */
    public abstract BigDecimal pagar();
}
