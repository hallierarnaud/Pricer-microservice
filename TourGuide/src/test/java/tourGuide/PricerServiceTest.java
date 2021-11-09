package tourGuide;

import org.junit.Test;

import java.util.List;
import java.util.UUID;

import tourGuide.pricer.service.PricerService;
import tripPricer.Provider;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class PricerServiceTest {

  @Test
  public void getTripDeals_shouldReturnOk() {
    // GIVEN
    PricerService pricerService = new PricerService();
    UUID userId = UUID.randomUUID();
    int numberOfAdults = 1;
    int numberOfChildren = 1;
    int tripDuration = 1;
    int cumulativeRewardPoints = 100;

    // WHEN
    List<Provider> providers = pricerService.getTripDeals(userId, numberOfAdults, numberOfChildren, tripDuration, cumulativeRewardPoints);

    // THEN
    assertThat(providers, hasSize(5));
  }

}
