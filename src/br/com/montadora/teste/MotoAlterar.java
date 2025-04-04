package br.com.montadora.teste;

import java.sql.Connection;

import br.com.montadora.conexao.Conexao;
import br.com.montadora.dao.MotoDAO;
import br.com.montadora.model.Moto;

public class MotoAlterar {
	public static void main(String[] args) {

		Connection con = Conexao.abrirConexao();

		Moto moto = new Moto();
		MotoDAO motodao = new MotoDAO(con);

		moto.setMontadora("Yamaha");
		moto.setNome("253");
		moto.setQuantidadeAdesivos(16);
		System.out.println(motodao.alterar(moto));

		Conexao.fecharConexao(con);
	}
}
