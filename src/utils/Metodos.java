package utils;

import java.io.FileOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;

import beans.DetEventoDTO;
import beans.EquipoDTO;
import beans.EventoDTO;
import beans.FichaDTO;
import beans.JugadorDTO;
import beans.ModalidadDTO;

public class Metodos {
//	CIFRAR EN MD5
	public String cifrarCadena(String cadena) {
		String cifrado = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytesArray = md.digest(cadena.getBytes());
			BigInteger number = new BigInteger(1,bytesArray);
			cifrado = number.toString(16);
			while( cifrado.length() < 32 ) {
				cifrado = "0" + cifrado;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cifrado;
	}
	
// Crear archivo pdf
	public void generarConstancia(EquipoDTO equipo, List<JugadorDTO> jugadores, EventoDTO evento, 
			DetEventoDTO detEvento) {
		//Crear el documento
		Document documento = null;
		//nombre de archivo pdf
		String nombre = "Ficha "+equipo.getCod_ficha();
		//
		final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	    //final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);	        
	    final Font categoryFont = new Font(Font.TIMES_ROMAN, 18, Font.BOLD);
	    //final Font subcategoryFont = new Font(Font.TIMES_ROMAN, 16, Font.BOLD);
	    //final Font blueFont = new Font(Font.TIMES_ROMAN, 12, Font.NORMAL);    
	    //final Font smallBold = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
		try {
			documento = new Document();
			//Crear fichero donde se almacenara el pdf
			FileOutputStream fichero = new FileOutputStream("../WebContent/temp/"+nombre+".pdf");
			PdfWriter.getInstance(documento, fichero).setInitialLeading(20);
			//Abrir documento
			documento.open();
			//Escribir en el documento
			Paragraph titulo = new Paragraph("EVENTOS DEPORTIVOS",chapterFont);
			titulo.setAlignment(Element.ALIGN_CENTER);
			Paragraph numFicha = new Paragraph("N° Ficha: "+equipo.getCod_ficha(),categoryFont);
			numFicha.setAlignment(Element.ALIGN_LEFT);
			Paragraph nomEvento = new Paragraph("Evento: "+evento.getDesc_evento(),categoryFont);
			nomEvento.setAlignment(Element.ALIGN_LEFT);
			Paragraph nomModalidad= new Paragraph("Modalidad: "+detEvento.getNomModalidad(),categoryFont);
			nomModalidad.setAlignment(Element.ALIGN_LEFT);
			Paragraph nomEquipo = new Paragraph("Nombre de Equipo: "+equipo.getNom_equipo(),categoryFont);
			nomEquipo.setAlignment(Element.ALIGN_LEFT);
			Paragraph codEquipo = new Paragraph("N° Ficha: "+equipo.getCod_equipo(),categoryFont);
			codEquipo.setAlignment(Element.ALIGN_LEFT);
			Paragraph fecInicio = new Paragraph("Fecha de Inicio: "+detEvento.getFec_inicio(),categoryFont);
			fecInicio.setAlignment(Element.ALIGN_LEFT);
			Paragraph fecFin = new Paragraph("Fecha de Fin: "+detEvento.getFec_fin(),categoryFont);
			fecFin.setAlignment(Element.ALIGN_LEFT);			
			Paragraph desc = new Paragraph("Integrantes de Equipo",chapterFont);
			desc.setAlignment(Element.ALIGN_CENTER);
			//Tabla de integrantes
			PdfPTable tabla = new PdfPTable(5);
			tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
			//Cabeceras
			tabla.addCell("DNI");
			tabla.addCell("Nombres");
			tabla.addCell("Edad");
			tabla.addCell("Sexo");
			tabla.addCell("Sede");
			//contenido
			for( JugadorDTO x : jugadores ) {
				tabla.addCell(x.getDni_jugador());
				tabla.addCell(x.getNom_jugador());
				tabla.addCell(""+x.getEdad());
				tabla.addCell(x.getSexo());
				tabla.addCell(x.getNomSede());
			}
			documento.add(titulo);
			documento.add(numFicha);
			documento.add(nomEvento);
			documento.add(nomModalidad);
			documento.add(nomEquipo);
			documento.add(codEquipo);
			documento.add(fecInicio);
			documento.add(fecFin);
			documento.add(desc);
			documento.add(tabla);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if( documento != null ) {
					documento.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	
}
