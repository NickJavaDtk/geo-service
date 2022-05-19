package sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSender;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;
import java.util.Map;

class TestMessageService {
    @Test
    void testMsgServiceRus() {
        GeoService geoServiceMock = Mockito.mock(GeoService.class);
        Mockito.when(geoServiceMock.byIp(Mockito.anyString()))
                .thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService lServiceMock = Mockito.mock(LocalizationService.class);
        Mockito.when(lServiceMock.locale(Mockito.any(Country.class))).thenReturn("Добро пожаловать");

        HashMap<String, String> testRusIP = new HashMap<String, String>(  );
        testRusIP.put("x-real-ip", "172.17.241.18");

        MessageSender msgSender = new MessageSenderImpl(geoServiceMock, lServiceMock);
        String result = msgSender.send(testRusIP);

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected =messageSender.send(testRusIP);

        Assertions.assertEquals(result, expected);


    }
    @Test
    void testMsgServiceUsa() {
        GeoService geoServiceMock = Mockito.mock(GeoService.class);
        Mockito.when(geoServiceMock.byIp(Mockito.anyString()))
                .thenReturn(new Location("New York", Country.USA, null,  0));

        LocalizationService lServiceMock = Mockito.mock(LocalizationService.class);
        Mockito.when(lServiceMock.locale(Mockito.any(Country.class))).thenReturn("Welcome");

        HashMap<String, String> testRusIP = new HashMap<String, String>(  );
        testRusIP.put("x-real-ip", "96.17.241.18");

        MessageSender msgSender = new MessageSenderImpl(geoServiceMock, lServiceMock);
        String result = msgSender.send(testRusIP);

        GeoService geoService = new GeoServiceImpl();
        LocalizationService localizationService = new LocalizationServiceImpl();
        MessageSender messageSender = new MessageSenderImpl(geoService, localizationService);
        String expected =messageSender.send(testRusIP);

        Assertions.assertEquals(result, expected);
    }
}

