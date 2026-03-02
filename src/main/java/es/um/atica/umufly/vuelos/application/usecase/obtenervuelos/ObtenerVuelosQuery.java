package es.um.atica.umufly.vuelos.application.usecase.obtenervuelos;

import java.util.UUID;

import es.um.atica.fundewebjs.umubus.domain.cqrs.Query;
import es.um.atica.umufly.vuelos.application.dto.VueloAmpliadoDTO;
import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;

public class ObtenerVuelosQuery extends Query<VueloAmpliadoDTO> {

	private DocumentoIdentidad docIdentidad;
	private UUID uuid;

	public ObtenerVuelosQuery( DocumentoIdentidad docIdentidad, UUID uuid ) {
		this.docIdentidad = docIdentidad;
		this.uuid = uuid;
	}

	public static ObtenerVuelosQuery of( DocumentoIdentidad docIdentidad, UUID uuid ) {
		return new ObtenerVuelosQuery( docIdentidad, uuid );
	}

	public DocumentoIdentidad getDocIdentidad() {
		return docIdentidad;
	}

	public UUID getUuid() {
		return uuid;
	}
}
