package com.uenta.cloud.statistics.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.uenta.cloud.statistics.client.ExchangeRatesClient;
import com.uenta.cloud.statistics.domain.Currency;
import com.uenta.cloud.statistics.domain.ExchangeRatesContainer;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = StatisticsApplication.class)
public class ExchangeRatesClientTest {

	@Autowired
	private ExchangeRatesClient client;

	@Test
	public void shouldRetrieveExchangeRates() {

		ExchangeRatesContainer container = client.getRates(Currency.getBase());

		assertEquals(container.getDate(), LocalDate.now());
		assertEquals(container.getBase(), Currency.getBase());

		assertNotNull(container.getRates().get(Currency.EUR.name()));
		assertNotNull(container.getRates().get(Currency.RUB.name()));
	}

}