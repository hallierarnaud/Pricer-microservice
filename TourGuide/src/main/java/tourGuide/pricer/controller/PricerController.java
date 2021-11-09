package tourGuide.pricer.controller;

import com.jsoniter.output.JsonStream;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import tripPricer.Provider;

@RestController
public class PricerController {

  @RequestMapping("/getTripDeals")
  public String getTripDeals(@RequestParam String userName) {
    List<Provider> providers = tourGuideService.getTripDeals(getUser(userName));
    return JsonStream.serialize(providers);
  }

}
