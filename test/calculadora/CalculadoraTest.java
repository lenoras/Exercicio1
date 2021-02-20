
lenora
14 de fev. de 2021 09:57 (há 6 dias)
para mim

package calculadora;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Classe para teste da calculadora")
public class CalculadoraTest {

private Calculadora calc;

@BeforeEach
public void inicializa() {
calc = new Calculadora();
}

@DisplayName("Testa a comparacao de dois numeros")
@Test
public void testComparaDoisNumerosIguais () {
int compIguais = calc.compara(1, 1);
Assertions.assertEquals(0, compIguais);
}

@Test
public void testComparaPrimMaiorSegundo () {
int compPrimMaior = calc.compara(1, 0);
Assertions.assertEquals(1, compPrimMaior);
}

@Test
public void testComparaPrimMenorSegundo () {
int compPrimMenor = calc.compara(0, 1);
Assertions.assertEquals(-1, compPrimMenor);
}

@DisplayName("Testa a divisao de dois numeros")
@Test
public void testDivisaoDoisNumeros() {
int divisao = calc.divisao(8, 4);
assertTrue(divisao == 2);
}

@Test
public void testDivisaoPorZero() {
try {
int divisao = calc.divisao(8, 0);
fail("Exce��o n�o lan�ada");
}catch (ArithmeticException e) {
assertEquals("/ by zero", e.getMessage());
}
}

@Test
public void testDivisaoPorZeroComAssertThrows() {
assertThrows(ArithmeticException.class,
() -> calc.divisao(8, 0));
}

@DisplayName("Testa se um número é positivo")
@Test
public void testehPositivo() {
boolean result = calc.ehPositivo(3);
Assertions.assertEquals(true, result);
result = calc.ehPositivo(-1);
Assertions.assertEquals(false, result);
result = calc.ehPositivo(0);
Assertions.assertEquals(true, result);
}

@DisplayName("Testa a multiplicacao de dois numeros")
@Test
public void testMultNumPosit () {
int multiplicacao = calc.multiplicacao(2, 3);
Assertions.assertEquals(6, multiplicacao);
}

@Test
public void testMultNumPositNeg () {
int multiplicacao = calc.multiplicacao(2, -3);
Assertions.assertEquals(-6, multiplicacao);
}

@Test
public void testMultZero () {
int multiplicacao = calc.multiplicacao(2, 0);
Assertions.assertEquals(0, multiplicacao);
}

@DisplayName("Testa a soma de dois numeros")
@Test
public void testSomaDoisNumeros() {
int soma = calc.soma(4, 5);
Assertions.assertEquals(9, soma);
}

@DisplayName("Testa a somatoria")
@Test
public void testaSomatoria () {
int resultSomat = calc.somatoria(10);
Assertions.assertEquals(55, resultSomat);
}


@DisplayName("Testa a subtração de dois numeros")
@Test
public void testSubtracaoDoisNumeros() {
int subtracao = calc.subtracao(5, 4);
Assertions.assertEquals(1, subtracao);
subtracao = calc.subtracao(5, 5);
Assertions.assertEquals(0, subtracao);
subtracao = calc.subtracao(4, 5);
Assertions.assertEquals(-1, subtracao);
} 
}