package es.um.atica.umufly.vuelos.application.usecase.crearreservas;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.SyncCommandHandler;
import es.um.atica.umufly.vuelos.application.port.FormalizacionReservasVueloPort;
import es.um.atica.umufly.vuelos.application.port.ReservasVueloRepository;
import es.um.atica.umufly.vuelos.application.port.VuelosRepository;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;
import es.um.atica.umufly.vuelos.domain.model.Vuelo;

public class CrearReservaCommandHandler implements SyncCommandHandler<ReservaVuelo, CrearReservaCommand> {

	private final VuelosRepository vuelosRepository;
	private final ReservasVueloRepository reservasVueloRepository;
	private final FormalizacionReservasVueloPort formalizacionReservasVueloPort;
	private final Clock clock;

	public CrearReservaCommandHandler( VuelosRepository vuelosRepository, ReservasVueloRepository reservasVueloRepository, FormalizacionReservasVueloPort formalizacionReservasVueloPort, Clock clock ) {
		this.vuelosRepository = vuelosRepository;
		this.reservasVueloRepository = reservasVueloRepository;
		this.formalizacionReservasVueloPort = formalizacionReservasVueloPort;
		this.clock = clock;
	}
	@Override
	public ReservaVuelo handle( CrearReservaCommand command ) throws Exception {
		Vuelo vuelo = vuelosRepository.findVuelo( command.getUuid() );

		// 2. Recuperar el número de reservas del pasajero en el vuelo
		int numeroReservasPasajeroEnVuelo = reservasVueloRepository.countReservasByIdVueloAndPasajero( command.getUuid(), command.getPasajero() );

		// 3. Recuperar el número de plazas disponibles en el avión
		int numeroPlazasDisponiblesAvion = vuelosRepository.plazasDisponiblesEnVuelo( vuelo );

		// 4. Creamos y persistimos la reserva de vuelo
		ReservaVuelo reservaVuelo = ReservaVuelo.solicitarReserva( command.getDocIdentidad(), command.getPasajero(), vuelo, command.getClaseAsiente(), LocalDateTime.now( clock ), numeroReservasPasajeroEnVuelo, numeroPlazasDisponiblesAvion );
		reservasVueloRepository.persistirReserva( reservaVuelo );

		// 5. Formalizamos la reserva llamando al backoffice para que se haga eco de la nueva reserva que acabamos de crear
		UUID idReservaFormalizada = formalizacionReservasVueloPort.formalizarReservaVuelo( reservaVuelo );
		reservaVuelo.formalizarReserva();
		reservasVueloRepository.persistirFormalizacionReserva( reservaVuelo.getId(), idReservaFormalizada );

		return reservaVuelo;

	}

}
