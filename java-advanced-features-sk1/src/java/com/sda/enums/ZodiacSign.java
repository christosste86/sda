package com.sda.enums;

public enum ZodiacSign {
    ARIES(3, 21, 4, 19),
    TAURUS(4, 20, 5, 20),
    GEMINI(5, 21, 6, 20),
    CANCER(21, 6, 7, 22),
    LEO(7, 23, 8, 22),
    VIRGO(8, 23, 9, 22),
    LIBRA(9, 23, 10, 22),
    SCORPIO(10, 23, 11, 21),
    SAGITARIUS(11, 22, 12, 21),
    CAPRICORN(12, 22, 1, 19),
    AQUARIUS(1, 20, 2, 18),
    PISCES(2, 19, 3, 20);

    private final int startMount;
    private final int startDay;

    private final int endMount;
    private final int endDay;

    ZodiacSign(int startMount, int startDay, int endMount, int endDay) {
        this.startMount = startMount;
        this.startDay = startDay;
        this.endMount = endMount;
        this.endDay = endDay;
    }

    public int getStartMount() {
        return startMount;
    }

    public int getStartDay() {
        return startDay;
    }

    public boolean isDateInRange(int month, int day) {
        return startMount <= month && endMount >= month && startDay <= day && endDay >= day;

    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
