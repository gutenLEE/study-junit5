package com.guten.myinflearnjavatest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyTest {
    @Test
    void create(){
        Study study = new Study();
        assertNotNull(study);
    }
}