package es.um.atica.umufly.parking.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class ReservaParking {

	private final UUID id;
	private final DocumentoIdentidad identificadorPasajero;
	private final TipoEstacionamiento tipo;
	private final Periodo periodoEstacionamiento;
	private Importe importe;
	private final LocalDateTime fechaReserva;
	private EstadoReservaParking estado;

	public ReservaParking(UUID id, DocumentoIdentidad pasajero, TipoEstacionamiento tipo,
			Periodo periodo, Importe importe ) {
		this.id = id != null ? id : UUID.randomUUID();
		this.identificadorPasajero = pasajero;
		this.tipo = tipo;
		this.periodoEstacionamiento = periodo;
		this.importe = importe;
		this.fechaReserva = LocalDateTime.now();
		this.estado = EstadoReservaParking.ACTIVA;
	}

	public void aplicarDescuentoPorVuelo() {
		this.importe = this.importe.aplicarDescuento( 0.25 );
	}

	public void cancelar() {
		if ( LocalDateTime.now().isAfter( periodoEstacionamiento.inicio() ) ) {
			throw new IllegalStateException( "No se puede cancelar la reserva una vez iniciado el periodo" );
		}
		this.estado = EstadoReservaParking.CANCELADA;
	}

	public UUID getId() {
		return id;
	}

	public DocumentoIdentidad getIdentificadorPasajero() {
		return identificadorPasajero;
	}

	public TipoEstacionamiento getTipo() {
		return tipo;
	}

	public Periodo getPeriodoEstacionamiento() {
		return periodoEstacionamiento;
	}

	public Importe getImporte() {
		return importe;
	}

	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	public EstadoReservaParking getEstado() {
		return estado;
	}
}