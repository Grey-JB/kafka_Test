package com.grey.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.grey.po.Count;

@Repository
public class CountDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int add(Count count) {
		return jdbcTemplate.update("INSERT INTO count(sys,broser,ipAddress,time) VALUES(?,?,?,?)", count.getSys(),
				count.getBroser(), count.getIpAddress(), count.getTime());
	}
}
