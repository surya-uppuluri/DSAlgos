package surya.practice.geeks.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecryptStringFromAlphabetsTest {

    @Test
    void freqAlphabets1() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("jkab", decryptStringFromAlphabets.freqAlphabetsNaive("10#11#12"));
    }


    @Test
    void freqAlphabets2() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("acz", decryptStringFromAlphabets.freqAlphabetsNaive("1326#"));
    }


    @Test
    void freqAlphabets3() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("y", decryptStringFromAlphabets.freqAlphabetsNaive("25#"));
    }


    @Test
    void freqAlphabets4() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("abcdefghijklmnopqrstuvwxyz", decryptStringFromAlphabets.freqAlphabetsNaive("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }


    @Test
    void freqAlphabetsOptimized1() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("jkab", decryptStringFromAlphabets.freqAlphabetsOptimized("10#11#12"));
    }


    @Test
    void freqAlphabetsOptimized2() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("acz", decryptStringFromAlphabets.freqAlphabetsOptimized("1326#"));
    }


    @Test
    void freqAlphabetsOptimized3() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("y", decryptStringFromAlphabets.freqAlphabetsOptimized("25#"));
    }


    @Test
    void freqAlphabetsOptimized4() {

        DecryptStringFromAlphabets decryptStringFromAlphabets = new DecryptStringFromAlphabets();
        assertEquals("abcdefghijklmnopqrstuvwxyz", decryptStringFromAlphabets.freqAlphabetsOptimized("12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"));
    }



}