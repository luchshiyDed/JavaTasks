/*
 * This file is generated by jOOQ.
 */
package D6.Entities.tables.records;


import D6.Entities.tables.FlightsV;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

import org.jooq.Field;
import org.jooq.Record20;
import org.jooq.Row20;
import org.jooq.impl.TableRecordImpl;
import org.jooq.types.YearToSecond;


/**
 * Flights (extended)
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FlightsVRecord extends TableRecordImpl<FlightsVRecord> implements Record20<Integer, String, OffsetDateTime, LocalDateTime, OffsetDateTime, LocalDateTime, YearToSecond, String, String, String, String, String, String, String, String, OffsetDateTime, LocalDateTime, OffsetDateTime, LocalDateTime, YearToSecond> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>bookings.flights_v.flight_id</code>. Flight ID
     */
    public void setFlightId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>bookings.flights_v.flight_id</code>. Flight ID
     */
    public Integer getFlightId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>bookings.flights_v.flight_no</code>. Flight number
     */
    public void setFlightNo(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bookings.flights_v.flight_no</code>. Flight number
     */
    public String getFlightNo() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bookings.flights_v.scheduled_departure</code>. Scheduled
     * departure time
     */
    public void setScheduledDeparture(OffsetDateTime value) {
        set(2, value);
    }

    /**
     * Getter for <code>bookings.flights_v.scheduled_departure</code>. Scheduled
     * departure time
     */
    public OffsetDateTime getScheduledDeparture() {
        return (OffsetDateTime) get(2);
    }

    /**
     * Setter for <code>bookings.flights_v.scheduled_departure_local</code>.
     * Scheduled departure time, local time at the point of departure
     */
    public void setScheduledDepartureLocal(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>bookings.flights_v.scheduled_departure_local</code>.
     * Scheduled departure time, local time at the point of departure
     */
    public LocalDateTime getScheduledDepartureLocal() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>bookings.flights_v.scheduled_arrival</code>. Scheduled
     * arrival time
     */
    public void setScheduledArrival(OffsetDateTime value) {
        set(4, value);
    }

    /**
     * Getter for <code>bookings.flights_v.scheduled_arrival</code>. Scheduled
     * arrival time
     */
    public OffsetDateTime getScheduledArrival() {
        return (OffsetDateTime) get(4);
    }

    /**
     * Setter for <code>bookings.flights_v.scheduled_arrival_local</code>.
     * Scheduled arrival time, local time at the point of destination
     */
    public void setScheduledArrivalLocal(LocalDateTime value) {
        set(5, value);
    }

    /**
     * Getter for <code>bookings.flights_v.scheduled_arrival_local</code>.
     * Scheduled arrival time, local time at the point of destination
     */
    public LocalDateTime getScheduledArrivalLocal() {
        return (LocalDateTime) get(5);
    }

    /**
     * Setter for <code>bookings.flights_v.scheduled_duration</code>. Scheduled
     * flight duration
     */
    public void setScheduledDuration(YearToSecond value) {
        set(6, value);
    }

    /**
     * Getter for <code>bookings.flights_v.scheduled_duration</code>. Scheduled
     * flight duration
     */
    public YearToSecond getScheduledDuration() {
        return (YearToSecond) get(6);
    }

    /**
     * Setter for <code>bookings.flights_v.departure_airport</code>. Deprature
     * airport code
     */
    public void setDepartureAirport(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>bookings.flights_v.departure_airport</code>. Deprature
     * airport code
     */
    public String getDepartureAirport() {
        return (String) get(7);
    }

    /**
     * Setter for <code>bookings.flights_v.departure_airport_name</code>.
     * Departure airport name
     */
    public void setDepartureAirportName(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>bookings.flights_v.departure_airport_name</code>.
     * Departure airport name
     */
    public String getDepartureAirportName() {
        return (String) get(8);
    }

    /**
     * Setter for <code>bookings.flights_v.departure_city</code>. City of
     * departure
     */
    public void setDepartureCity(String value) {
        set(9, value);
    }

    /**
     * Getter for <code>bookings.flights_v.departure_city</code>. City of
     * departure
     */
    public String getDepartureCity() {
        return (String) get(9);
    }

    /**
     * Setter for <code>bookings.flights_v.arrival_airport</code>. Arrival
     * airport code
     */
    public void setArrivalAirport(String value) {
        set(10, value);
    }

    /**
     * Getter for <code>bookings.flights_v.arrival_airport</code>. Arrival
     * airport code
     */
    public String getArrivalAirport() {
        return (String) get(10);
    }

    /**
     * Setter for <code>bookings.flights_v.arrival_airport_name</code>. Arrival
     * airport name
     */
    public void setArrivalAirportName(String value) {
        set(11, value);
    }

    /**
     * Getter for <code>bookings.flights_v.arrival_airport_name</code>. Arrival
     * airport name
     */
    public String getArrivalAirportName() {
        return (String) get(11);
    }

    /**
     * Setter for <code>bookings.flights_v.arrival_city</code>. City of arrival
     */
    public void setArrivalCity(String value) {
        set(12, value);
    }

    /**
     * Getter for <code>bookings.flights_v.arrival_city</code>. City of arrival
     */
    public String getArrivalCity() {
        return (String) get(12);
    }

    /**
     * Setter for <code>bookings.flights_v.status</code>. Flight status
     */
    public void setStatus(String value) {
        set(13, value);
    }

    /**
     * Getter for <code>bookings.flights_v.status</code>. Flight status
     */
    public String getStatus() {
        return (String) get(13);
    }

    /**
     * Setter for <code>bookings.flights_v.aircraft_code</code>. Aircraft code,
     * IATA
     */
    public void setAircraftCode(String value) {
        set(14, value);
    }

    /**
     * Getter for <code>bookings.flights_v.aircraft_code</code>. Aircraft code,
     * IATA
     */
    public String getAircraftCode() {
        return (String) get(14);
    }

    /**
     * Setter for <code>bookings.flights_v.actual_departure</code>. Actual
     * departure time
     */
    public void setActualDeparture(OffsetDateTime value) {
        set(15, value);
    }

    /**
     * Getter for <code>bookings.flights_v.actual_departure</code>. Actual
     * departure time
     */
    public OffsetDateTime getActualDeparture() {
        return (OffsetDateTime) get(15);
    }

    /**
     * Setter for <code>bookings.flights_v.actual_departure_local</code>. Actual
     * departure time, local time at the point of departure
     */
    public void setActualDepartureLocal(LocalDateTime value) {
        set(16, value);
    }

    /**
     * Getter for <code>bookings.flights_v.actual_departure_local</code>. Actual
     * departure time, local time at the point of departure
     */
    public LocalDateTime getActualDepartureLocal() {
        return (LocalDateTime) get(16);
    }

    /**
     * Setter for <code>bookings.flights_v.actual_arrival</code>. Actual arrival
     * time
     */
    public void setActualArrival(OffsetDateTime value) {
        set(17, value);
    }

    /**
     * Getter for <code>bookings.flights_v.actual_arrival</code>. Actual arrival
     * time
     */
    public OffsetDateTime getActualArrival() {
        return (OffsetDateTime) get(17);
    }

    /**
     * Setter for <code>bookings.flights_v.actual_arrival_local</code>. Actual
     * arrival time, local time at the point of destination
     */
    public void setActualArrivalLocal(LocalDateTime value) {
        set(18, value);
    }

    /**
     * Getter for <code>bookings.flights_v.actual_arrival_local</code>. Actual
     * arrival time, local time at the point of destination
     */
    public LocalDateTime getActualArrivalLocal() {
        return (LocalDateTime) get(18);
    }

    /**
     * Setter for <code>bookings.flights_v.actual_duration</code>. Actual flight
     * duration
     */
    public void setActualDuration(YearToSecond value) {
        set(19, value);
    }

    /**
     * Getter for <code>bookings.flights_v.actual_duration</code>. Actual flight
     * duration
     */
    public YearToSecond getActualDuration() {
        return (YearToSecond) get(19);
    }

    // -------------------------------------------------------------------------
    // Record20 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row20<Integer, String, OffsetDateTime, LocalDateTime, OffsetDateTime, LocalDateTime, YearToSecond, String, String, String, String, String, String, String, String, OffsetDateTime, LocalDateTime, OffsetDateTime, LocalDateTime, YearToSecond> fieldsRow() {
        return (Row20) super.fieldsRow();
    }

    @Override
    public Row20<Integer, String, OffsetDateTime, LocalDateTime, OffsetDateTime, LocalDateTime, YearToSecond, String, String, String, String, String, String, String, String, OffsetDateTime, LocalDateTime, OffsetDateTime, LocalDateTime, YearToSecond> valuesRow() {
        return (Row20) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return FlightsV.FLIGHTS_V.FLIGHT_ID;
    }

    @Override
    public Field<String> field2() {
        return FlightsV.FLIGHTS_V.FLIGHT_NO;
    }

    @Override
    public Field<OffsetDateTime> field3() {
        return FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE_LOCAL;
    }

    @Override
    public Field<OffsetDateTime> field5() {
        return FlightsV.FLIGHTS_V.SCHEDULED_ARRIVAL;
    }

    @Override
    public Field<LocalDateTime> field6() {
        return FlightsV.FLIGHTS_V.SCHEDULED_ARRIVAL_LOCAL;
    }

    @Override
    public Field<YearToSecond> field7() {
        return FlightsV.FLIGHTS_V.SCHEDULED_DURATION;
    }

    @Override
    public Field<String> field8() {
        return FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT;
    }

    @Override
    public Field<String> field9() {
        return FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME;
    }

    @Override
    public Field<String> field10() {
        return FlightsV.FLIGHTS_V.DEPARTURE_CITY;
    }

    @Override
    public Field<String> field11() {
        return FlightsV.FLIGHTS_V.ARRIVAL_AIRPORT;
    }

    @Override
    public Field<String> field12() {
        return FlightsV.FLIGHTS_V.ARRIVAL_AIRPORT_NAME;
    }

    @Override
    public Field<String> field13() {
        return FlightsV.FLIGHTS_V.ARRIVAL_CITY;
    }

    @Override
    public Field<String> field14() {
        return FlightsV.FLIGHTS_V.STATUS;
    }

    @Override
    public Field<String> field15() {
        return FlightsV.FLIGHTS_V.AIRCRAFT_CODE;
    }

    @Override
    public Field<OffsetDateTime> field16() {
        return FlightsV.FLIGHTS_V.ACTUAL_DEPARTURE;
    }

    @Override
    public Field<LocalDateTime> field17() {
        return FlightsV.FLIGHTS_V.ACTUAL_DEPARTURE_LOCAL;
    }

    @Override
    public Field<OffsetDateTime> field18() {
        return FlightsV.FLIGHTS_V.ACTUAL_ARRIVAL;
    }

    @Override
    public Field<LocalDateTime> field19() {
        return FlightsV.FLIGHTS_V.ACTUAL_ARRIVAL_LOCAL;
    }

    @Override
    public Field<YearToSecond> field20() {
        return FlightsV.FLIGHTS_V.ACTUAL_DURATION;
    }

    @Override
    public Integer component1() {
        return getFlightId();
    }

    @Override
    public String component2() {
        return getFlightNo();
    }

    @Override
    public OffsetDateTime component3() {
        return getScheduledDeparture();
    }

    @Override
    public LocalDateTime component4() {
        return getScheduledDepartureLocal();
    }

    @Override
    public OffsetDateTime component5() {
        return getScheduledArrival();
    }

    @Override
    public LocalDateTime component6() {
        return getScheduledArrivalLocal();
    }

    @Override
    public YearToSecond component7() {
        return getScheduledDuration();
    }

    @Override
    public String component8() {
        return getDepartureAirport();
    }

    @Override
    public String component9() {
        return getDepartureAirportName();
    }

    @Override
    public String component10() {
        return getDepartureCity();
    }

    @Override
    public String component11() {
        return getArrivalAirport();
    }

    @Override
    public String component12() {
        return getArrivalAirportName();
    }

    @Override
    public String component13() {
        return getArrivalCity();
    }

    @Override
    public String component14() {
        return getStatus();
    }

    @Override
    public String component15() {
        return getAircraftCode();
    }

    @Override
    public OffsetDateTime component16() {
        return getActualDeparture();
    }

    @Override
    public LocalDateTime component17() {
        return getActualDepartureLocal();
    }

    @Override
    public OffsetDateTime component18() {
        return getActualArrival();
    }

    @Override
    public LocalDateTime component19() {
        return getActualArrivalLocal();
    }

    @Override
    public YearToSecond component20() {
        return getActualDuration();
    }

    @Override
    public Integer value1() {
        return getFlightId();
    }

    @Override
    public String value2() {
        return getFlightNo();
    }

    @Override
    public OffsetDateTime value3() {
        return getScheduledDeparture();
    }

    @Override
    public LocalDateTime value4() {
        return getScheduledDepartureLocal();
    }

    @Override
    public OffsetDateTime value5() {
        return getScheduledArrival();
    }

    @Override
    public LocalDateTime value6() {
        return getScheduledArrivalLocal();
    }

    @Override
    public YearToSecond value7() {
        return getScheduledDuration();
    }

    @Override
    public String value8() {
        return getDepartureAirport();
    }

    @Override
    public String value9() {
        return getDepartureAirportName();
    }

    @Override
    public String value10() {
        return getDepartureCity();
    }

    @Override
    public String value11() {
        return getArrivalAirport();
    }

    @Override
    public String value12() {
        return getArrivalAirportName();
    }

    @Override
    public String value13() {
        return getArrivalCity();
    }

    @Override
    public String value14() {
        return getStatus();
    }

    @Override
    public String value15() {
        return getAircraftCode();
    }

    @Override
    public OffsetDateTime value16() {
        return getActualDeparture();
    }

    @Override
    public LocalDateTime value17() {
        return getActualDepartureLocal();
    }

    @Override
    public OffsetDateTime value18() {
        return getActualArrival();
    }

    @Override
    public LocalDateTime value19() {
        return getActualArrivalLocal();
    }

    @Override
    public YearToSecond value20() {
        return getActualDuration();
    }

    @Override
    public FlightsVRecord value1(Integer value) {
        setFlightId(value);
        return this;
    }

    @Override
    public FlightsVRecord value2(String value) {
        setFlightNo(value);
        return this;
    }

    @Override
    public FlightsVRecord value3(OffsetDateTime value) {
        setScheduledDeparture(value);
        return this;
    }

    @Override
    public FlightsVRecord value4(LocalDateTime value) {
        setScheduledDepartureLocal(value);
        return this;
    }

    @Override
    public FlightsVRecord value5(OffsetDateTime value) {
        setScheduledArrival(value);
        return this;
    }

    @Override
    public FlightsVRecord value6(LocalDateTime value) {
        setScheduledArrivalLocal(value);
        return this;
    }

    @Override
    public FlightsVRecord value7(YearToSecond value) {
        setScheduledDuration(value);
        return this;
    }

    @Override
    public FlightsVRecord value8(String value) {
        setDepartureAirport(value);
        return this;
    }

    @Override
    public FlightsVRecord value9(String value) {
        setDepartureAirportName(value);
        return this;
    }

    @Override
    public FlightsVRecord value10(String value) {
        setDepartureCity(value);
        return this;
    }

    @Override
    public FlightsVRecord value11(String value) {
        setArrivalAirport(value);
        return this;
    }

    @Override
    public FlightsVRecord value12(String value) {
        setArrivalAirportName(value);
        return this;
    }

    @Override
    public FlightsVRecord value13(String value) {
        setArrivalCity(value);
        return this;
    }

    @Override
    public FlightsVRecord value14(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public FlightsVRecord value15(String value) {
        setAircraftCode(value);
        return this;
    }

    @Override
    public FlightsVRecord value16(OffsetDateTime value) {
        setActualDeparture(value);
        return this;
    }

    @Override
    public FlightsVRecord value17(LocalDateTime value) {
        setActualDepartureLocal(value);
        return this;
    }

    @Override
    public FlightsVRecord value18(OffsetDateTime value) {
        setActualArrival(value);
        return this;
    }

    @Override
    public FlightsVRecord value19(LocalDateTime value) {
        setActualArrivalLocal(value);
        return this;
    }

    @Override
    public FlightsVRecord value20(YearToSecond value) {
        setActualDuration(value);
        return this;
    }

    @Override
    public FlightsVRecord values(Integer value1, String value2, OffsetDateTime value3, LocalDateTime value4, OffsetDateTime value5, LocalDateTime value6, YearToSecond value7, String value8, String value9, String value10, String value11, String value12, String value13, String value14, String value15, OffsetDateTime value16, LocalDateTime value17, OffsetDateTime value18, LocalDateTime value19, YearToSecond value20) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        value13(value13);
        value14(value14);
        value15(value15);
        value16(value16);
        value17(value17);
        value18(value18);
        value19(value19);
        value20(value20);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached FlightsVRecord
     */
    public FlightsVRecord() {
        super(FlightsV.FLIGHTS_V);
    }

    /**
     * Create a detached, initialised FlightsVRecord
     */
    public FlightsVRecord(Integer flightId, String flightNo, OffsetDateTime scheduledDeparture, LocalDateTime scheduledDepartureLocal, OffsetDateTime scheduledArrival, LocalDateTime scheduledArrivalLocal, YearToSecond scheduledDuration, String departureAirport, String departureAirportName, String departureCity, String arrivalAirport, String arrivalAirportName, String arrivalCity, String status, String aircraftCode, OffsetDateTime actualDeparture, LocalDateTime actualDepartureLocal, OffsetDateTime actualArrival, LocalDateTime actualArrivalLocal, YearToSecond actualDuration) {
        super(FlightsV.FLIGHTS_V);

        setFlightId(flightId);
        setFlightNo(flightNo);
        setScheduledDeparture(scheduledDeparture);
        setScheduledDepartureLocal(scheduledDepartureLocal);
        setScheduledArrival(scheduledArrival);
        setScheduledArrivalLocal(scheduledArrivalLocal);
        setScheduledDuration(scheduledDuration);
        setDepartureAirport(departureAirport);
        setDepartureAirportName(departureAirportName);
        setDepartureCity(departureCity);
        setArrivalAirport(arrivalAirport);
        setArrivalAirportName(arrivalAirportName);
        setArrivalCity(arrivalCity);
        setStatus(status);
        setAircraftCode(aircraftCode);
        setActualDeparture(actualDeparture);
        setActualDepartureLocal(actualDepartureLocal);
        setActualArrival(actualArrival);
        setActualArrivalLocal(actualArrivalLocal);
        setActualDuration(actualDuration);
    }
}
