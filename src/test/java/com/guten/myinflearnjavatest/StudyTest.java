package com.guten.myinflearnjavatest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class StudyTest {

    @Test
    @DisplayName("make study")
    void create_new_study() {
        Study study = new Study();

/*        assertEquals(StudyStatus.DRAFT, study.getStatus(), () -> "should be draft"); // 스터디가 생기면 초기 상태가 DRAFT인지 테스트
        // 바로 문자열을 너으면 문자열 연산이 반드시 발생한다.
        // 그러나 람다를 활용하면 참일 경우에만 문자열 연산이 수행된다.

        assertTrue(study.getLimit() > 0, "스터디 최대 참석 가능 인원은 0보다 커야한다.");*/

        assertAll(
                () -> assertNotNull(study),
                () -> assertEquals(StudyStatus.DRAFT, study.getStatus(),
                        ()->"스터디 초기화 상태는 DRAFT여야 한다."),
                ()-> assertTrue(study.getLimit() > 0,"스터디 최대 참석 인원은 0 보다 커야함")

        );
    }
    @Test
    void how_to_display_test_case_name(){
        Study study = new Study();
        assertNotNull(study);
        System.out.println("create test case");
    }
    @Test
    void create1(){
        System.out.println("create1 test case");
    }

    // private X, return type x
    @BeforeAll
    static void beforeAll(){
        System.out.println("beforeAll");
    }

    @AfterAll
    static void afterAll(){
        System.out.println("afterAll");
    }

    // 각각의 테스트를 실행하기 이전에 한 번씩 호출된다.
    @BeforeEach
    void beforeEach(){
        System.out.println("after each");
    }
    @AfterEach
    void afterEach(){
        System.out.println("before each");
    }
}