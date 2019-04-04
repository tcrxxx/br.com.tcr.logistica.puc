package br.com.tcr.logistica.puc.modelo.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class Distance {


	  public long inMeters;

	  public String humanReadable;
	  
	  public String text;
	  
	  public String value;
	
}
