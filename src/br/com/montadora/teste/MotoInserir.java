package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.MotoDAO;
import br.com.montadora.model.Moto;

public class MotoInserir {
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Moto moto = new Moto();
		MotoDAO motodao = new MotoDAO(con);

		moto.setMontadora("Honda");
		moto.setNome("XJ");
		moto.setQuantidadeAdesivos(5);
		System.out.println(motodao.inserir(moto));

		Conexao.fecharConexao(con);
	}
}
