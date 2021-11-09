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

  @GetMapping("/tripDeals")
  public List<Provider> getTripDeals(@RequestParam UUID userId, @RequestParam int numberOfAdults,
                                     @RequestParam int numberOfChildren, @RequestParam int tripDuration,
                                     @RequestParam int cumulativeRewardPoints) {
    List<Provider> providers = pricerService.getTripDeals(userId, numberOfAdults, numberOfChildren, tripDuration,
            cumulativeRewardPoints);
    return providers;
  }

}
