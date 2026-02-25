package es.um.atica.umufly.vuelos.application.usecase.obtenerreservas;

import es.um.atica.fundewebjs.umubus.domain.cqrs.QueryHandler;
import es.um.atica.umufly.vuelos.application.port.ReservasVueloRepository;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;

public class ObtenerReservasQueryHandler implements QueryHandler<ReservaVuelo, ObtenerReservasQuery> {

	private final ReservasVueloRepository reservasVueloRepository;

	public ObtenerReservasQueryHandler( ReservasVueloRepository reservasVueloRepository ) {
		this.reservasVueloRepository = reservasVueloRepository;
	}

	@Override
	public ReservaVuelo handle( ObtenerReservasQuery query ) throws Exception {
		return reservasVueloRepository.findReservaById( query.getDocIdentidad(), query.getUuid() );

	}

}
