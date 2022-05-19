package geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

import java.util.Objects;

public class TestGeoService {

    @Test
    void testGeoServiceRus() {
        GeoService geoService = new GeoServiceImpl( );
        Location result = geoService.byIp("172.0.32.11");
        Location expected = new Location("Moscow", Country.RUSSIA, "Lenina", 15);

        Assertions.assertEquals(result, expected);
    }

    @Test
    void testGeoServiceUsa() {
        GeoService geoService = new GeoServiceImpl( );
        Location result = geoService.byIp("96.44.183.149");
        Location expected = new Location("New York", Country.USA, " 10th Avenue", 32);

        Assertions.assertEquals(result, expected);

    }


}
