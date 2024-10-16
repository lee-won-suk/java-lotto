package step1stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrentNumberTest {

    public static final int TEST_CURRENT_NUMBER = 5;

    @ParameterizedTest()
    @CsvSource(value = {"1,1,2","1,2,3","2,2,4"})
    public void 덧셈_테스트(int firstNumber, int secondNumber, int resultNumber) {
        assertThat(CurrentNumber.sum(firstNumber,secondNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest()
    @CsvSource(value = {"2,1,1","1,2,-1","3,3,0"})
    public void 뺄셈_테스트(int firstNumber, int secondNumber, int resultNumber) {
        assertThat(CurrentNumber.decrease(firstNumber,secondNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest()
    @CsvSource(value = {"2,1,2","1,-2,-2","3,0,0"})
    public void 곱셈_테스트(int firstNumber, int secondNumber, int resultNumber) {
        assertThat(CurrentNumber.multiplication(firstNumber,secondNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest(name = "나눗셈 정수 반환.버림연산")
    @CsvSource(value = {"2,1,2","7,2,3","7,3,2"})
    public void 나눗셈_테스트(int firstNumber, int secondNumber, int resultNumber) {
        assertThat(CurrentNumber.division(firstNumber,secondNumber)).isEqualTo(resultNumber);
    }

    @ParameterizedTest()
    @CsvSource(value = {"+,1,6","-,2,3","*,1,5","/,2,2"})
    void choiceCalculate_테스트(String currentOperator, int nextNumber, int resultNumber) {
        CurrentNumber currentNumber = new CurrentNumber(TEST_CURRENT_NUMBER);
        currentNumber.choiceCalculate(currentOperator,nextNumber);
        assertThat(currentNumber).isEqualTo(new CurrentNumber(resultNumber));
    }

}
