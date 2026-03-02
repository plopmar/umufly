package es.um.atica.umufly.parking.application.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record SolicitarReservaParkingDTO(
		String tipoDoc, String numDoc, String tipoEstacionamiento, LocalDateTime inicio, LocalDateTime fin, BigDecimal precioBase ) {

}
