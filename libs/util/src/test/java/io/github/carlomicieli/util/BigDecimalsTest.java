/*
 *   Copyright (c) 2024 (C) Carlo Micieli
 *
 *    Licensed to the Apache Software Foundation (ASF) under one
 *    or more contributor license agreements.  See the NOTICE file
 *    distributed with this work for additional information
 *    regarding copyright ownership.  The ASF licenses this file
 *    to you under the Apache License, Version 2.0 (the
 *    "License"); you may not use this file except in compliance
 *    with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing,
 *    software distributed under the License is distributed on an
 *    "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *    KIND, either express or implied.  See the License for the
 *    specific language governing permissions and limitations
 *    under the License.
 */
package io.github.carlomicieli.util;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("BigDecimals")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BigDecimalsTest {

    @Nested
    @DisplayName("requirePositive()")
    class RequirePositive {
        @Test
        void it_should_not_throw_when_input_is_positive() {
            assertDoesNotThrow(() -> BigDecimals.requirePositive(BigDecimal.ONE));
        }

        @Test
        void it_should_throw_an_IllegalArgumentException_when_the_input_is_zero() {
            IllegalArgumentException ex = assertThrowsExactly(
                    IllegalArgumentException.class, () -> BigDecimals.requirePositive(BigDecimal.ZERO));
            assertNotNull(ex);
            assertEquals("input must be positive", ex.getMessage());
        }

        @Test
        void it_should_throw_an_IllegalArgumentException_when_the_input_is_negative() {
            IllegalArgumentException ex = assertThrowsExactly(
                    IllegalArgumentException.class, () -> BigDecimals.requirePositive(BigDecimal.valueOf(-42)));
            assertNotNull(ex);
            assertEquals("input must be positive", ex.getMessage());
        }
    }

    @Nested
    @DisplayName("requireNullOrPositive()")
    class RequireNullOrPositive {
        @Test
        void it_should_not_throw_when_input_is_positive() {
            assertDoesNotThrow(() -> BigDecimals.requireNullOrPositive(BigDecimal.ONE, "input must be positive"));
        }

        @Test
        void it_should_not_throw_when_input_is_null() {
            assertDoesNotThrow(() -> BigDecimals.requireNullOrPositive(null, "input must be positive"));
        }

        @Test
        void it_should_throw_an_IllegalArgumentException_when_the_input_is_zero() {
            IllegalArgumentException ex = assertThrowsExactly(
                    IllegalArgumentException.class,
                    () -> BigDecimals.requireNullOrPositive(BigDecimal.ZERO, "input must be positive"));
            assertNotNull(ex);
            assertEquals("input must be positive", ex.getMessage());
        }

        @Test
        void it_should_throw_an_IllegalArgumentException_when_the_input_is_negative() {
            IllegalArgumentException ex = assertThrowsExactly(
                    IllegalArgumentException.class,
                    () -> BigDecimals.requireNullOrPositive(BigDecimal.valueOf(-42), "input must be positive"));
            assertNotNull(ex);
            assertEquals("input must be positive", ex.getMessage());
        }
    }
}
