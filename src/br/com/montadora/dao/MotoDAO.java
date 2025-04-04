package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.montadora.model.Carro;
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
		String sql = "insert into moto(montadora, nome, quantidadeadesivos) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1, moto.getMontadora());
			ps.setString(2, moto.getNome());
			ps.setInt(3, moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Moto inserida com sucesso";
			} else {
				return "Erro ao inserir moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar(Moto moto) {
		String sql = "delete from moto where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  moto.getNome());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deleta moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	public String alterar(Moto moto) {
		String sql = "update moto set nome = ?, montadora = ?, quantidadeadesivos = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  moto.getNome());
			ps.setString(2,  moto.getMontadora());
			ps.setInt(3,  moto.getQuantidadeAdesivos());
			if (ps.executeUpdate() > 0) {
				return "Atualizado com sucesso";
			} else {
				return "Erro atualizar a moto";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}

	}




