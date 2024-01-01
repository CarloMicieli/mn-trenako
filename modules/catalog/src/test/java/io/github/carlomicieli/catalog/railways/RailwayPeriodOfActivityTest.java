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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("RailwayPeriodOfActivity")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RailwayPeriodOfActivityTest {
    private static final LocalDate SINCE_DATE = LocalDate.of(1900, 1, 1);
    private static final LocalDate UNTIL_DATE = LocalDate.of(2000, 12, 31);

    @Test
    void it_should_create_inactive_railways() {
        RailwayPeriodOfActivity railwayPeriodOfActivity =
                RailwayPeriodOfActivity.inactiveRailway(SINCE_DATE, UNTIL_DATE);
        assertEquals(RailwayStatus.INACTIVE, railwayPeriodOfActivity.status());
        assertEquals(SINCE_DATE, railwayPeriodOfActivity.operatingSince());
        assertEquals(UNTIL_DATE, railwayPeriodOfActivity.operatingUntil());
    }

    @Test
    void it_should_create_active_railways() {
        RailwayPeriodOfActivity railwayPeriodOfActivity = RailwayPeriodOfActivity.activeRailway(SINCE_DATE);
        assertEquals(RailwayStatus.ACTIVE, railwayPeriodOfActivity.status());
        assertEquals(SINCE_DATE, railwayPeriodOfActivity.operatingSince());
        assertNull(railwayPeriodOfActivity.operatingUntil());
    }
}
