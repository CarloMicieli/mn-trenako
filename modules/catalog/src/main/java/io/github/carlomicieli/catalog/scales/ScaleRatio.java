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

import io.github.carlomicieli.util.BigDecimals;
import io.micronaut.serde.annotation.Serdeable;
import java.math.BigDecimal;

/**
 * It represents the ratio between the real world and the model (e.g. 1/87 or 1:87)
 * @param value the ratio value
 */
@Serdeable
public record ScaleRatio(BigDecimal value) {
    public ScaleRatio {
        BigDecimals.requirePositive(value);
    }

    @Override
    public String toString() {
        return String.format("1:%s", value);
    }

    public static ScaleRatio of(float value) {
        return ScaleRatios.get(value).orElseGet(() -> new ScaleRatio(BigDecimal.valueOf(value)));
    }
}
