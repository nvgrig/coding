package com.nvgrig.coding.leet;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoatLatinTest {

    @Test
    void test() {
        GoatLatin goatLatin = new GoatLatin();
        assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa", goatLatin.toGoatLatin("I speak Goat Latin"));
        assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa",
                goatLatin.toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}