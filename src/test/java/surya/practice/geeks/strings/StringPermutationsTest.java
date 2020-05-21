package surya.practice.geeks.strings;

import org.junit.jupiter.api.Test;

class StringPermutationsTest {

    AllPermutations stringPermutations = new AllPermutations();

    @Test
    public void testPermutations() {
        stringPermutations.generatePermutations("name");
    }
}