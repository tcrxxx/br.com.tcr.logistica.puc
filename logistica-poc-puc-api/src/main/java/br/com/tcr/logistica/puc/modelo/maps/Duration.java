package br.com.tcr.logistica.puc.modelo.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Duration {

	  public long inSeconds;

	  public String humanReadable;
	  
	  public String text;
	  
	  public String value;
}
