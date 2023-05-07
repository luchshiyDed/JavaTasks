/*
 * This file is generated by jOOQ.
 */
package D6.Entities;


import D6.Entities.routines.Lang;
import D6.Entities.routines.Now;

import java.time.OffsetDateTime;

import org.jooq.Configuration;
import org.jooq.Field;


/**
 * Convenience access to all stored procedures and functions in bookings.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>bookings.lang</code>
     */
    public static String lang(
          Configuration configuration
    ) {
        Lang f = new Lang();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>bookings.lang</code> as a field.
     */
    public static Field<String> lang() {
        Lang f = new Lang();

        return f.asField();
    }

    /**
     * Call <code>bookings.now</code>
     */
    public static OffsetDateTime now(
          Configuration configuration
    ) {
        Now f = new Now();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>bookings.now</code> as a field.
     */
    public static Field<OffsetDateTime> now() {
        Now f = new Now();

        return f.asField();
    }
}
