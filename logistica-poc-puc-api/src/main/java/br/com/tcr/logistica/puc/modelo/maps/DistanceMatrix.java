package br.com.tcr.logistica.puc.modelo.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class DistanceMatrix {
	
	  @JsonProperty("origin_addresses")
	  public  String[] originAddresses;

	  @JsonProperty("destination_addresses")
	  public  String[] destinationAddresses;

	  public  DistanceMatrixRow[] rows;
	  
	  public String status;
	  
	  public DistanceMatrix() {
		  
	  }
}
