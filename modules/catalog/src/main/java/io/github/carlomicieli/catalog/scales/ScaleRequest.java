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

import io.github.carlomicieli.common.LocalizedText;
import io.github.carlomicieli.util.Strings;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;
import java.util.List;
import java.util.Objects;

/**
 * It represents a request to create/update rail transport modelling scales
 * @param name the scale name
 * @param ratio the ratio between the real world and the model (e.g. 1/87 or 1:87)
 * @param gauge the scale gauge
 * @param description
 * @param standards the list of standards
 */
@RecordBuilder
@Serdeable
public record ScaleRequest(
        String name, ScaleRatio ratio, ScaleGauge gauge, LocalizedText description, List<ScaleStandard> standards) {
    public ScaleRequest {
        Strings.requireNonBlank(name);
        Objects.requireNonNull(ratio);
    }
}
