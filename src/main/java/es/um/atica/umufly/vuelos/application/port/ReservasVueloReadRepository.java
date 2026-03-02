package es.um.atica.umufly.vuelos.application.port;

import java.util.UUID;

import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;

public interface ReservasVueloReadRepository {

	UUID findReservaIdByVueloIdAndPasajero( DocumentoIdentidad doc, UUID vueloId );

	int countReservasByIdVueloAndPasajero( UUID idVuelo, DocumentoIdentidad doc );
}