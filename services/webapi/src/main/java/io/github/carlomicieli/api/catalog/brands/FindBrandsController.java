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
package io.github.carlomicieli.api.catalog.brands;

import io.github.carlomicieli.api.catalog.CatalogApis;
import io.github.carlomicieli.catalog.brands.Brand;
import io.github.carlomicieli.catalog.brands.BrandBuilder;
import io.github.carlomicieli.catalog.brands.BrandId;
import io.github.carlomicieli.catalog.brands.BrandKind;
import io.github.carlomicieli.catalog.brands.BrandsList;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import java.util.List;

@Controller(CatalogApis.API_BRANDS)
public class FindBrandsController {
    @Get
    public HttpResponse<BrandsList> handle(
            @Nullable @QueryValue("offset") Integer offset, @Nullable @QueryValue("limit") Integer limit) {
        Brand brand = BrandBuilder.builder()
                .brandId(new BrandId("acme"))
                .name("ACME")
                .kind(BrandKind.INDUSTRIAL)
                .build();
        BrandsList brandsList = new BrandsList(List.of(brand));
        return HttpResponse.ok(brandsList);
    }
}
