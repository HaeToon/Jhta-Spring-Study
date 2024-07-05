package com.heoth.ch01.service;

import org.junit.jupiter.api.*;

public class JUnitTest {
    @BeforeAll
    static void beforeAll(){
        System.out.println("처음 한번만 실행");
    }
    @BeforeEach
    void beforeEach(){
        System.out.println("=====");
    }

    @AfterEach
    void afterEach(){
        System.out.println("each end");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("bye bye bye");
    }


    @Test
    void unitTest01(){
        System.out.println("first test");
    }

    @Test
    void unitTest02(){
        System.out.println("second test");
    }
}
