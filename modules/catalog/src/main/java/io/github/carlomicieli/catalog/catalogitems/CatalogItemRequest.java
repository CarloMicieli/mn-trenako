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
package io.github.carlomicieli.catalog.catalogitems;

import io.github.carlomicieli.common.LocalizedText;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;
import java.util.List;

/**
 * It represents the request to create/update catalog items
 * @param brand
 * @param itemNumber the catalog item number
 * @param epoch the epoch for this rolling stock
 * @param scale
 * @param category
 * @param description
 * @param details
 * @param powerMethod
 * @param deliveryDate this catalog item delivery date (either the year "yyyy" or the quarter "yyyy/q[1-4]")
 * @param availabilityStatus
 * @param rollingStocks
 * @param count the number of rolling stocks for this catalog item
 */
@RecordBuilder
@Serdeable
public record CatalogItemRequest(
        String brand,
        String itemNumber,
        Epoch epoch,
        String scale,
        CatalogItemCategory category,
        LocalizedText description,
        LocalizedText details,
        PowerMethod powerMethod,
        String deliveryDate,
        AvailabilityStatus availabilityStatus,
        List<RollingStockRequest> rollingStocks,
        Integer count) {}
