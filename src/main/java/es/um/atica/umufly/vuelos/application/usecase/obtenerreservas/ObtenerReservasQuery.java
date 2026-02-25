package es.um.atica.umufly.vuelos.application.usecase.obtenerreservas;

import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.Query;
import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;

public class ObtenerReservasQuery extends Query<ReservaVuelo> {

	private DocumentoIdentidad docIdentidad;
	private UUID uuid;

	public ObtenerReservasQuery( DocumentoIdentidad docIdentidad, UUID uuid ) {
		this.docIdentidad = docIdentidad;
		this.uuid = uuid;
	}

	public static ObtenerReservasQuery of( DocumentoIdentidad docIdentidad, UUID uuid ) {
		return new ObtenerReservasQuery( docIdentidad, uuid );
	}

	public DocumentoIdentidad getDocIdentidad() {
		return docIdentidad;
	}

	public UUID getUuid() {
		return uuid;
	}

}
