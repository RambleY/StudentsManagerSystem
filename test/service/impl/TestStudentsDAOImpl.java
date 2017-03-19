package service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import action.StudentsAction;
import service.StudentsDAO;
import entity.Students;

public class TestStudentsDAOImpl {
	
	@Test
	public void testQueryAllStudents() {
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		for (Students students : list) {
			System.out.println(students);
		}
	}
	
	@Test
	public void testDelete() {
		
		
	}
	
	@Test
	public void testAdd() throws Exception {
		
		StudentsDAO sdao = new StudentsDAOImpl();
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Students s = new Students("S0000007", "yh", "ÄÐ", sdf.parse("2017-06-24 10:00:00"), "É½¶«");
		sdao.addStudents(s);
	}
}
