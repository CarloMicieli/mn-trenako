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

import io.github.carlomicieli.util.Strings;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

/**
 * It represents an address of a location
 *
 * @param streetAddress the street address
 * @param extendedAddress the (optional) extended information for the address
 * @param city the city/town
 * @param region the (optional) region code; for example, the state or province
 * @param postalCode the (optional) postal code (ZIP code)
 * @param country the ISO country code (ISO 3166-1 alpha-2)
 */
@RecordBuilder
@Serdeable
public record Address(
        String streetAddress, String extendedAddress, String city, String region, String postalCode, String country) {

    public Address {
        Strings.requireNonBlank(streetAddress, "the street address is required");
        Strings.requireNonBlank(city, "the city is required");
        Strings.requireNonBlank(country, "the country is required");
    }
}
