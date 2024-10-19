package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarculatorStringTest {

    private MathExpression mathExpression;

    @ParameterizedTest()
    @NullAndEmptySource()
    public void 빈값_null_테스트(String requestMathExpression) {
        mathExpression = new MathExpression(requestMathExpression);
        assertThatThrownBy(() -> {
            mathExpression.checkNullAndEmpty();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest()
    @ValueSource(strings = {"2a-?","#$%@$#@$"})
    public void 문자열아닌값_IllegalArgumentException_테스트(String requestMathExpression) {
        mathExpression = new MathExpression(requestMathExpression);
        assertThatThrownBy(() -> {
            mathExpression.checkMathExpressionRegex();
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 기호없는지여부_테스트() {
        String requestMathExpression = "2 2 3?";
        mathExpression = new MathExpression(requestMathExpression);
        assertThatThrownBy(() -> {
            mathExpression.checkNonOperator();
        }).isInstanceOf(IllegalArgumentException.class);
    }



}





