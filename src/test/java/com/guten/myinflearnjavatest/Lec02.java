package com.guten.myinflearnjavatest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.net.BindException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
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

    @DisplayName("repeat test")
    @RepeatedTest(value = 10)
        // 테스트를 반복해서 할때
    void repeat_test(RepetitionInfo info) {
        // RepetitionInfo 객체를 통해 반복하는 정보를 얻을 수 있다.
        System.out.println(" TEST " + info.getCurrentRepetition() + "/" + info.getTotalRepetitions());
        System.out.println("true = " + true);
    }

    // 반복해서 테스트하지만 매번 파라미터를 다르게 하고 싶을 때 사용한다.
    @ParameterizedTest(name = "{index} message={0}")
    @ValueSource(strings = {"a", "B", "C"})
    @EmptySource // 비어있는 값을 넘겨주는 기능을 한다.
    @NullAndEmptySource // null을 넘겨준다.
    void prameterizedTest(String message) {
        System.out.println("message = " + message);
    }

    // 반복해서 테스트하지만 매번 파라미터를 다르게 하고 싶을 때 사용한다.
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30})
    void simpleArgConverter_test(Study study) {
        System.out.println(study.getLimit());
    }
    // aggregator 를 사용하기 위한 제약조건 : static inner class or public class
    // 인자 1개
    static class StudyConverter extends SimpleArgumentConverter{
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Study.class, targetType, "Can only convert to Study");
            return new Study(Integer.parseInt(source.toString()));
        }
    }
    // 인자 여러개개
   static class StudyAggregator implements ArgumentsAggregator{
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            Study study = new Study(accessor.getInteger(0), accessor.getString(1));
            return study;
        }
    }
}
