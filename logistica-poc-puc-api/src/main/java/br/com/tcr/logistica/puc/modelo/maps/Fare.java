package br.com.tcr.logistica.puc.modelo.maps;

import java.math.BigDecimal;
import java.util.Currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Fare {
	  public Currency currency;

	  public BigDecimal value;
}
