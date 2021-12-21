import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        final int TWO_HOURS = 7_200_000;
        return airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(List::stream)
                .filter(flight -> flight.getType() == Flight.Type.DEPARTURE
                        && flight.getDate().getTime() > System.currentTimeMillis()
                        && flight.getDate().getTime() < System.currentTimeMillis() + TWO_HOURS)
                .collect(Collectors.toList());
    }
}