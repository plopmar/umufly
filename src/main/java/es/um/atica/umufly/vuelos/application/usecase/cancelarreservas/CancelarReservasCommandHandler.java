package es.um.atica.umufly.vuelos.application.usecase.cancelarreservas;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.stereotype.Component;

import es.um.atica.fundewebjs.umubus.domain.cqrs.SyncCommandHandler;
import es.um.atica.umufly.vuelos.application.port.FormalizacionReservasVueloPort;
import es.um.atica.umufly.vuelos.application.port.ReservasVueloRepository;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;

@Component
public class CancelarReservasCommandHandler implements SyncCommandHandler<ReservaVuelo, CancelarReservasCommand> {

	private final ReservasVueloRepository reservasVueloRepository;
	private final FormalizacionReservasVueloPort formalizacionReservasVueloPort;
	private final Clock clock;

	public CancelarReservasCommandHandler( ReservasVueloRepository reservasVueloRepository, FormalizacionReservasVueloPort formalizacionReservasVueloPort, Clock clock ) {
		this.reservasVueloRepository = reservasVueloRepository;
		this.formalizacionReservasVueloPort = formalizacionReservasVueloPort;
		this.clock = clock;
	}

	@Override
	public ReservaVuelo handle( CancelarReservasCommand command ) throws Exception {
		ReservaVuelo reservaVuelo = reservasVueloRepository.findReservaById( command.getDocIdentidad(), command.getUuid() );

		reservaVuelo.cancelarReserva( LocalDateTime.now( clock ) );
		reservasVueloRepository.cancelReserva( reservaVuelo.getId() );
		UUID idReservaFormalizada = reservasVueloRepository.findIdFormalizadaByReservaById( command.getUuid() );
		formalizacionReservasVueloPort.cancelarReservaVuelo( command.getDocIdentidad(), idReservaFormalizada );

		return reservaVuelo;
	}

}
