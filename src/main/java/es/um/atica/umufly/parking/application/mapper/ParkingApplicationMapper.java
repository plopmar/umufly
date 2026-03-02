package es.um.atica.umufly.parking.application.mapper;

import es.um.atica.umufly.parking.application.dto.ReservaParkingDTO;
import es.um.atica.umufly.parking.domain.model.ReservaParking;

public class ParkingApplicationMapper {

	private ParkingApplicationMapper() {
		throw new IllegalArgumentException( "Clase de conversión de Parking" );
	}

	public static ReservaParkingDTO reservaParkingToDTO( ReservaParking r ) {
		ReservaParkingDTO dto = new ReservaParkingDTO();

		dto.setIdReservaParking( r.getId() );

		if ( r.getIdentificadorPasajero() != null ) {
			dto.setTipoDocumento( r.getIdentificadorPasajero().tipo() );
			dto.setNumeroDocumento( r.getIdentificadorPasajero().numero() );
		}

		if ( r.getPeriodoEstacionamiento() != null ) {
			dto.setFechaInicio( r.getPeriodoEstacionamiento().inicio() );
			dto.setFechaFin( r.getPeriodoEstacionamiento().fin() );
		}

		dto.setTipoEstacionamiento( r.getTipo() != null ? r.getTipo().toString() : null );
		dto.setEstado( r.getEstado() != null ? r.getEstado().toString() : null );
		dto.setFechaReserva( r.getFechaReserva() );

		if ( r.getImporte() != null ) {
			dto.setImporte( r.getImporte().valor() );
		}

		return dto;
	}
}