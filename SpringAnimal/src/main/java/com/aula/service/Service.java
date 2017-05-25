package com.aula.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aula.domain.Animals;

@org.springframework.stereotype.Service
public class Service {
	private List<Animals> listaAnimales = new LinkedList<Animals>();

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Animals> findAll() {
		String sql = "select * from animal";
		List<Animals> listaAnimales = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Animals>(Animals.class));
		for (Animals a : listaAnimales) {
			System.out.println("Raza: " + a.getRace() + " : Color: " + a.getColor());
		}
		return listaAnimales;
	}

	public void add(Animals a) {
		String sql = "insert into animal(race, color) values(?,?)";
		jdbcTemplate.update(sql, a.getRace(), a.getColor());

		listaAnimales.add(a);
	}

	public void borrar(Animals a) {
		String sql = "delete from animal where race = '" + a.getRace() + "'";
		jdbcTemplate.update(sql);
	}

	public void actualizarAnimal(Animals a) {
		
		String sql = "update animal set color = '"+ a.getColor() +"' where race = '"+ a.getRace()+"'";
		jdbcTemplate.update(sql);
	}
}
