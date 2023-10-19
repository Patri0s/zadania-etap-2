package pl.patri0s.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pl.patri0s.utils.Calculate.calculate;

class CalculateTest {

    @Test
    void should_return_sum_if_there_is_no_sign() {
        //given
        String input = "12,34.56;67";
        //when
        double result = calculate(input);
        //then
        Assertions.assertEquals(113.56, result);
    }

    @Test
    void should_return_sum_if_there_is_plus_sign_at_the_end() {
        //given
        String input = "12,34.56;67+";
        //when
        double result = calculate(input);
        //then
        Assertions.assertEquals(113.56, result);
    }

    @Test
    void should_return_subtraction_if_there_is_minus_sign_at_the_end() {
        //given
        String input = "12,34.56;67-";
        //when
        double result = calculate(input);
        //then
        Assertions.assertEquals(-89.56, result);
    }

    @Test
    void should_return_product_if_there_is_multiply_sign_at_the_end() {
        //given
        String input = "12,34.56;67*";
        //when
        double result = calculate(input);
        //then
        Assertions.assertEquals(27786.24, result);
    }

    @Test
    void should_return_quotient_if_there_is_divide_sign_at_the_end() {
        //given
        String input = "12,34.56;67/";
        //when
        double result = calculate(input);
        //then
        Assertions.assertEquals(0.005182421227197346, result);
    }

    @Test
    void should_catch_exception_if_user_entered_wrong_data() {
        //given
        String input = "12d,34g.56h;67/";
        //when
        double result = calculate(input);
        //then
        Assertions.assertEquals(-1, result);
    }
}