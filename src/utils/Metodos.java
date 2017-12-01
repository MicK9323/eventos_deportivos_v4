package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
	//IMPORTAR DE XLSX
	public ArrayList<JugadorDTO> dataExcel(File excelFile) {
		ArrayList<JugadorDTO> data = new ArrayList<JugadorDTO>();
		InputStream excelStream = null;
		XSSFWorkbook libro = null;
		XSSFSheet hoja = null;
		JugadorDTO obj = null;
		try {
			excelStream = new FileInputStream(excelFile);
			libro = new XSSFWorkbook(excelStream);
			hoja = libro.getSheetAt(0);
			Row fila;
			int filas = hoja.getLastRowNum();
			int cols = hoja.getRow(0).getLastCellNum();
			if (cols == 13 && filas > 0) {
				Iterator<Row> rowIterator = hoja.rowIterator();
				while (rowIterator.hasNext()) {
					fila = (Row) rowIterator.next();	
					obj = new JugadorDTO();
					obj.setDni_jugador(""+fila.getCell(0).getStringCellValue().trim());
					obj.setClave(new Metodos().cifrarCadena(""+fila.getCell(0).getStringCellValue().trim()));
					obj.setIdRol(Integer.parseInt(""+fila.getCell(1).getStringCellValue().trim()));
					obj.setNom_jugador(fila.getCell(2).getStringCellValue().trim().toUpperCase());
					obj.setApe_jugador(fila.getCell(3).getStringCellValue().trim().toUpperCase());
					obj.setFec_nac(fila.getCell(4).getDateCellValue().toString().trim());
					obj.setEdad(Integer.parseInt(""+fila.getCell(5).getStringCellValue().trim()));
					obj.setSexo(fila.getCell(6).getStringCellValue().trim().toUpperCase());
					obj.setEstCivil(fila.getCell(7).getStringCellValue().trim().toUpperCase());
					obj.setTelfDomicilio(""+fila.getCell(8).getStringCellValue().trim());
					obj.setTelfMovil(""+fila.getCell(8).getStringCellValue().trim());
					if(fila.getCell(10).getStringCellValue() == null) {
						obj.setDomicilio("PENDIENTE");
					}else {
						obj.setDomicilio(fila.getCell(10).getStringCellValue().trim().toUpperCase());
					}			
					obj.setEmail(fila.getCell(11).getStringCellValue().trim());
					obj.setCodSede(fila.getCell(12).getStringCellValue().trim().toUpperCase());
					data.add(obj);
				}
			} else {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (libro != null)
					libro.close();
				if (excelStream != null)
					excelStream.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
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
				obj.setClave(cifrarCadena(reader.get(0).trim()));
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

	public static byte[] getBytesFromFile(File file) throws IOException {
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
}
