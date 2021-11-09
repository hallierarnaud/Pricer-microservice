package tourGuide.pricer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import tourGuide.service.TourGuideService;
import tripPricer.Provider;
import tripPricer.TripPricer;

@Service
public class PricerService {

  private Logger logger = LoggerFactory.getLogger(PricerService.class);
  private final TripPricer tripPricer = new TripPricer();
  private static final String tripPricerApiKey = "test-server-api-key";

  public List<Provider> getTripDeals(User user) {
    int cumulatativeRewardPoints = user.getUserRewards().stream().mapToInt(i -> i.getRewardPoints()).sum();
    List<Provider> providers = tripPricer.getPrice(tripPricerApiKey, user.getUserId(), user.getUserPreferences().getNumberOfAdults(),
            user.getUserPreferences().getNumberOfChildren(), user.getUserPreferences().getTripDuration(), cumulatativeRewardPoints);
    user.setTripDeals(providers);
    return providers;
  }

}
