package br.com.tcr.logistica.puc.modelo.maps;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class DistanceMatrixRow {

	public DistanceMatrixElement[] elements;
	
	/*
	 "rows" : [
      {
         "elements" : [
            {
               "distance" : {
                  "text" : "433 km",
                  "value" : 432862
               },
               "duration" : {
                  "text" : "5 horas 29 minutos",
                  "value" : 19722
               },
               "status" : "OK"
            }
         ]
      } 
	 * */
	
}
