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
package io.github.carlomicieli.api.catalog.scales;

import io.github.carlomicieli.api.catalog.CatalogApis;
import io.github.carlomicieli.catalog.scales.Scale;
import io.github.carlomicieli.catalog.scales.ScaleBuilder;
import io.github.carlomicieli.catalog.scales.ScaleId;
import io.github.carlomicieli.catalog.scales.ScaleRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.Put;

@Controller(CatalogApis.API_SCALES)
public class UpdateScalesController {
    @Put("/{scaleId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_PROBLEM})
    public HttpResponse<Scale> handle(@PathVariable("scaleId") String scaleId, @Body ScaleRequest scaleRequest) {
        ScaleId scaleIdValue = new ScaleId(scaleRequest.name());
        Scale scale = ScaleBuilder.builder()
                .scaleId(scaleIdValue)
                .name(scaleRequest.name())
                .ratio(scaleRequest.ratio())
                .build();
        return HttpResponse.ok(scale);
    }
}
