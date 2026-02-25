package es.um.atica.umufly.vuelos.application.usecase.listarvuelos;

import org.springframework.data.domain.Page;

import es.um.atica.fundewebjs.umubus.domain.cqrs.Query;
import es.um.atica.umufly.vuelos.application.dto.VueloAmpliadoDTO;
import es.um.atica.umufly.vuelos.domain.model.DocumentoIdentidad;

public class ListarVuelosQuery extends Query<Page<VueloAmpliadoDTO>> {

	private DocumentoIdentidad docIdentidad;
	private int pagina;
	private int tamanioPagina;

	public ListarVuelosQuery( DocumentoIdentidad docIdentidad, int pagina, int tamanioPagina ) {
		this.docIdentidad = docIdentidad;
		this.pagina = pagina;
		this.tamanioPagina = tamanioPagina;
	}

	public ListarVuelosQuery of( DocumentoIdentidad docIdentidad, int pagina, int tamanioPagina ) {
		return new ListarVuelosQuery( docIdentidad, pagina, tamanioPagina );
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

	public void setDocIdentidad( DocumentoIdentidad docIdentidad ) {
		this.docIdentidad = docIdentidad;
	}

	public void setPagina( int pagina ) {
		this.pagina = pagina;
	}

	public void setTamanioPagina( int tamanioPagina ) {
		this.tamanioPagina = tamanioPagina;
	}

}
