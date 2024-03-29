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
package io.github.carlomicieli.api.catalog.catalogitems;

import io.github.carlomicieli.api.catalog.CatalogApis;
import io.github.carlomicieli.catalog.catalogitems.CatalogItemId;
import io.github.carlomicieli.catalog.catalogitems.CatalogItemRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Produces;
import java.net.URI;

@Controller(CatalogApis.API_CATALOG_ITEMS)
public class CreateNewCatalogItemsController {
    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON_PROBLEM)
    public HttpResponse<Void> handle(@Body CatalogItemRequest catalogItemRequest) {
        CatalogItemId catalogItemId = new CatalogItemId("acme-123456");
        return HttpResponse.created(URI.create(CatalogApis.API_CATALOG_ITEMS + "/" + catalogItemId));
    }
}
