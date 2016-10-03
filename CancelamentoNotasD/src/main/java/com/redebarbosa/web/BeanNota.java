package com.redebarbosa.web;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.redebarbosa.model.Nota;
import com.redebarbosa.util.Conexao;


@ManagedBean (name ="bNota")
@SessionScoped
public class BeanNota implements Serializable{


	private static final long serialVersionUID = 1L;
	private Nota nota = new Nota();
	
	public String actionSelectByNumNotaEmpSerie() {
		Connection connection = null;
		PreparedStatement psSelect = null;
		ResultSet rsSelect = null;
		String sql = "SELECT dtmovimento, idempresa, numnota, serienota  FROM notas WHERE numnota = ? and idempresa = ? and month(dtmovimento) = ?";

		try {
			connection = Conexao.getConnection();
			psSelect = connection.prepareStatement(sql);
			psSelect.setInt(1, nota.getNumero());
			psSelect.setInt(2, nota.getEmpresa());
			psSelect.setInt(3, nota.getMesMov());
			rsSelect = psSelect.executeQuery();
			if (rsSelect.next()) {
				nota = new Nota();
				nota.setNumero(rsSelect.getInt("numnota"));
				nota.setEmpresa(rsSelect.getInt("idempresa"));
				nota.setSerie(rsSelect.getInt("serienota"));
				nota.setMesMov(rsSelect.getInt("dtmovimento"));
			}

		} catch (Exception e) {
			System.out.println("------------------------------");
			System.out.println("Erro na busca");
			System.out.println("------------------------------");
			e.printStackTrace();

		}

		return null;
	}

	public Nota getNota() {
		return nota;
	}

	public void setNota(Nota nota) {
		this.nota = nota;
	}
}
