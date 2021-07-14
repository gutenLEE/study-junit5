package com.guten.myinflearnjavatest;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yhlee
 * @created_at 2021-07-14 오전 9:48
 */
@Target(ElementType.METHOD) // -> 메서드에 사용한다.
@Retention(RetentionPolicy.RUNTIME) // -> FastTest 어노테이션이 달리면 Runtime 내내 유지된다.
@Test
@Tag("fast")
public @interface FastTest {
}
