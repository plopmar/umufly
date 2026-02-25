package es.um.atica.umufly.vuelos.application.usecase.listarreservas;

import org.springframework.data.domain.Page;

import es.um.atica.fundewebjs.umubus.domain.cqrs.Query;
import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;
import es.um.atica.umufly.vuelos.domain.model.ReservaVuelo;

public class ListarReservasQuery extends Query<Page<ReservaVuelo>> {

	private DocumentoIdentidad docIdentidad;
	private int pagina;
	private int tamanioPagina;

	public ListarReservasQuery( DocumentoIdentidad docIdentidad, int pagina, int tamanioPagina ) {
		this.docIdentidad = docIdentidad;
		this.pagina = pagina;
		this.tamanioPagina = tamanioPagina;
	}

	public static ListarReservasQuery of( DocumentoIdentidad docIdentidad, int pagina, int tamanioPagina ) {
		return new ListarReservasQuery( docIdentidad, pagina, tamanioPagina );
	}

	public DocumentoIdentidad getDocIdentidad() {
		return docIdentidad;
	}

	public int getPagina() {
		return pagina;
	}

	public int getTamanioPagina() {
		return tamanioPagina;
	}

}
