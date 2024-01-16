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

import io.micronaut.core.annotation.NonNull;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.core.type.Argument;
import io.micronaut.serde.Decoder;
import io.micronaut.serde.Encoder;
import io.micronaut.serde.Serde;
import jakarta.inject.Singleton;
import java.io.IOException;
import java.util.Objects;

@Singleton
public class EpochSerde implements Serde<Epoch> {
    @Override
    public @Nullable Epoch deserialize(
            @NonNull Decoder decoder, DecoderContext context, @NonNull Argument<? super Epoch> type)
            throws IOException {
        String value = decoder.decodeString();
        return Epoch.parse(value);
    }

    @Override
    public void serialize(
            @NonNull Encoder encoder,
            EncoderContext context,
            @NonNull Argument<? extends Epoch> type,
            @NonNull Epoch value)
            throws IOException {
        Objects.requireNonNull(value, "Epoch cannot be null");
        encoder.encodeString(value.value());
    }
}
