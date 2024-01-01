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

import java.math.BigDecimal;
import java.util.Objects;

public final class BigDecimals {
    /**
     * Checks that the specified BigDecimal value is not null and positive and throws an IllegalArgumentException if it is.
     * @param input the value to check
     */
    public static void requirePositive(BigDecimal input) {
        Objects.requireNonNull(input);
        if (input.signum() <= 0) {
            throw new IllegalArgumentException("input must be positive");
        }
    }

    /**
     * Checks that the specified BigDecimal value is positive and throws an IllegalArgumentException if it is.
     * @param input the value to check
     * @param message detail message to be used in the event that a IllegalArgumentException is thrown
     */
    public static void requireNullOrPositive(BigDecimal input, String message) {
        if (input != null && input.signum() <= 0) {
            throw new IllegalArgumentException(message);
        }
    }
}
