package com.pgrsoft.numberformatter.services.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.pgrsoft.numberformatter.services.NumberFormatter;

@Component
public class NumberFormatterImpl implements NumberFormatter {

	private static final Map<Integer,String> UNIDADES = new HashMap<>();
	private static final Map<Integer,String> DECENAS = new HashMap<>();
	private static final Map<Integer,String> CENTENAS = new HashMap<>();
	private static final Map<Integer,String> EXCEPCIONES = new HashMap<>();
	
	static {
	
		UNIDADES.put(0,"");
		UNIDADES.put(1,"una");
		UNIDADES.put(2,"dos");
		UNIDADES.put(3,"tres");
		UNIDADES.put(4,"cuatro");
		UNIDADES.put(5,"cinco");
		UNIDADES.put(6,"seis");
		UNIDADES.put(7,"siete");
		UNIDADES.put(8,"ocho");
		UNIDADES.put(9,"nueve");
		
		DECENAS.put(0,"");
		DECENAS.put(1,"diez");
		DECENAS.put(3,"treinta");
		DECENAS.put(4,"cuarenta");
		DECENAS.put(5,"cincuenta");
		DECENAS.put(6,"sesenta");
		DECENAS.put(7,"setenta");
		DECENAS.put(8,"ochenta");
		DECENAS.put(9,"noventa");
		
		CENTENAS.put(0, "");
		CENTENAS.put(1, "ciento");       	// femenino
		CENTENAS.put(2, "doscientos");		// femenino
		CENTENAS.put(3, "trescientos");		// femenino
		CENTENAS.put(4, "cuatrocientos");	// femenino
		CENTENAS.put(5, "quinientos");		// femenino
		CENTENAS.put(6, "seiscientos");		// femenino
		CENTENAS.put(7, "setecientos");		// femenino
		CENTENAS.put(8, "ochocientos");		// femenino
		CENTENAS.put(9, "novecientos");		// femenino
		
		EXCEPCIONES.put(10, "diez");
		EXCEPCIONES.put(11, "once");
		EXCEPCIONES.put(12, "doce");
		EXCEPCIONES.put(13, "trece");
		EXCEPCIONES.put(14, "catorce");
		EXCEPCIONES.put(15, "quince");
		EXCEPCIONES.put(16, "dieciséis");
		EXCEPCIONES.put(17, "diecisiete");
		EXCEPCIONES.put(18, "dieciocho");
		EXCEPCIONES.put(19, "diecinueve");
		EXCEPCIONES.put(20, "veinte");
		EXCEPCIONES.put(21, "veintiuno");  // delante sustantivo es femenino. También X1
		EXCEPCIONES.put(22, "veintidos");
		EXCEPCIONES.put(23, "veintitres");
		EXCEPCIONES.put(24, "veinticuatro");
		EXCEPCIONES.put(25, "veinticinco");
		EXCEPCIONES.put(26, "veintiséis");
		EXCEPCIONES.put(27, "veintisiete");
		EXCEPCIONES.put(28, "veintiocho");
		EXCEPCIONES.put(29, "veintinueve");
		
	}
	
	@Override
	public String convert(int number) {
		return convertFrom0to999(number);
	}
	
	private String convertFrom0to999(int cdu){
		
		if (cdu == 100){
			return "cien";
		}
		
		final int C = cdu / 100;
		final int D = (cdu % 100) / 10;
		final int U = cdu % 10;
		
		String resultado = CENTENAS.get(C) + " ";
		
		final int DU = D * 10 + U;
		
		if (DU > 10 && DU < 30) {
			resultado += EXCEPCIONES.get(DU);
		} else {
			String conector = (U == 0 || D == 0) ? "" : " y "; 
			resultado += DECENAS.get(D) + conector + UNIDADES.get(U);
		}
		
		return resultado.trim();
	}

}
