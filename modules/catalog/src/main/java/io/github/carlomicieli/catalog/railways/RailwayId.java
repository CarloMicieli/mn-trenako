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

import io.github.carlomicieli.util.Slug;
import io.github.carlomicieli.util.Strings;
import io.micronaut.serde.annotation.Serdeable;

/**
 * It represents the railway unique identifier (an url encoded string)
 * @param value the value
 */
@Serdeable
public record RailwayId(String value) {
    public RailwayId {
        Strings.requireNonBlank(value, "railway id cannot be null or blank");
        value = new Slug(value).value();
    }

    @Override
    public String toString() {
        return value;
    }
}
