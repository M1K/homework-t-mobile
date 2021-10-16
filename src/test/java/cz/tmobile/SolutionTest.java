package cz.tmobile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    void testExampleInput() {
        String expected = "Netflix|02|payment weekly\n"
                + "Apple|1|game Of Thrones\n"
                + "Netflix|01|payment yearly\n"
                + "Microsoft|2|Office 365\n"
                + "Microsoft|1|Office 365\n"
                + "Apple|2|payment weekly\n"
                + "Microsoft|3|application Any.DO\n"
                + "Netflix|03|new subscription\n"
                + "Netflix|09|installation of Modem\n"
                + "Netflix|07|Sport 02\n"
                + "Netflix|06|monthly subscription\n"
                + "Netflix|08|O2TV, SportTV\n"
                + "Netflix|04|game Of thrones\n"
                + "Netflix|05|yearly subscription\n"
                + "Netflix|10|recharging of 987654321";
        assertEquals(expected, solution.solution("src/main/resources/example_input.txt"));
    }
}