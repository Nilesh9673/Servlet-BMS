package com.jsp.bms.Service;

import java.util.List;

import com.jsp.bms.Dao.StatementDao;
import com.jsp.bms.Dto.StatementDto;

public class StatementService {
	StatementDao statementDao = new StatementDao();

//save Statement
	public StatementDto saveBankStatement(StatementDto statement) {
		return statementDao.saveBankStatement(statement);
	}

	// get All statement
	public List<StatementDto> customersStatement(int id) {
		return statementDao.customersStatement(id);
	}
}
