package br.nom.marcio.belo;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

public class FuncionarioTest
{

    @Test
    public void reajustarMensalistaTest()
    {
        Funcionario mensalista = new Mensalista("Marcio", new BigDecimal("120000"));
        mensalista.reajustar( new BigDecimal("5"));
        BigDecimal salarioAposReajuste = mensalista.getSalarioAnual();
        assertEquals( new BigDecimal( "126000.00"), salarioAposReajuste);
    }

    @Test(expected = IllegalArgumentException.class)
    public void reajustarMensalistaForaFaixaTest()
    {
        Funcionario mensalista = new Mensalista("Marcio", new BigDecimal("120000.00"));
        mensalista.reajustar( new BigDecimal("15"));
    }

    @Test
    public void reajustarBonificadoTest()
    {
        Funcionario bonificado = new Bonificado("Ana", new BigDecimal("80000.00") );
        bonificado.reajustar( BigDecimal.ONE);
        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual();
        assertEquals( new BigDecimal( "80800.00"), salarioAposReajuste);
    }

    @Test
    public void bonificarBonificadoTest()
    {
        Bonificado bonificado = new Bonificado("Ana", new BigDecimal("80000.00") );
        bonificado.acumularBonus( new BigDecimal("4000"));
        BigDecimal salarioAposReajuste = bonificado.getSalarioAnual();
        assertEquals( new BigDecimal( "84000.00"), salarioAposReajuste);
    }

    @Test
    public void testVoluntario()
    {
        Funcionario funcionario = new Voluntario("Leo", new BigDecimal("1000000"));
        assertEquals( new BigDecimal("0.00"), funcionario.getSalarioAnual());
    }
    
    @Test
    public void gerarFolhaDeGastosAnuaisTeste()
    {
    	Random random = new Random();
    	BigDecimal folha = new BigDecimal(0);
    	Integer acum = 0, salario;
    	List <Funcionario> funcionarios = new LinkedList<Funcionario>();
    	
    	salario = random.nextInt(100000);
    	Funcionario voluntario = new Voluntario("Leo", new BigDecimal(salario));
    	funcionarios.add(voluntario);
    	acum += salario;
    	
    	salario = random.nextInt(100000);
    	Funcionario bonificado = new Bonificado("Ana", new BigDecimal(salario));
    	funcionarios.add(bonificado);
    	acum += salario;
    	
    	salario = random.nextInt(100000);
    	Funcionario mensalista = new Mensalista("Marcio", new BigDecimal(salario));
    	funcionarios.add(mensalista);
    	acum += salario;
    	
    	for (Funcionario f : funcionarios)
    		folha = folha.add(f.getSalarioAnual());
    	
    	assertTrue( new BigDecimal(acum).compareTo(folha) == 0);
    }
}
