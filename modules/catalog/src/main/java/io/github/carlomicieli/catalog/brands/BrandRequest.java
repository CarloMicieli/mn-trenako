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
package io.github.carlomicieli.catalog.brands;

import io.github.carlomicieli.common.Address;
import io.github.carlomicieli.common.ContactInfo;
import io.github.carlomicieli.common.LocalizedText;
import io.github.carlomicieli.common.OrganizationEntityType;
import io.github.carlomicieli.common.Socials;
import io.micronaut.serde.annotation.Serdeable;
import io.soabase.recordbuilder.core.RecordBuilder;

/**
 * It represents a request to create/update model railways brands
 * @param name the brand name
 * @param kind the brand activity
 * @param status the brand status
 * @param registeredCompanyName the registered company name for this brand
 * @param organizationEntityType the organization entity type
 * @param groupName the group name in case the brand is part of a group
 * @param description the brand description
 * @param address the main address
 * @param contactInfo the contact info
 * @param socials the social handlers
 */
@RecordBuilder
@Serdeable
public record BrandRequest(
        String name,
        BrandKind kind,
        BrandStatus status,
        String registeredCompanyName,
        OrganizationEntityType organizationEntityType,
        String groupName,
        LocalizedText description,
        Address address,
        ContactInfo contactInfo,
        Socials socials) {}
