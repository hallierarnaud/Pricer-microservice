package tourGuide.pricer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class PricerService {

  private Logger logger = LoggerFactory.getLogger(PricerService.class);
  private final TripPricer tripPricer = new TripPricer();
  private static final String tripPricerApiKey = "test-server-api-key";

  public List<Provider> getTripDeals(UUID userId, int numberOfAdults, int numberOfChildren, int tripDuration,
                                     int cumulativeRewardPoints) {
    List<Provider> providers = tripPricer.getPrice(tripPricerApiKey, userId, numberOfAdults, numberOfChildren,
            tripDuration, cumulativeRewardPoints);
    return providers;
  }

}
