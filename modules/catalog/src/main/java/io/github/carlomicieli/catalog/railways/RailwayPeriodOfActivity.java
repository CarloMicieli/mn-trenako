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

import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;
import java.time.LocalDate;
import java.util.Objects;

/**
 * It represents the period of activity for a railway company
 * @param status the railway status
 * @param operatingSince the date when the railway started its operation
 * @param operatingUntil the date when the railway ended its operation, if not active anymore
 */
@RecordBuilder
@Serdeable
public record RailwayPeriodOfActivity(RailwayStatus status, LocalDate operatingSince, LocalDate operatingUntil) {
    /**
     * Creates the period of activity for an active railway
     * @param operatingSince the date when the railway started its operation
     * @return a railway period of activity
     */
    public static RailwayPeriodOfActivity activeRailway(LocalDate operatingSince) {
        Objects.requireNonNull(operatingSince);
        return new RailwayPeriodOfActivity(RailwayStatus.ACTIVE, operatingSince, null);
    }

    /**
     * Creates the period of activity for an inactive railway
     * @param operatingSince the date when the railway started its operation
     * @param operatingUntil the date when the railway ended its operation, if not active anymore
     * @return a railway period of activity
     */
    public static RailwayPeriodOfActivity inactiveRailway(LocalDate operatingSince, LocalDate operatingUntil) {
        Objects.requireNonNull(operatingSince);
        return new RailwayPeriodOfActivity(RailwayStatus.INACTIVE, operatingSince, operatingUntil);
    }
}
