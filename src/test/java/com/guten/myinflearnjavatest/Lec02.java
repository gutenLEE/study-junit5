package com.guten.myinflearnjavatest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 *
 * @author yhlee
 * @created_at 2021-07-14 오전 9:46
 */

public class Lec02 {
    /*
        JUnit5 : 커스텀 태그
        JUnit5 애노테이션을 조합하여 커스텀 태그를 만들 수 있다.
     */

    @Test
    @Tag("fast")
    void create_new_study() {
        // 테스트 메서드마다 일일이 @Tag 를 달아줄 필요 없이
    }

    @FastTest
    @Test
    void create_new_study2() {
        // 커스텀 태그를 사용한다.
        // 오타방지 , type safe 가능하다. 
    }
}
