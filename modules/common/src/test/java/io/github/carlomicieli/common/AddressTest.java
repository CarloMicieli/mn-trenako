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
package io.github.carlomicieli.common;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Address")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class AddressTest {
    @Test
    void it_should_create_new_address() {
        Address address = AddressBuilder.builder()
                .streetAddress("Fischerinsel 48")
                .region("Nordrhein-Westfalen")
                .city("Mönchengladbach Winkeln")
                .postalCode("41068")
                .country("DE")
                .build();

        assertEquals("DE", address.country());
        assertEquals("41068", address.postalCode());
        assertEquals("Nordrhein-Westfalen", address.region());
        assertEquals("Fischerinsel 48", address.streetAddress());
        assertEquals("Mönchengladbach Winkeln", address.city());
    }

    @ParameterizedTest
    @MethodSource("addressCreationTestSource")
    void it_should_throw_an_IllegalArgumentException_when_a_required_value_is_missing(
            String streetAddress, String city, String country, String expectedMessage) {
        IllegalArgumentException exception = assertThrowsExactly(
                IllegalArgumentException.class, () -> new Address(streetAddress, null, city, null, null, country));
        assertNotNull(exception);
        assertEquals(expectedMessage, exception.getMessage());
    }

    private static Stream<Arguments> addressCreationTestSource() {
        return Stream.of(
                Arguments.of(null, null, null, "the street address is required"),
                Arguments.of("", "", "", "the street address is required"),
                Arguments.of("something", "", "", "the city is required"),
                Arguments.of("something", "something", "", "the country is required"),
                Arguments.of("", "", "something", "the street address is required"));
    }
}
