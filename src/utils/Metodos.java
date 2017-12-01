package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.csvreader.CsvReader;

import beans.JugadorDTO;

public class Metodos {
	// CODIFICAR EN BASE64
	public String codificarBase64(String cadena) {
		String cod = "";
		Base64.Encoder encoder = Base64.getEncoder();
		cod = encoder.encodeToString(cadena.getBytes(StandardCharsets.UTF_8));
		return cod;
	}
	
	// DECODIFICAR BASE64
	public String decodificarBase64(String cod) {
		String cadena = "";
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] arraybytes = decoder.decode(cod);
		cadena = new String(arraybytes);
		return cadena;
	}
	
	
	// CIFRAR EN MD5
	public String cifrarCadena(String cadena) {
		String cifrado = "";
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] bytesArray = md.digest(cadena.getBytes());
			BigInteger number = new BigInteger(1, bytesArray);
			cifrado = number.toString(16);
			while (cifrado.length() < 32) {
				cifrado = "0" + cifrado;
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return cifrado;
	}

	//IMPORTAR DE CSV
	public ArrayList<JugadorDTO> dataCSV(File archivo){
		ArrayList<JugadorDTO> data = new ArrayList<JugadorDTO>();
		CsvReader reader = null;
		JugadorDTO obj = null;
		try {
			reader = new CsvReader(archivo.getPath());
			reader.setDelimiter(';');
			while(reader.readRecord()) {
				obj = new JugadorDTO();
				obj.setDni_jugador(reader.get(0).trim());
				obj.setClave(codificarBase64(reader.get(0).trim()));
				obj.setIdRol(Integer.parseInt(reader.get(1).trim()));
				obj.setNom_jugador(reader.get(2).trim().toUpperCase());
				obj.setApe_jugador(reader.get(3).trim().toUpperCase());
				obj.setFec_nac(fechaMysql(reader.get(4).trim()));
				obj.setEdad(Integer.parseInt(reader.get(5).trim()));
				obj.setSexo(reader.get(6).trim().toUpperCase());
				obj.setEstCivil(reader.get(7).trim().toUpperCase());
				obj.setTelfDomicilio(reader.get(8).trim());
				obj.setTelfMovil(reader.get(9).trim());
				if(reader.get(10).trim() == "") {
					obj.setDomicilio("PENDIENTE");
				}else {
					obj.setDomicilio(reader.get(10).trim().toUpperCase());
				}			
				obj.setEmail(reader.get(11).trim());
				obj.setCodSede(reader.get(12).trim().toUpperCase());
				data.add(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(reader != null)reader.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	//FECHA NORMAL
	public String fechaNormal(String fecha) {
		SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = parseador.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formateador.format(date);
	}
	//FECHA MYSQL
	public String fechaMysql(String fecha) {
		SimpleDateFormat parseador = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = parseador.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formateador.format(date);
	}

	public byte[] getBytesFromFile(File file) throws IOException {
		if (file != null) {
			InputStream is = new FileInputStream(file);

			byte[] bytes = new byte[(int) file.length()];

			int offset = 0;
			int numRead = 0;
			while (offset < bytes.length
					&& (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
				offset += numRead;
			}

			is.close();
			return bytes;
		} else {
			return null;
		}
	}
	
	public int getLongfile(File file) {
		int tamaño = 0;
		tamaño = (int) Math.round(Math.ceil(file.length()/1024.0));
		return tamaño;
	}
}
