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
package io.github.carlomicieli.catalog.scales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("ScaleRatio")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScaleRatioTest {
    @Test
    void it_should_throw_an_NullPointerException_when_the_input_is_null() {
        NullPointerException exception = assertThrowsExactly(NullPointerException.class, () -> new ScaleRatio(null));
        assertNull(exception.getMessage());
    }

    @Test
    void it_should_throw_an_IllegalArgumentException_when_the_input_is_negative() {
        IllegalArgumentException exception =
                assertThrowsExactly(IllegalArgumentException.class, () -> new ScaleRatio(BigDecimal.valueOf(-1)));
        assertEquals("input must be positive", exception.getMessage());
    }

    @Test
    void it_should_create_scale_ratios() {
        ScaleRatio scaleRatio = ScaleRatio.of(87f);
        assertNotNull(scaleRatio);
        assertEquals(BigDecimal.valueOf(87), scaleRatio.value());
    }

    @Test
    void it_should_produce_string_representation_for_scale_ratios() {
        ScaleRatio halfZero = ScaleRatios.H0_RATIO;
        ScaleRatio zero = ScaleRatios.O_RATIO;

        assertEquals("1:87", halfZero.toString());
        assertEquals("1:43.5", zero.toString());
    }
}
