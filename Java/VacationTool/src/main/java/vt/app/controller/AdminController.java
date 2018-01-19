package vt.app.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vt.app.controller.base.BaseController;
import vt.db.model.entity.Department;
import vt.db.model.entity.Employee;

@Controller
@Secured("ROLE_ADMIN")
public class AdminController extends BaseController {
	@RequestMapping(value = { "/a/", "/a/index" }, method = RequestMethod.GET)
	public String adminIndex(HttpSession session, Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		
		buildMainPanel(session, model, username);
		
		return "a/index";
	}
	
	
	@RequestMapping(value = "/a/employee", method = RequestMethod.GET)
	public String employee(HttpSession session, Model model) {
		List<Employee> employees = emp.getEmp().findAll(Employee.class);
		model.addAttribute("employees", employees);
		model.addAttribute("employeeform", new Employee());
		model.addAttribute("dept", dept);
		model.addAttribute("pos", pos);
		model.addAttribute("emp", emp);
		
		return "a/employee";
	}
	@RequestMapping(value = "/modifyemployee", method = RequestMethod.POST)
	public String modifyEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		try {
			emp.getEmp().update(employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:a/employee";
	}
	@RequestMapping(value = "/deleteemployee", method = RequestMethod.POST)
	public String deleteEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		try {
			emp.getEmp().delete(employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:a/employee";
	}
	@RequestMapping(value = "/addemployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value = "employeeform") Employee employee) {
		String pwd = emp.passwordEncoder().encode(employee.getEmpPassword());
		employee.setEmpPassword(pwd);
		try {
			String dep = dept.getDepartmentById(employee.getEmpDepartmentId()).getDepName().substring(0, 1);
			int id = emp.getEmp().save(employee);
			
			String number = dep.concat(String.valueOf(0)).concat(String.valueOf(id));
			employee.setEmpEvidenceNumber(number);
			emp.getEmp().update(employee);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:a/employee";
	}
	@RequestMapping(value = "/a/department", method = RequestMethod.GET)
	public String department(HttpSession session, Model model) {
		List<Department> departments = dept.getDept().findAll(Department.class);
		model.addAttribute("departments", departments);
		model.addAttribute("departmentform", new Department());
		
		return "a/department";
	}
	@RequestMapping(value = "/modifydepartment", method = RequestMethod.POST)
	public String modifyDepartment(@ModelAttribute(value = "departmentform") Department department) {
		try {
			dept.getDept().update(department);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:a/department";
	}
	@RequestMapping(value = "/deletedepartment", method = RequestMethod.POST)
	public String deleteDepartment(@ModelAttribute(value = "departmentform") Department department) {
		try {
			dept.getDept().delete(department);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:a/department";
	}
	@RequestMapping(value = "/adddepartment", method = RequestMethod.POST)
	public String addDepartment(@ModelAttribute(value = "departmentform") Department department) {
		try {
			dept.getDept().save(department);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return "redirect:a/department";
	}
	
	
}