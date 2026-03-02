package es.um.atica.umufly.parking.domain.model;

public record DocumentoIdentidad( String tipo, String numero ) {

	public DocumentoIdentidad {
		if ( tipo == null || tipo.isBlank() || numero == null || numero.isBlank() ) {
			throw new IllegalArgumentException( "El tipo y número de documento no pueden estar vacíos" );
		}
	}
}