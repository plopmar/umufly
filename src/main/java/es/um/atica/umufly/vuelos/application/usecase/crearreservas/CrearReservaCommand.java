package es.um.atica.umufly.vuelos.application.usecase.crearreservas;

import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.SyncCommand;
import es.um.atica.umufly.vuelos.domain.model.ClaseAsientoReserva;
import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;
import es.um.atica.umufly.vuelos.domain.model.Pasajero;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;

public class CrearReservaCommand extends SyncCommand<ReservaVuelo> {


	private DocumentoIdentidad docIdentidad;
	private UUID uuid;
	private ClaseAsientoReserva claseAsiente;
	private Pasajero pasajero;

	public CrearReservaCommand( DocumentoIdentidad docIdentidad, UUID uuid, ClaseAsientoReserva claseAsiente, Pasajero pasajero ) {
		this.docIdentidad = docIdentidad;
		this.uuid = uuid;
		this.claseAsiente = claseAsiente;
		this.pasajero = pasajero;
	}

	public static CrearReservaCommand of( DocumentoIdentidad docIdentidad, UUID uuid, ClaseAsientoReserva claseAsientoReserva, Pasajero pasajero ) {
		return new CrearReservaCommand( docIdentidad, uuid, claseAsientoReserva, pasajero );
	}

	public DocumentoIdentidad getDocIdentidad() {
		return docIdentidad;
	}

	public UUID getUuid() {
		return uuid;
	}

	public ClaseAsientoReserva getClaseAsiente() {
		return claseAsiente;
	}

	public Pasajero getPasajero() {
		return pasajero;
	}


}
