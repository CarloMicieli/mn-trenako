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
import io.github.carlomicieli.catalog.scales.ScaleRatio;
import io.github.carlomicieli.catalog.scales.ScalesList;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.annotation.QueryValue;
import java.util.List;

@Controller(CatalogApis.API_SCALES)
public class FindScalesController {
    @Get
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_PROBLEM})
    public HttpResponse<ScalesList> handle(
            @Nullable @QueryValue("offset") Integer offset, @Nullable @QueryValue("limit") Integer limit) {
        Scale scale = ScaleBuilder.builder()
                .scaleId(new ScaleId("H0"))
                .name("H0")
                .ratio(ScaleRatio.of(87.0f))
                .build();
        ScalesList scalesList = new ScalesList(List.of(scale));
        return HttpResponse.ok(scalesList);
    }
}
