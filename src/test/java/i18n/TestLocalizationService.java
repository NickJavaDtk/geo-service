package i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Random;

public class TestLocalizationService {

    @Test
    void testLocalizationServiceRus() {
        LocalizationService localizationService = new LocalizationServiceImpl( );
        String result = localizationService.locale(Country.RUSSIA);
        String expected = "Добро пожаловать";

        Assertions.assertEquals(result, expected);
    }

    @Test
    void testLocalizationServiceUsa() {
        LocalizationService localizationService = new LocalizationServiceImpl( );
        Country[] countyArray = new Country[]{Country.GERMANY, Country.USA, Country.BRAZIL};
        Random rand = new Random(  );
        String result = localizationService.locale(countyArray[rand.nextInt(3)]);
        String expected = "Welcome";

        Assertions.assertEquals(result, expected);
    }


}
