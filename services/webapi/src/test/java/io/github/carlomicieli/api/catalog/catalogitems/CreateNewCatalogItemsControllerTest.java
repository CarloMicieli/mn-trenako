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

import static io.micronaut.http.HttpRequest.POST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.carlomicieli.catalog.catalogitems.CatalogItemRequestBuilder;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@MicronautTest
@DisplayName("POST /api/catalog-items")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CreateNewCatalogItemsControllerTest {
    @Inject
    @Client("/api/catalog-items")
    private HttpClient httpClient;

    @Test
    void it_should_create_new_catalog_items() {
        var catalogItemRequest = CatalogItemRequestBuilder.builder()
                .brand("ACME")
                .itemNumber("123456")
                .build();
        var result = httpClient.toBlocking().exchange(POST("/", catalogItemRequest));
        assertNotNull(result);
        assertEquals(HttpStatus.CREATED, result.status());
        assertEquals("/api/catalog-items/acme-123456", result.header("location"));
    }
}
