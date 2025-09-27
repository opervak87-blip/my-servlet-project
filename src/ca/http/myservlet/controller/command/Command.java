package ca.http.myservlet.controller.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ca.http.myservlet.dao.connectionpool.ConnectionPool;

public interface Command {
	void execute(HttpServletRequest request, HttpServletResponse response, Object context)throws ServletException, IOException;


}
