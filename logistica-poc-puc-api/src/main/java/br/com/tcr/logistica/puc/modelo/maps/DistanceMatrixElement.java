package br.com.tcr.logistica.puc.modelo.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class DistanceMatrixElement {
	

	  public DistanceMatrixElementStatus status;


	  public Duration duration;

	  public Duration durationInTraffic;


	  public Distance distance;

	  public Fare fare;

}
