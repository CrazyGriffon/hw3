package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class HomeWorkTest {

    HomeWork homeWork = new HomeWork();

    @Test
    public void testFindMaxSubstring() {
        //пример 1
        assertEquals("abcd", homeWork.findMaxSubstring("abcddcba"));
        //пример 2
        assertEquals("dcbaX", homeWork.findMaxSubstring("abcddcbaX"));
        //все элементы строки различны
        assertEquals("abcdefghIJKLMNOPQ", homeWork.findMaxSubstring("abcdefghIJKLMNOPQ"));
        //все элементы строки одинаковы
        assertEquals("a", homeWork.findMaxSubstring("aAAaAaaaaaaaAAAAAAaaAaAaA"));

        assertEquals("CJDKS", homeWork.findMaxSubstring("AACCCCJDKSJKACCCCCK"));
        assertEquals("wke", homeWork.findMaxSubstring("pwwkew"));
        assertEquals("abcd", homeWork.findMaxSubstring("abcabcdcc"));
    }

    @Test
    public void testCheck() {
        //пример 1
        assertTrue(homeWork.check("The quick brown fox jumps over the lazy dog"));
        assertTrue(homeWork.check("Amber lives in Azerbaijan with her ex-coworker Difney and grandmother Poque!"));
        assertTrue(homeWork.check("abcdefghijklmnopqrstuvwxyz"));
        assertTrue(homeWork.check("the wizard quickly jinxed the gnomes before they vaporized."));
        assertTrue(homeWork.check("Foxy squirrel moves a jaguar dance with punk Zebu."));

        //no w letter
        assertFalse(homeWork.check("The quick bron fox jumps over the lazy dog"));
        //no l letter
        assertFalse(homeWork.check("abcdefghijkmnopqrstuvwxyz"));
        //no k letter
        assertFalse(homeWork.check("Foxy squirrel moves a jaguar dance with pun Zebu."));
    }
}