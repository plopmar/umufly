package es.um.atica.umufly.parking.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class ReservaParkingDTO {

	private UUID idReservaParking;
	private String tipoDocumento;
	private String numeroDocumento;
	private String tipoEstacionamiento;
	private LocalDateTime fechaInicio;
	private LocalDateTime fechaFin;
	private BigDecimal importe;
	private LocalDateTime fechaReserva;
	private String estado;

	public UUID getIdReservaParking() {
		return idReservaParking;
	}

	public void setIdReservaParking( UUID idReservaParking ) {
		this.idReservaParking = idReservaParking;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento( String tipoDocumento ) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento( String numeroDocumento ) {
		this.numeroDocumento = numeroDocumento;
	}

	public String getTipoEstacionamiento() {
		return tipoEstacionamiento;
	}

	public void setTipoEstacionamiento( String tipoEstacionamiento ) {
		this.tipoEstacionamiento = tipoEstacionamiento;
	}

	public LocalDateTime getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio( LocalDateTime fechaInicio ) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDateTime getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin( LocalDateTime fechaFin ) {
		this.fechaFin = fechaFin;
	}

	public BigDecimal getImporte() {
		return importe;
	}

	public void setImporte( BigDecimal importe ) {
		this.importe = importe;
	}

	public LocalDateTime getFechaReserva() {
		return fechaReserva;
	}

	public void setFechaReserva( LocalDateTime fechaReserva ) {
		this.fechaReserva = fechaReserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado( String estado ) {
		this.estado = estado;
	}
}