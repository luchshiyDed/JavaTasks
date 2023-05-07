package D6;


import D6.Entities.RequestsDTO.FlightDTO;
import D6.Entities.RespocesDTO.AirportsDTO;
import D6.Entities.RespocesDTO.CityDTO;
import D6.Entities.RespocesDTO.ScheduledDTO;
import D6.Entities.tables.Airports;
import D6.Entities.tables.FlightsV;
import D6.Entities.tables.Routes;
import D6.Entities.tables.Seats;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.QOM;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DataRepository {
    private static DataRepository dataRepository;
    private final DSLContext context;
    public DSLContext getContext() {
        return context;
    }
//    private int[][] matrix; // 1- откуда вылетел 2-куда
//    private HashMap<String,Integer> stringToIndex;
//    private HashMap<Integer,String> indexToString;
//    //private HashMap<String,HashMap<String,Integer>> airportsConnectionMatrix;
//    private void fillMatrix(){
//        List<Record1<String>> airports= context.select(Airports.AIRPORTS.AIRPORT_NAME)
//                .distinctOn(Airports.AIRPORTS.AIRPORT_NAME)
//                .from(Airports.AIRPORTS).fetch();
//        matrix= new int[airports.size()][airports.size()];
//        stringToIndex = new HashMap<>(airports.size());
//        int i=0;
//        for (Record1 record:airports){
//            stringToIndex.put(record.getValue(Airports.AIRPORTS.AIRPORT_NAME),i);
//            indexToString.put(i,record.getValue(Airports.AIRPORTS.AIRPORT_NAME));
//            i++;
//        }
//         Result<Record2<String, String>> routs=context
//                 .select(Routes.ROUTES.ARRIVAL_AIRPORT_NAME,Routes.ROUTES.DEPARTURE_AIRPORT_NAME)
//                 .from(Routes.ROUTES).fetch();
//        for(Record2 record:routs){
//            matrix[stringToIndex.get(record.getValue(Routes.ROUTES.DEPARTURE_AIRPORT_NAME))]
//                    [stringToIndex.get(record.getValue(Routes.ROUTES.ARRIVAL_AIRPORT_NAME))]++;
//        }
//
//    }
//  private int getFlightsCnt(String airport1,String airport2){return matrix[stringToIndex.get(airport1)][stringToIndex.get(airport2)];}
    private DataRepository() {
        String userName = "postgres";
        String password = "chmo";
        String url = "jdbc:postgresql://localhost:5432/demo";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, userName, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        context = DSL.using(conn, SQLDialect.POSTGRES);
    }

    public static DataRepository getInstance() {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
        }
        return dataRepository;

    }

    public Iterable<AirportsDTO> getAirports() {
        ArrayList<AirportsDTO> result = new ArrayList<>();
        context.select().from(Airports.AIRPORTS).fetch().forEach(record -> result.add(
                new AirportsDTO(
                        record.getValue(Airports.AIRPORTS.AIRPORT_CODE),
                        record.getValue(Airports.AIRPORTS.AIRPORT_NAME),
                        record.getValue(Airports.AIRPORTS.CITY),
                        record.getValue(Airports.AIRPORTS.TIMEZONE)
                )));
        return result;
    }

    public Iterable<CityDTO> getCities() {
        ArrayList<CityDTO> result = new ArrayList<>();
        context.select(Airports.AIRPORTS.CITY).distinctOn(Airports.AIRPORTS.CITY).from(Airports.AIRPORTS).fetch().forEach(record -> result.add(new CityDTO(
                record.getValue(Airports.AIRPORTS.CITY))
        ));
        return result;
    }

    public Iterable<AirportsDTO> getAirportsInCity(String cityName) {
        ArrayList<AirportsDTO> result = new ArrayList<>();
        context.select().from(Airports.AIRPORTS).where(Airports.AIRPORTS.CITY.equal(cityName)).fetch().forEach(record -> result.add(
                new AirportsDTO(
                        record.getValue(Airports.AIRPORTS.AIRPORT_CODE),
                        record.getValue(Airports.AIRPORTS.AIRPORT_NAME),
                        record.getValue(Airports.AIRPORTS.CITY),
                        record.getValue(Airports.AIRPORTS.TIMEZONE)
                )));
        return result;
    }

    public Iterable<ScheduledDTO> getAirportArrivals(String airport_name) {
        ArrayList<ScheduledDTO> result = new ArrayList<>();
        context.select(FlightsV.FLIGHTS_V.SCHEDULED_ARRIVAL,
                        FlightsV.FLIGHTS_V.FLIGHT_NO,
                        FlightsV.FLIGHTS_V.STATUS,
                        FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME,
                        FlightsV.FLIGHTS_V.DEPARTURE_CITY,
                        FlightsV.FLIGHTS_V.SCHEDULED_ARRIVAL_LOCAL
                )
                .from(FlightsV.FLIGHTS_V)
                .where(FlightsV.FLIGHTS_V.ARRIVAL_AIRPORT_NAME.equal(airport_name),
                        FlightsV.FLIGHTS_V.STATUS.equal("Scheduled")).fetch().forEach(record -> result.add(
                        new ScheduledDTO(
                                record.getValue(FlightsV.FLIGHTS_V.DEPARTURE_CITY),
                                record.getValue( FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME),
                                record.getValue(FlightsV.FLIGHTS_V.FLIGHT_NO),
                                record.getValue(FlightsV.FLIGHTS_V.SCHEDULED_ARRIVAL),
                                record.getValue(FlightsV.FLIGHTS_V.SCHEDULED_ARRIVAL_LOCAL)

                        )));
        return result;
    }

    public Iterable<ScheduledDTO> getAirportDepartures(String airport_name) {
        ArrayList<ScheduledDTO> result = new ArrayList<>();
        context.select(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE,
                        FlightsV.FLIGHTS_V.FLIGHT_NO,
                        FlightsV.FLIGHTS_V.STATUS,
                        FlightsV.FLIGHTS_V.ARRIVAL_AIRPORT_NAME,
                        FlightsV.FLIGHTS_V.ARRIVAL_CITY,
                        FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE_LOCAL
                )
                .from(FlightsV.FLIGHTS_V)
                .where(FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME.equal(airport_name),
                        FlightsV.FLIGHTS_V.STATUS.equal("Scheduled")).fetch().forEach(record -> result.add(
                        new ScheduledDTO(
                                record.getValue(FlightsV.FLIGHTS_V.ARRIVAL_CITY),
                                record.getValue(FlightsV.FLIGHTS_V.ARRIVAL_AIRPORT_NAME),
                                record.getValue(FlightsV.FLIGHTS_V.FLIGHT_NO),
                                record.getValue(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE),
                                record.getValue(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE_LOCAL)

                        )));
        return result;
    }


    public Iterable<ScheduledDTO> getAirportDeparturesByDate(String airport_name,LocalDateTime from,LocalDateTime to, String fare) {
        ArrayList<ScheduledDTO> result = new ArrayList<>();
        context.select(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE,
                        FlightsV.FLIGHTS_V.FLIGHT_NO,
                        FlightsV.FLIGHTS_V.STATUS,
                        FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME,
                        FlightsV.FLIGHTS_V.ARRIVAL_AIRPORT_NAME,
                        FlightsV.FLIGHTS_V.DEPARTURE_CITY,
                        FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE_LOCAL
                )
                .from(FlightsV.FLIGHTS_V).fullJoin(Seats.SEATS).on(FlightsV.FLIGHTS_V.AIRCRAFT_CODE.equal(Seats.SEATS.AIRCRAFT_CODE))
                .where(FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME.equal(airport_name)
                                .and(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE_LOCAL.between(from,to))
                                .and(Seats.SEATS.FARE_CONDITIONS.contains(fare)).and(
                        FlightsV.FLIGHTS_V.STATUS.equal("Scheduled"))).fetch().forEach(record -> result.add(
                        new ScheduledDTO(
                                record.getValue(FlightsV.FLIGHTS_V.DEPARTURE_CITY),
                                record.getValue(FlightsV.FLIGHTS_V.DEPARTURE_AIRPORT_NAME),
                                record.getValue(FlightsV.FLIGHTS_V.FLIGHT_NO),
                                record.getValue(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE),
                                record.getValue(FlightsV.FLIGHTS_V.SCHEDULED_DEPARTURE_LOCAL)

                        )));
        return result;
    }
//    private Iterable<?> findRout(String from, String destination, LocalDateTime firstDate,LocalDateTime toDate, Integer limit,String fare){
//
//        ArrayList<ScheduledDTO> departures = (ArrayList<ScheduledDTO>) getAirportDeparturesByDate(from,firstDate,toDate,fare);
//        ArrayList<ArrayList<ScheduledDTO>>  possibleRouts = new ArrayList<>();
//        ArrayList<ArrayList<ScheduledDTO>> finalRouts=new ArrayList<>();
//        for (int i = 0; i < limit+1; i++) {
//            for(ScheduledDTO departure: departures){
//                possibleRouts.add()
//                if(departure.getAirport_name().equals(destination)){
//
//                }
//            }
//
//        }
//    }
    public Iterable<?> getRout(FlightDTO flightDTO){
        //finalRouts = new ArrayList<>();

        return null;
    }
}
