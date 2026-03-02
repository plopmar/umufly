package es.um.atica.umufly.vuelos.application.usecase.obtenervuelos;

import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.QueryHandler;
import es.um.atica.umufly.vuelos.application.dto.VueloAmpliadoDTO;
import es.um.atica.umufly.vuelos.application.mapper.ApplicationMapper;
import es.um.atica.umufly.vuelos.application.port.ReservasVueloReadRepository;
import es.um.atica.umufly.vuelos.application.port.VuelosReadRepository;
import es.um.atica.umufly.vuelos.domain.model.Vuelo;

public class ObtenerVuelosQueryHandler implements QueryHandler<VueloAmpliadoDTO, ObtenerVuelosQuery> {

	private final VuelosReadRepository vuelosReadRepository;
	private final ReservasVueloReadRepository reservasReadRepository;

	public ObtenerVuelosQueryHandler( VuelosReadRepository vuelosReadRepository, ReservasVueloReadRepository reservasReadRepository ) {
		this.vuelosReadRepository = vuelosReadRepository;
		this.reservasReadRepository = reservasReadRepository;
	}

	@Override
	public VueloAmpliadoDTO handle( ObtenerVuelosQuery query ) throws Exception {
		Vuelo vuelo = vuelosReadRepository.findVuelo( query.getUuid() );
		UUID vueloReserva = query.getDocIdentidad() != null ? reservasReadRepository.findReservaIdByVueloIdAndPasajero( query.getDocIdentidad(), vuelo.getId() ) : null;

		return ApplicationMapper.vueloToDTO( vuelo, vueloReserva );
	}

}
