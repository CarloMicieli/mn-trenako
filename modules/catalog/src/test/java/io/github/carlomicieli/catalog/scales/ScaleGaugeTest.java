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
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("ScaleGauge")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ScaleGaugeTest {
    @Test
    void it_should_throw_an_IllegalArgumentException_when_the_millimeters_input_length_is_not_positive() {
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> new ScaleGauge(BigDecimal.valueOf(-1), BigDecimal.valueOf(1), TrackGauge.STANDARD));
        assertEquals("millimeters cannot be negative or zero", exception.getMessage());
    }

    @Test
    void it_should_throw_an_IllegalArgumentException_when_the_millimeters_input_length_is_zero() {
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> new ScaleGauge(BigDecimal.ZERO, BigDecimal.ONE, TrackGauge.STANDARD));
        assertEquals("millimeters cannot be negative or zero", exception.getMessage());
    }

    @Test
    void it_should_throw_an_IllegalArgumentException_when_the_inches_input_length_is_not_positive() {
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> new ScaleGauge(BigDecimal.valueOf(1), BigDecimal.valueOf(-1), TrackGauge.STANDARD));
        assertEquals("inches cannot be negative or zero", exception.getMessage());
    }

    @Test
    void it_should_throw_an_IllegalArgumentException_when_the_inches_input_length_is_zero() {
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class,
                () -> new ScaleGauge(BigDecimal.ONE, BigDecimal.ZERO, TrackGauge.STANDARD));
        assertEquals("inches cannot be negative or zero", exception.getMessage());
    }
}
