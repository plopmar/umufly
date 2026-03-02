package es.um.atica.umufly.parking.domain.exception;

public class ParkingException extends RuntimeException {

	public ParkingException( String mensaje ) {
		super( mensaje );
	}
}