package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;

import sql.sentenciasSQL;
import vo.*;

public class AparcamientoPD_DAO {
	private Statement stm;
	private PreparedStatement pstm;
	private ResultSet rs;

	public AparcamientoPD_DAO() {

	}

	public ArrayList<AparcamientoPDVO> getallAparcamientos() {
		ArrayList<AparcamientoPDVO> listaAparcamientos = new ArrayList<AparcamientoPDVO>();
		sentenciasSQL sql = new sentenciasSQL();
		try {
			sql.conectarBBDD();
			stm = sql.getConn().createStatement();
			rs = stm.executeQuery("select * from APARCAMIENTOSPERDISCAP");
			while (rs.next()) {
				AparcamientoPDVO aparcamiento = new AparcamientoPDVO();
				aparcamiento.setId(rs.getInt("id"));
				aparcamiento.setLatitud(rs.getDouble("latitud"));
				aparcamiento.setLongitud(rs.getDouble("longitud"));
				aparcamiento.setTitulo(rs.getString("titulo"));
				aparcamiento.setIcono(rs.getString("icono"));
				listaAparcamientos.add(aparcamiento);
			}
			sql.closeBBDD();
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(
					Level.SEVERE,
					"Error en AparcamientPD_DAO.getallAparcamientos:"
							+ e.getMessage());
		}
		return listaAparcamientos;
	}

	public AparcamientoPDVO getAparcamientoPDbyId(int id) {
		sentenciasSQL sql = new sentenciasSQL();
		try {
			AparcamientoPDVO aparcamiento = new AparcamientoPDVO();
			sql.conectarBBDD();
			pstm = sql.getConn().prepareStatement(
					"select * from APARCAMIENTOSPERDISCAP where id = ?");
			pstm.setFloat(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				aparcamiento.setId(rs.getInt("id"));
				aparcamiento.setLatitud(rs.getDouble("latitud"));
				aparcamiento.setLongitud(rs.getDouble("longitud"));
				aparcamiento.setTitulo(rs.getString("titulo"));
				aparcamiento.setIcono(rs.getString("icono"));
			}
			sql.closeBBDD();
			return aparcamiento;

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					e.getMessage());
		}
		return null;
	}

	public void InsertarAparcamientoPDVO() {
		sentenciasSQL sql = new sentenciasSQL();
		try {
			AparcamientoPDVO aparcamiento = new AparcamientoPDVO(224, 2153216,
					1685651, "Aparcamiento Discapacitados", "icono.png");
			sql.conectarBBDD();
			pstm = sql.getConn().prepareStatement(
					"Insert into APARCAMIENTOSPERDISCAP Values (?,?,?,?,?)");

			pstm.setFloat(1, aparcamiento.getId());
			pstm.setDouble(2, aparcamiento.getLatitud());
			pstm.setDouble(3, aparcamiento.getLongitud());
			pstm.setString(4, aparcamiento.getTitulo());
			pstm.setString(5, aparcamiento.getIcono());

			pstm.execute();
			sql.closeBBDD();

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					e.getMessage());
		}
	}

	public void ActualizarAparcamientoPDVO() {
		sentenciasSQL sql = new sentenciasSQL();
		try {
			sql.conectarBBDD();
			pstm = sql.getConn().prepareStatement(
					"Update APARCAMIENTOSPERDISCAP set titulo = ? Where id= ?");

			pstm.setString(1, "Aparcamiento");
			pstm.setInt(2, 1);

			pstm.executeUpdate();
			sql.closeBBDD();

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					e.getMessage());
		}
	}

	public void aparcamientosCSV() {
		File fichero;
		FileWriter fw;
		BufferedWriter bw;

		try {
			fichero = new File("/var/www/html/aparcamientos.csv");
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);

			ArrayList<AparcamientoPDVO> aparcamientos = new ArrayList<AparcamientoPDVO>();
			aparcamientos = getallAparcamientos();

			Iterator iterador = aparcamientos.iterator();

			while (iterador.hasNext()) {
				AparcamientoPDVO aparcamiento = (AparcamientoPDVO) iterador
						.next();
				bw.write(aparcamiento.getId() + ";" + aparcamiento.getTitulo()
						+ ";" + aparcamiento.getLatitud() + ";"
						+ aparcamiento.getLongitud() + ";"
						+ aparcamiento.getIcono());
				bw.write("\n");
			}
			bw.close();
			fw.close();
			System.out.println("El fichero ha sido creado correctamente");
		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					"Falla aparcamientosCSV:" + e.getMessage());
		}
	}

	public void PruebaInsertarCommit() {
		sentenciasSQL sql = new sentenciasSQL();
		try {
			int id = 1;
			while (id % 2 != 0) {
				Random idRandom = new Random();
				id = idRandom.nextInt(10);
				System.out.println("ID 1" + id);
				AparcamientoPDVO aparcamiento = new AparcamientoPDVO(id,
						2153216, 1685651, "Aparcamiento de prueba", "icono.png");
				sql.conectarBBDD();
				pstm = sql
						.getConn()
						.prepareStatement(
								"Insert into APARCAMIENTOSPERDISCAP Values (?,?,?,?,?)");
				pstm.setFloat(1, aparcamiento.getId());
				pstm.setDouble(2, aparcamiento.getLatitud());
				pstm.setDouble(3, aparcamiento.getLongitud());
				pstm.setString(4, aparcamiento.getTitulo());
				pstm.setString(5, aparcamiento.getIcono());
				pstm.execute();
				id = idRandom.nextInt(10);
				System.out.println("ID 2" + id);
				if (id % 2 == 0) {
					sql.getConn().commit();
					System.out.println("Se hace el commit");
				} else {
					sql.getConn().rollback();
					System.out.println("No se hace el commit");
				}
				sql.closeBBDD();
			}

		} catch (Exception e) {
			// TODO: handle exception
			Logger.getLogger(getClass().getName()).log(Level.SEVERE,
					e.getMessage());
		}
	}
}
