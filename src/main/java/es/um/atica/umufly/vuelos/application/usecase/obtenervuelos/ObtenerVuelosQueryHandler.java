package es.um.atica.umufly.vuelos.application.usecase.obtenervuelos;

import java.util.Optional;
import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.QueryHandler;
import es.um.atica.umufly.vuelos.application.dto.VueloAmpliadoDTO;
import es.um.atica.umufly.vuelos.application.mapper.ApplicationMapper;
import es.um.atica.umufly.vuelos.application.port.ReservasVueloRepository;
import es.um.atica.umufly.vuelos.application.port.VuelosRepository;
import es.um.atica.umufly.vuelos.domain.model.Vuelo;

public class ObtenerVuelosQueryHandler implements QueryHandler<<VueloAmpliadoDTO>, ObtenerVuelosQuery> {

	private final VuelosRepository vuelosRepository;
	private final ReservasVueloRepository reservasVueloRepository;

	public ObtenerVuelosQueryHandler( VuelosRepository vuelosRepository, ReservasVueloRepository reservasVueloRepository ) {
		this.vuelosRepository = vuelosRepository;
		this.reservasVueloRepository = reservasVueloRepository;
	}

	@Override
	public Optional<VueloAmpliadoDTO> handle( ObtenerVuelosQuery query ) throws Exception {
		Vuelo vuelo = vuelosRepository.findVuelo( query.getUuid() );
		UUID vueloReserva = query.getDocIdentidad() != null ? reservasVueloRepository.findReservaIdByVueloIdAndPasajero( query.getDocIdentidad(), vuelo.getId() ) : null;

		return Optional.ofNullable( ApplicationMapper.vueloToDTO( vuelo, vueloReserva ) );
	}

}
