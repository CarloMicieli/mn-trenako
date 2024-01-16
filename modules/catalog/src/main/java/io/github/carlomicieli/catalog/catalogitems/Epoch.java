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
 * It represents a modelling railway epoch
 * @param value
 */
public record Epoch(String value) {
    public static final Epoch I = new Epoch("I");
    public static final Epoch II = new Epoch("II");
    public static final Epoch IIa = new Epoch("IIa");
    public static final Epoch IIb = new Epoch("IIb");
    public static final Epoch III = new Epoch("III");
    public static final Epoch IIIa = new Epoch("IIIa");
    public static final Epoch IIIb = new Epoch("IIIb");
    public static final Epoch IV = new Epoch("IV");
    public static final Epoch IVa = new Epoch("IVa");
    public static final Epoch IVb = new Epoch("IVb");
    public static final Epoch V = new Epoch("V");
    public static final Epoch Vm = new Epoch("Vm");
    public static final Epoch VI = new Epoch("VI");

    public static Epoch parse(String input) {
        Epoch epoch = fromConstant(input);
        if (epoch != null) {
            return epoch;
        } else {
            return fromTokens(input);
        }
    }

    private static Epoch fromTokens(String s) {
        String[] tokens = s.split("/");
        if (tokens.length == 2) {
            Epoch epoch1 = fromConstant(tokens[0].trim());
            Epoch epoch2 = fromConstant(tokens[1].trim());
            return new Epoch(String.format("%s/%s", epoch1, epoch2));
        } else {
            return null;
        }
    }

    private static Epoch fromConstant(String s) {
        return switch (s) {
            case "I" -> Epoch.I;
            case "II" -> Epoch.II;
            case "IIa", "IIA" -> Epoch.IIa;
            case "IIb", "IIB" -> Epoch.IIb;
            case "III" -> Epoch.III;
            case "IIIa", "IIIA" -> Epoch.IIIa;
            case "IIIb", "IIIB" -> Epoch.IIIb;
            case "IV" -> Epoch.IV;
            case "IVa", "IVA" -> Epoch.IVa;
            case "IVb", "IVB" -> Epoch.IVb;
            case "V" -> Epoch.V;
            case "Vm", "VM" -> Epoch.Vm;
            case "VI" -> Epoch.VI;
            default -> null;
        };
    }
}
