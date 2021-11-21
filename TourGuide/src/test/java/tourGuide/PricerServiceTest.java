package tourGuide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import tourGuide.pricer.service.PricerService;
import tripPricer.Provider;
import tripPricer.TripPricer;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PricerServiceTest {

  @Test
  public void getTripDeals_shouldReturnOk() {
    // GIVEN
    TripPricer tripPricer = Mockito.mock(TripPricer.class);
    PricerService pricerService = new PricerService(tripPricer);
    List<Provider> providers = new ArrayList<>();
    UUID userId = UUID.randomUUID();
    Provider provider = new Provider(userId, "Holiday Travels", 100);
    providers.add(provider);
    Mockito.when(tripPricer.getPrice("test-server-api-key", userId, 1, 1, 1, 100)).thenReturn(providers);

    // WHEN
    List<Provider> providersExpected = pricerService.getTripDeals(userId, 1, 1, 1, 100);

    // THEN
    assertEquals(providers, providersExpected);
  }

}
