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

/**
 * It represents the technical specification for a rolling stock
 * @param minimumRadius the minimum drivable radius (in millimeters)
 * @param coupling
 * @param flywheelFitted
 * @param bodyShell
 * @param chassis
 * @param interiorLights
 * @param lights
 * @param sprungBuffers
 */
public record TechnicalSpecifications(
        Float minimumRadius,
        Coupling coupling,
        FeatureFlag flywheelFitted,
        BodyShellType bodyShell,
        ChassisType chassis,
        FeatureFlag interiorLights,
        FeatureFlag lights,
        FeatureFlag sprungBuffers) {}
