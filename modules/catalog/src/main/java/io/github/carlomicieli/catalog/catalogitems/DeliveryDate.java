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

import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public sealed interface DeliveryDate {

    /**
     * Parse the input string as a delivery date
     * @param text the input string
     * @return a delivery date
     * @throws DeliveryDateFormatException if the text cannot be parsed
     */
    static DeliveryDate parse(CharSequence text) {
        return DeliveryDateParser.parseAsYearAndMonth(text)
                .or(() -> DeliveryDateParser.parseAsYearAndQuarter(text))
                .or(() -> DeliveryDateParser.parseAsYear(text))
                .orElseThrow(() -> new DeliveryDateFormatException(text));
    }

    /**
     * Return the year component for this delivery date
     * @return the year
     */
    default Year year() {
        if (this instanceof ByMonth byMonth) {
            return Year.of(byMonth.yearMonth().getYear());
        } else if (this instanceof ByYear byYear) {
            return byYear.year();
        } else if (this instanceof ByQuarter byQuarter) {
            return byQuarter.year();
        } else {
            throw new IllegalArgumentException("");
        }
    }

    /**
     * Return the month (if any) component for this delivery date
     * @return the month
     */
    default Optional<Month> month() {
        if (this instanceof ByMonth byMonth) {
            return Optional.of(byMonth.yearMonth().getMonth());
        } else {
            return Optional.empty();
        }
    }

    /**
     * Return the quarter number (if any) for this delivery date
     * @return the quarter number
     */
    default OptionalInt quarterNumber() {
        if (this instanceof ByQuarter byQuarter) {
            return OptionalInt.of(byQuarter.quarter().getNumber());
        } else {
            return OptionalInt.empty();
        }
    }
}

class DeliveryDateParser {
    private static final Pattern BY_YEAR_AND_MONTH_PATTERN =
            Pattern.compile("(\\d{4})/([01][0-9])", Pattern.CASE_INSENSITIVE);
    private static final Pattern BY_YEAR_AND_QUARTER_PATTERN =
            Pattern.compile("(\\d{4})/(Q[1-4])", Pattern.CASE_INSENSITIVE);
    private static final Pattern BY_YEAR_PATTERN = Pattern.compile("(\\d{4})", Pattern.CASE_INSENSITIVE);

    static Optional<DeliveryDate> parseAsYearAndMonth(CharSequence text) {
        return Optional.ofNullable(text).map(input -> {
            Matcher matcher = BY_YEAR_AND_MONTH_PATTERN.matcher(text);
            if (matcher.find()) {
                String year = matcher.group(1);
                String month = matcher.group(2);
                return new ByMonth(YearMonth.of(Integer.parseInt(year), Integer.parseInt(month)));
            } else {
                return null;
            }
        });
    }

    static Optional<DeliveryDate> parseAsYearAndQuarter(CharSequence text) {
        return Optional.ofNullable(text).map(input -> {
            Matcher matcher = BY_YEAR_AND_QUARTER_PATTERN.matcher(text);
            if (matcher.find()) {
                String year = matcher.group(1);
                String quarter = matcher.group(2);
                return new ByQuarter(Year.parse(year), ByQuarter.Quarter.valueOf(quarter));
            } else {
                return null;
            }
        });
    }

    static Optional<DeliveryDate> parseAsYear(CharSequence text) {
        return Optional.ofNullable(text).map(input -> {
            Matcher matcher = BY_YEAR_PATTERN.matcher(text);
            if (matcher.find()) {
                String year = matcher.group(1);
                return new ByYear(Year.parse(year));
            } else {
                return null;
            }
        });
    }
}

/**
 * A delivery date by year and month
 * @param yearMonth the year/month
 */
record ByMonth(YearMonth yearMonth) implements DeliveryDate {
    @Override
    public String toString() {
        return String.format(
                "%d/%02d", yearMonth.getYear(), yearMonth.getMonth().getValue());
    }
}

/**
 * A delivery date by year
 * @param year the year
 */
record ByYear(Year year) implements DeliveryDate {
    @Override
    public String toString() {
        return String.format("%d", year.getValue());
    }
}

/**
 * A delivery date by year and quarter
 * @param year the year
 * @param quarter the quarter
 */
record ByQuarter(Year year, Quarter quarter) implements DeliveryDate {
    enum Quarter {
        Q1(1),
        Q2(2),
        Q3(3),
        Q4(4);

        private final int number;

        Quarter(int number) {
            this.number = number;
        }

        int getNumber() {
            return this.number;
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%s", year.getValue(), quarter.name());
    }
}
