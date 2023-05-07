/*
 * This file is generated by jOOQ.
 */
package D6.Entities.tables;


import D6.Entities.Bookings;
import D6.Entities.tables.records.AirportsDataRecord;
import D6.Entities.Keys;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.JSONB;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * Airports (internal data)
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class AirportsData extends TableImpl<AirportsDataRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>bookings.airports_data</code>
     */
    public static final AirportsData AIRPORTS_DATA = new AirportsData();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AirportsDataRecord> getRecordType() {
        return AirportsDataRecord.class;
    }

    /**
     * The column <code>bookings.airports_data.airport_code</code>. Airport code
     */
    public final TableField<AirportsDataRecord, String> AIRPORT_CODE = createField(DSL.name("airport_code"), SQLDataType.CHAR(3).nullable(false), this, "Airport code");

    /**
     * The column <code>bookings.airports_data.airport_name</code>. Airport name
     */
    public final TableField<AirportsDataRecord, JSONB> AIRPORT_NAME = createField(DSL.name("airport_name"), SQLDataType.JSONB.nullable(false), this, "Airport name");

    /**
     * The column <code>bookings.airports_data.city</code>. City
     */
    public final TableField<AirportsDataRecord, JSONB> CITY = createField(DSL.name("city"), SQLDataType.JSONB.nullable(false), this, "City");

    /**
     * @deprecated Unknown data type. If this is a qualified, user-defined type,
     * it may have been excluded from code generation. If this is a built-in
     * type, you can define an explicit {@link org.jooq.Binding} to specify how
     * this type should be handled. Deprecation can be turned off using
     * {@literal <deprecationOnUnknownTypes/>} in your code generator
     * configuration.
     */
    @Deprecated
    public final TableField<AirportsDataRecord, Object> COORDINATES = createField(DSL.name("coordinates"), org.jooq.impl.DefaultDataType.getDefaultDataType("\"pg_catalog\".\"point\"").nullable(false), this, "Airport coordinates (longitude and latitude)");

    /**
     * The column <code>bookings.airports_data.timezone</code>. Airport time
     * zone
     */
    public final TableField<AirportsDataRecord, String> TIMEZONE = createField(DSL.name("timezone"), SQLDataType.CLOB.nullable(false), this, "Airport time zone");

    private AirportsData(Name alias, Table<AirportsDataRecord> aliased) {
        this(alias, aliased, null);
    }

    private AirportsData(Name alias, Table<AirportsDataRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment("Airports (internal data)"), TableOptions.table());
    }

    /**
     * Create an aliased <code>bookings.airports_data</code> table reference
     */
    public AirportsData(String alias) {
        this(DSL.name(alias), AIRPORTS_DATA);
    }

    /**
     * Create an aliased <code>bookings.airports_data</code> table reference
     */
    public AirportsData(Name alias) {
        this(alias, AIRPORTS_DATA);
    }

    /**
     * Create a <code>bookings.airports_data</code> table reference
     */
    public AirportsData() {
        this(DSL.name("airports_data"), null);
    }

    public <O extends Record> AirportsData(Table<O> child, ForeignKey<O, AirportsDataRecord> key) {
        super(child, key, AIRPORTS_DATA);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Bookings.BOOKINGS;
    }

    @Override
    public UniqueKey<AirportsDataRecord> getPrimaryKey() {
        return Keys.AIRPORTS_DATA_PKEY;
    }

    @Override
    public AirportsData as(String alias) {
        return new AirportsData(DSL.name(alias), this);
    }

    @Override
    public AirportsData as(Name alias) {
        return new AirportsData(alias, this);
    }

    @Override
    public AirportsData as(Table<?> alias) {
        return new AirportsData(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public AirportsData rename(String name) {
        return new AirportsData(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public AirportsData rename(Name name) {
        return new AirportsData(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public AirportsData rename(Table<?> name) {
        return new AirportsData(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<String, JSONB, JSONB, Object, String> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super String, ? super JSONB, ? super JSONB, ? super Object, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super String, ? super JSONB, ? super JSONB, ? super Object, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
