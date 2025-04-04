package br.com.montadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.escola.model.Professor;
import br.com.montadora.model.Carro;
import br.com.montadora.model.Moto;

public class CarroDAO {
	
	private Connection con = null;

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public CarroDAO(Connection con) {
		setCon(con);
	}
	

	public String inserir(Carro carro) {
		String sql = "insert into carro(montadora, nome, quantidadeportas) values (?,?,?)";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  carro.getMontadora());
			ps.setString(2, carro.getNome());
			ps.setInt(3, carro.getQuantidadePortas());
			if (ps.executeUpdate() > 0) {
				return "Carro inserido com sucesso";
			} else {
				return "Erro ao inserir carro";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String deletar(Carro carro) {
		String sql = "delete from carro where nome = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  carro.getNome());
			if (ps.executeUpdate() > 0) {
				return "Deletado com sucesso";
			} else {
				return "Erro ao deletar carro";
			}
		} catch (SQLException e) {
			return e.getMessage();
		}
	}
	
	public String alterar(Carro carro) {
		String sql = "update carro set nome = ?, montadora = ?, quantidadeportas = ?";
		try {
			PreparedStatement ps = getCon().prepareStatement(sql);
			ps.setString(1,  carro.getNome());
			ps.setString(2,  carro.getMontadora());
			ps.setInt(3,  carro.getQuantidadePortas());
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



