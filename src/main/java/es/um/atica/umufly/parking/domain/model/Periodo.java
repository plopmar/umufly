package es.um.atica.umufly.parking.domain.model;

import java.time.LocalDateTime;

public record Periodo( LocalDateTime inicio, LocalDateTime fin ) {

	public Periodo {
		if ( inicio == null || fin == null ) {
			throw new IllegalArgumentException( "El inicio y el fin del periodo no pueden ser nulos" );
		}
		if ( inicio.isAfter( fin ) ) {
			throw new IllegalArgumentException( "La fecha de inicio debe ser anterior a la de fin" );
		}
	}
}