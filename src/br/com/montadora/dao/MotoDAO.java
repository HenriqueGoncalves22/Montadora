package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Moto;

public class MotoDAO {
	
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public MotoDAO(Connection con) {
		setCon(con);
	}
	
	public String inserir(Moto moto) {
		String sql = "insert into moto(montadora, nomecarro, quantidadeadesivos) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			ps.setString(2, moto.getNomeCarro());
			ps.setInt(3, moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Moto inserida com sucesso";
			} else {
				return "Erro inserir";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
		
		public String deletar(Moto moto) {
			String sql = "delete from moto where montadora = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1,  moto.getNomeCarro());
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro deletar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
		public String deletarWhereNome(Moto moto) {
			String sql = "delete from moto where nomeCarro = ?";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				ps.setString(1,  moto.getNomeCarro());
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro deletar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
		
		
		public String deletarSemWhere() {
			String sql = "delete from moto";
			try {
				PreparedStatement ps = getCon().prepareStatement(sql);
				if (ps.executeUpdate() > 0) {
					return "Deletado com sucesso";
				} else {
					return "Erro deletar";
				}
			} catch (SQLException e) {
				return e.getMessage();
			}
		}
	}




