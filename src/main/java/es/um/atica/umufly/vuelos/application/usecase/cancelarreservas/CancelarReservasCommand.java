package es.um.atica.umufly.vuelos.application.usecase.cancelarreservas;

import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.SyncCommand;
import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;

public class CancelarReservasCommand extends SyncCommand<ReservaVuelo> {

	private DocumentoIdentidad docIdentidad;
	private UUID uuid;

	public CancelarReservasCommand( DocumentoIdentidad docIdentidad, UUID uuid ) {
		this.docIdentidad = docIdentidad;
		this.uuid = uuid;
	}

	public static CancelarReservasCommand of( DocumentoIdentidad docIdentidad, UUID uuid ) {
		return new CancelarReservasCommand( docIdentidad, uuid );
	}

	public DocumentoIdentidad getDocIdentidad() {
		return docIdentidad;
	}

	public UUID getUuid() {
		return uuid;
	}

}
