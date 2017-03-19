package action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.struts2.json.JSONResult;

import com.opensymphony.xwork2.ModelDriven;

import entity.Students;

import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

/**
 * @author Administrator
 * 
 */
public class StudentsAction extends SuperAction implements ModelDriven<Students> {
	private static final long serialVersionUID = 1L;
	private String result;
	private Map dataMap;
	private Students students = new Students();
	
	

	public Map getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * 查询所有学生(ajax请求)
	 * @return SUCCESS
	 */
	public String query() {
		try {
			StudentsDAO sdao = new StudentsDAOImpl();
			List<Students> list = sdao.queryAllStudents();
			
			dataMap = new HashMap();
			dataMap.clear();
			int index = 0;
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Students students = (Students) iterator.next();
				dataMap.put("students" + index++, students);
			}
			//dataMap.put("success", true);	 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	
	/**
	 * 根据学号删除学生
	 * @param sid 学号
	 * @return SUCCESS
	 */
	public String delete() {
		
		try {
			StudentsDAO sdao = new StudentsDAOImpl();
			sdao.deleteStudents(students.getSid());
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
		}
		//System.out.println(students.getSid());
		return null;
		
	}
	
	/**
	 * @return
	 * 添加一条记录
	 */
	public String add() {
		
		try {
			StudentsDAO sdao = new StudentsDAOImpl();
			sdao.addStudents(students);
			dataMap = new HashMap();
			dataMap.clear();
			dataMap.put("success", true);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	@Override
	public Students getModel() {
		
		return this.students;
	}
}
