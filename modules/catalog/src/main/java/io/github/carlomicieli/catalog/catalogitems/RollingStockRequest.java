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

import io.micronaut.serde.annotation.Serdeable;
import java.util.Objects;

@Serdeable
public sealed interface RollingStockRequest {
    /**
     * It represents an electric multiple unit rolling stock
     * @param railway the railway company
     * @param typeName the electric multiple unit type name
     * @param roadNumber the identification marking for this electric multiple unit
     * @param series the prototype series information
     * @param depot the depot name
     * @param electricMultipleUnitType the electric multiple unit type
     * @param control the control
     * @param dccInterface the DCC interface
     * @param livery the rolling stock livery description
     * @param lengthOverBuffers the length over buffers
     * @param technicalSpecifications the rolling stock technical specifications
     */
    record ElectricMultipleUnit(
            RollingStockRailway railway,
            String typeName,
            String roadNumber,
            String series,
            String depot,
            ElectricMultipleUnitType electricMultipleUnitType,
            Control control,
            DccInterface dccInterface,
            String livery,
            LengthOverBuffers lengthOverBuffers,
            TechnicalSpecifications technicalSpecifications)
            implements RollingStockRequest {
        public ElectricMultipleUnit {
            Objects.requireNonNull(railway);
            Objects.requireNonNull(typeName);
        }
    }

    /**
     * It represents a freight car rolling stock
     * @param railway the railway company
     * @param typeName the freight car type name
     * @param roadNumber the identification marking for this freight car
     * @param freightCarType the freight car type
     * @param livery the rolling stock livery description
     * @param lengthOverBuffers the length over buffers
     * @param technicalSpecifications the rolling stock technical specifications
     */
    record FreightCar(
            RollingStockRailway railway,
            String typeName,
            String roadNumber,
            FreightCarType freightCarType,
            String livery,
            LengthOverBuffers lengthOverBuffers,
            TechnicalSpecifications technicalSpecifications)
            implements RollingStockRequest {
        public FreightCar {
            Objects.requireNonNull(railway);
            Objects.requireNonNull(typeName);
        }
    }

    /**
     * It represents a locomotive rolling stock
     * @param railway the railway company
     * @param className the class of locomotives. The class is a group of locomotives built to a common design, typically for a single railroad or railway
     * @param roadNumber the identification marking for this locomotive
     * @param series the prototype series information
     * @param locomotiveType the locomotive type
     * @param control the control
     * @param dccInterface the DCC interface
     * @param depot the depot name
     * @param livery the rolling stock livery description
     * @param lengthOverBuffers the length over buffers
     * @param technicalSpecifications the rolling stock technical specifications
     */
    record Locomotive(
            RollingStockRailway railway,
            String className,
            String roadNumber,
            String series,
            LocomotiveType locomotiveType,
            Control control,
            DccInterface dccInterface,
            String depot,
            String livery,
            LengthOverBuffers lengthOverBuffers,
            TechnicalSpecifications technicalSpecifications)
            implements RollingStockRequest {
        public Locomotive {
            Objects.requireNonNull(railway);
            Objects.requireNonNull(className);
        }
    }

    /**
     * It represents a passenger car rolling stock
     * @param railway the railway company
     * @param typeName the passenger car type name
     * @param roadNumber the identification marking for this passenger car
     * @param series the passenger car series
     * @param passengerCarType
     * @param livery the rolling stock livery description
     * @param serviceLevel the service level
     * @param lengthOverBuffers the length over buffers
     * @param technicalSpecifications the rolling stock technical specifications
     */
    record PassengerCar(
            RollingStockRailway railway,
            String typeName,
            String roadNumber,
            String series,
            PassengerCarType passengerCarType,
            String livery,
            ServiceLevel serviceLevel,
            LengthOverBuffers lengthOverBuffers,
            TechnicalSpecifications technicalSpecifications)
            implements RollingStockRequest {
        public PassengerCar {
            Objects.requireNonNull(railway);
            Objects.requireNonNull(typeName);
        }
    }

    /**
     * It represents a railcar rolling stock
     * @param railway the railway company
     * @param typeName the railcar type name
     * @param roadNumber the identification marking for this railcar
     * @param series the railcar series
     * @param depot the depot name
     * @param railcarType the railcar type
     * @param control the control
     * @param dccInterface the DCC interface
     * @param livery the rolling stock livery description
     * @param lengthOverBuffers the length over buffers
     * @param technicalSpecifications the rolling stock technical specifications
     */
    record Railcar(
            RollingStockRailway railway,
            String typeName,
            String roadNumber,
            String series,
            String depot,
            RailcarType railcarType,
            DccInterface dccInterface,
            Control control,
            String livery,
            LengthOverBuffers lengthOverBuffers,
            TechnicalSpecifications technicalSpecifications)
            implements RollingStockRequest {
        public Railcar {
            Objects.requireNonNull(railway);
            Objects.requireNonNull(typeName);
        }
    }
}
