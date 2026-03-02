package es.um.atica.umufly.parking.domain.model;

import java.math.BigDecimal;

public record Importe( BigDecimal valor ) {

	public Importe {
		if ( valor == null || valor.compareTo( BigDecimal.ZERO ) <= 0 ) {
			throw new IllegalArgumentException( "El importe debe ser mayor que 0" );
		}
	}

	public Importe aplicarDescuento( double porcentaje ) {
		return new Importe( valor.multiply( BigDecimal.valueOf( porcentaje ) ) );
	}
}