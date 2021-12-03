package tourGuide.pricer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import tourGuide.pricer.service.PricerService;
import tripPricer.Provider;

@RestController
public class PricerController {

  @Autowired
  private PricerService pricerService;

  /**
   *
   * @param userId an id of a user
   * @param numberOfAdults the number of adults wished for the trip
   * @param numberOfChildren the number of children wished for the trip
   * @param tripDuration the duration wished for the trip
   * @param cumulativeRewardPoints the reward points cumulate by the user
   * @return a list of the trips proposed by the providers
   */
  @GetMapping("/tripDeals")
  public List<Provider> getTripDeals(@RequestParam UUID userId, @RequestParam int numberOfAdults,
                                     @RequestParam int numberOfChildren, @RequestParam int tripDuration,
                                     @RequestParam int cumulativeRewardPoints) {
    List<Provider> providers = pricerService.getTripDeals(userId, numberOfAdults, numberOfChildren, tripDuration,
            cumulativeRewardPoints);
    return providers;
  }

}
