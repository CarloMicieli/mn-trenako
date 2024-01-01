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
package io.github.carlomicieli.catalog.railways;

import io.github.carlomicieli.util.BigDecimals;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;
import java.math.BigDecimal;

/**
 * It represents the total length of a railway network
 * @param miles the total railway network in miles
 * @param kilometers the total railway network in kilometers
 */
@RecordBuilder
@Serdeable
public record RailwayTotalLength(BigDecimal miles, BigDecimal kilometers) {
    public RailwayTotalLength {
        BigDecimals.requireNullOrPositive(miles, "miles cannot be negative or zero");
        BigDecimals.requireNullOrPositive(kilometers, "kilometers cannot be negative or zero");
    }
}
