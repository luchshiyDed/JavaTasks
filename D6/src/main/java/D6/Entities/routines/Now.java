/*
 * This file is generated by jOOQ.
 */
package D6.Entities.routines;


import D6.Entities.Bookings;

import java.time.OffsetDateTime;

import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Now extends AbstractRoutine<OffsetDateTime> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>bookings.now.RETURN_VALUE</code>.
     */
    public static final Parameter<OffsetDateTime> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.TIMESTAMPWITHTIMEZONE(6), false, false);

    /**
     * Create a new routine call instance
     */
    public Now() {
        super("now", Bookings.BOOKINGS, SQLDataType.TIMESTAMPWITHTIMEZONE(6));

        setReturnParameter(RETURN_VALUE);
    }
}
