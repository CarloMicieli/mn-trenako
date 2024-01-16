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
package io.github.carlomicieli.catalog.catalogitems;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.time.Month;
import java.time.Year;
import java.util.Optional;
import java.util.OptionalInt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("DeliveryDate")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class DeliveryDateTest {
    @Test
    void it_should_parse_delivery_dates_from_year() {
        DeliveryDate deliveryDate = DeliveryDate.parse("2023");
        assertEquals(Year.of(2023), deliveryDate.year());
    }

    @Test
    void it_should_parse_delivery_dates_from_year_and_month() {
        DeliveryDate deliveryDate = DeliveryDate.parse("2023/12");
        assertEquals(Year.of(2023), deliveryDate.year());
        assertEquals(Optional.of(Month.of(12)), deliveryDate.month());
    }

    @Test
    void it_should_parse_delivery_dates_from_year_and_quarter() {
        DeliveryDate deliveryDate = DeliveryDate.parse("2023/Q1");
        assertEquals(Year.of(2023), deliveryDate.year());
        assertEquals(OptionalInt.of(1), deliveryDate.quarterNumber());
    }

    @Test
    void it_should_produce_string_representations_for_delivery_dates() {
        DeliveryDate deliveryDate1 = DeliveryDate.parse("2023/Q1");
        DeliveryDate deliveryDate2 = DeliveryDate.parse("2023/02");
        DeliveryDate deliveryDate3 = DeliveryDate.parse("2023");

        assertEquals("2023/Q1", deliveryDate1.toString());
        assertEquals("2023/02", deliveryDate2.toString());
        assertEquals("2023", deliveryDate3.toString());
    }

    @Test
    void it_should_throw_an_DeliveryDateFormatException_parsing_invalid_delivery_dates() {
        DeliveryDateFormatException exception =
                assertThrowsExactly(DeliveryDateFormatException.class, () -> DeliveryDate.parse("invalid"));
        assertNotNull(exception);
        assertEquals("\"invalid\" is not a valid delivery date", exception.getMessage());
    }
}
