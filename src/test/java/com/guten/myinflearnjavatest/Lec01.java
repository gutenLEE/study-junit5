package com.guten.myinflearnjavatest;

import org.junit.jupiter.api.*;
import org.springframework.test.annotation.Rollback;

/**
 * @author yhlee
 * @created_at 2021-07-14 오전 9:36
 */

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class Lec01 {
    // 태깅을 하여 로컬, CI/CD환경에서 실행할 것을 구분하기도 한다.
    /*
        Edit Configuration 에서 Tag 선택하고 실행하길 원하는 태그값을 입력하면 해당 태깅된 테스트만 실행할 수 있다.
        빌드 툴에서 실행시킬 태깅을 설정하는 방법도 있다.
     */
    @Test
    @DisplayName("make study group")
    @Tag("fast")
    void create_new_study() {

    }
}
