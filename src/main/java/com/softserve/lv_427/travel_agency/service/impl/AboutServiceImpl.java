package com.softserve.lv_427.travel_agency.service.impl;

import com.softserve.lv_427.travel_agency.dto.AboutDto;
import com.softserve.lv_427.travel_agency.entity.Country;
import com.softserve.lv_427.travel_agency.service.AboutService;
import com.softserve.lv_427.travel_agency.service.ClientService;
import com.softserve.lv_427.travel_agency.service.CountryService;
import com.softserve.lv_427.travel_agency.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Service implementation for About page logic.
 *
 * @author Nazar Vladyka
 * @version 1.0
 */
@Service
public class AboutServiceImpl implements AboutService {
  private final ClientService clientService;
  private final VisaService visaService;
  private final CountryService countryService;

  @Autowired
  public AboutServiceImpl(
      ClientService clientService, VisaService visaService, CountryService countryService) {
    this.clientService = clientService;
    this.visaService = visaService;
    this.countryService = countryService;
  }

  /**
   * Get AboutDto.
   *
   * @return AboutDto object.
   */
  @Override
  @Transactional
  public AboutDto getAboutDto() throws SQLException {
    AboutDto aboutDto = new AboutDto();
    List<Country> countries = countryService.findAll();
    List<List<String>> visas = new ArrayList<>();
    List<String> countVisa;

    for (Country country : countries) {
      countVisa =
          new ArrayList<>(
              Arrays.asList(
                  String.valueOf(visaService.CountVisaForCountry(country.getId())),
                  country.getName()));
      visas.add(countVisa);
    }

    aboutDto.setCountOfClient(clientService.getCountOfClients());
    aboutDto.setVisas(visas);

    return aboutDto;
  }
}
