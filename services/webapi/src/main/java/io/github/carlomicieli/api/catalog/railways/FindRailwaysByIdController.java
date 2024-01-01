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
package io.github.carlomicieli.api.catalog.railways;

import io.github.carlomicieli.api.catalog.CatalogApis;
import io.github.carlomicieli.catalog.railways.Railway;
import io.github.carlomicieli.catalog.railways.RailwayBuilder;
import io.github.carlomicieli.catalog.railways.RailwayId;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.Produces;

@Controller(CatalogApis.API_RAILWAYS)
public class FindRailwaysByIdController {
    @Get("/{railwayId}")
    @Produces(value = {MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_PROBLEM})
    public HttpResponse<Railway> handle(@PathVariable("railwayId") String railwayId) {
        Railway brand = RailwayBuilder.builder()
                .railwayId(new RailwayId(railwayId))
                .name("FS")
                .build();
        return HttpResponse.ok(brand);
    }
}
