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
 * It represents enumeration of the travel classes for passenger car.
 * Passenger cars can have multiple service levels (ie, first/second class)
 */
public enum ServiceLevel {
    FIRST_AND_SECOND_CLASS,
    FIRST_CLASS,
    FIRST_SECOND_AND_THIRD_CLASS,
    SECOND_AND_THIRD_CLASS,
    SECOND_CLASS,
    THIRD_CLASS;
}