/*
 * This file is generated by jOOQ.
 */
package D6.Entities.tables.records;


import D6.Entities.tables.Seats;

import org.jooq.Field;
import org.jooq.Record2;
import org.jooq.Record3;
import org.jooq.Row3;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * Seats
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class SeatsRecord extends UpdatableRecordImpl<SeatsRecord> implements Record3<String, String, String> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>bookings.seats.aircraft_code</code>. Aircraft code, IATA
     */
    public void setAircraftCode(String value) {
        set(0, value);
    }

    /**
     * Getter for <code>bookings.seats.aircraft_code</code>. Aircraft code, IATA
     */
    public String getAircraftCode() {
        return (String) get(0);
    }

    /**
     * Setter for <code>bookings.seats.seat_no</code>. Seat number
     */
    public void setSeatNo(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>bookings.seats.seat_no</code>. Seat number
     */
    public String getSeatNo() {
        return (String) get(1);
    }

    /**
     * Setter for <code>bookings.seats.fare_conditions</code>. Travel class
     */
    public void setFareConditions(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>bookings.seats.fare_conditions</code>. Travel class
     */
    public String getFareConditions() {
        return (String) get(2);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record2<String, String> key() {
        return (Record2) super.key();
    }

    // -------------------------------------------------------------------------
    // Record3 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row3<String, String, String> fieldsRow() {
        return (Row3) super.fieldsRow();
    }

    @Override
    public Row3<String, String, String> valuesRow() {
        return (Row3) super.valuesRow();
    }

    @Override
    public Field<String> field1() {
        return Seats.SEATS.AIRCRAFT_CODE;
    }

    @Override
    public Field<String> field2() {
        return Seats.SEATS.SEAT_NO;
    }

    @Override
    public Field<String> field3() {
        return Seats.SEATS.FARE_CONDITIONS;
    }

    @Override
    public String component1() {
        return getAircraftCode();
    }

    @Override
    public String component2() {
        return getSeatNo();
    }

    @Override
    public String component3() {
        return getFareConditions();
    }

    @Override
    public String value1() {
        return getAircraftCode();
    }

    @Override
    public String value2() {
        return getSeatNo();
    }

    @Override
    public String value3() {
        return getFareConditions();
    }

    @Override
    public SeatsRecord value1(String value) {
        setAircraftCode(value);
        return this;
    }

    @Override
    public SeatsRecord value2(String value) {
        setSeatNo(value);
        return this;
    }

    @Override
    public SeatsRecord value3(String value) {
        setFareConditions(value);
        return this;
    }

    @Override
    public SeatsRecord values(String value1, String value2, String value3) {
        value1(value1);
        value2(value2);
        value3(value3);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached SeatsRecord
     */
    public SeatsRecord() {
        super(Seats.SEATS);
    }

    /**
     * Create a detached, initialised SeatsRecord
     */
    public SeatsRecord(String aircraftCode, String seatNo, String fareConditions) {
        super(Seats.SEATS);

        setAircraftCode(aircraftCode);
        setSeatNo(seatNo);
        setFareConditions(fareConditions);
    }
}
