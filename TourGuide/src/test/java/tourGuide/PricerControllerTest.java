package tourGuide;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.UUID;

import tourGuide.pricer.service.PricerService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PricerControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private PricerService pricerService;

  @Test
  public void getTripDeals_shouldReturnOk() throws Exception {
    when(pricerService.getTripDeals(any(UUID.class), anyInt(), anyInt(), anyInt(), anyInt())).thenReturn(new ArrayList<>());
    mockMvc.perform(get("/tripDeals")
            .contentType(MediaType.APPLICATION_JSON)
            .param("userId", "6ba7b810-9dad-11d1-80b4-00c04fd430c8")
            .param("numberOfAdults", "1")
            .param("numberOfChildren", "1")
            .param("tripDuration", "1")
            .param("cumulativeRewardPoints", "100"))
            .andExpect(status().isOk());
  }

}
