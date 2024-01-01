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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("Slug")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class SlugTest {
    @Test
    void it_should_throw_an_IllegalArgumentException_when_the_input_is_not_valid() {
        IllegalArgumentException exception =
                Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> new Slug(""));
        assertNotNull(exception);
        assertEquals("a slug cannot be null or blank", exception.getMessage());
    }

    @Test
    void it_should_create_slug_from_strings() {
        Slug slug = new Slug("hello World");
        assertEquals("hello-world", slug.value());
    }

    @Test
    void it_should_create_slug_with_custom_replacements() {
        Slug slug = new Slug("Märklìn Modellbahnen");
        assertEquals("maerklin-modellbahnen", slug.value());
    }

    @Test
    void it_should_produce_string_representations() {
        Slug slug = new Slug("hello World");
        assertEquals("hello-world", slug.toString());
    }
}
