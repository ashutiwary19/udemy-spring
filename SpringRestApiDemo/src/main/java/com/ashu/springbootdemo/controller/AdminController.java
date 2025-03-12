package com.ashu.springbootdemo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ashu.springbootdemo.model.Clazz;
import com.ashu.springbootdemo.model.Courses;
import com.ashu.springbootdemo.model.Person;
import com.ashu.springbootdemo.repository.ClazzRepository;
import com.ashu.springbootdemo.repository.CoursesRepository;
import com.ashu.springbootdemo.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("admin")
public class AdminController {

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private ClazzRepository clazzRepository;

	@Autowired
	private CoursesRepository coursesRepository;

	@GetMapping("/displayClasses")
	public ModelAndView displayClasses(Model model) {
		List<Clazz> classes = clazzRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("classes.html");
		modelAndView.addObject("eazyClass", new Clazz());
		modelAndView.addObject("eazyClasses", classes);
		return modelAndView;
	}

	@PostMapping("/addNewClass")
	public ModelAndView addNewClass(Model model, @ModelAttribute("eazyClass") Clazz clazz) {
		clazzRepository.save(clazz);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
		return modelAndView;
	}

	@GetMapping("/deleteClass")
	public ModelAndView deleteClasses(Model model, @RequestParam int id) {
		Optional<Clazz> classes = clazzRepository.findById(id);
		List<Person> studentsList = classes.get().getStudents().stream().map(student -> {
			student.setClazz(null);
			return student;
		}).collect(Collectors.toList());
		personRepository.saveAll(studentsList);
		clazzRepository.deleteById(id);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayClasses");
		return modelAndView;
	}

	@GetMapping("/displayStudents")
	public ModelAndView displayStudents(Model model, @RequestParam Integer classId, HttpSession session,
			@RequestParam(value = "error", required = false) Boolean error) {
		ModelAndView modelAndView = new ModelAndView("students.html");
		Optional<Clazz> clazz = clazzRepository.findById(classId);
		modelAndView.addObject("eazyClass", clazz.get());
		modelAndView.addObject("student", new Person());
		session.setAttribute("clazz", clazz.get());
		if (error != null && error) {
			modelAndView.addObject("errorMessage", "Invalid Email address!!");
		}
		return modelAndView;
	}

	@PostMapping("/addStudent")
	public ModelAndView addStudent(Model model, @ModelAttribute("student") Person student, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Clazz clazz = (Clazz) session.getAttribute("clazz");
		student = personRepository.getByEmail(student.getEmail());
		if (student == null || student.getPersonId() <= 0) {
			modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + clazz.getClassId() + "&error=true");
			return modelAndView;
		}
		student.setClazz(clazz);
		personRepository.save(student);
		if (clazz.getStudents() == null) {
			clazz.setStudents(new ArrayList<>());
		}
		clazz.getStudents().add(student);
		clazzRepository.save(clazz);
		modelAndView.setViewName("redirect:/admin/displayStudents?classId=" + clazz.getClassId());
		return modelAndView;
	}

	@GetMapping("/deleteStudent")
	public ModelAndView deleteStudent(Model model, @RequestParam Integer studentId, HttpSession session) {
		Clazz clazz = (Clazz) session.getAttribute("clazz");
		Optional<Person> student = personRepository.findById(studentId);
		student.get().setClazz(null);
		if (clazz.getStudents() != null) {
			clazz.getStudents().remove(student.get());
		}
		session.setAttribute("clazz", clazzRepository.save(clazz));
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayStudents?classId=" + clazz.getClassId());
		return modelAndView;
	}

	@GetMapping("/displayCourses")
	public ModelAndView displayCourses(Model model) {
		ModelAndView modelAndView = new ModelAndView("courses_secure.html");
//		modelAndView.addObject("courses", coursesRepository.findByOrderByNameDesc());
		modelAndView.addObject("courses", coursesRepository.findAll(Sort.by("fees").descending()));

		modelAndView.addObject("course", new Courses());
		return modelAndView;
	}

	@PostMapping("/addNewCourse")
	public ModelAndView addNewCourses(Model model, @ModelAttribute("course") Courses courses) {
		coursesRepository.save(courses);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/displayCourses");
		return modelAndView;
	}

	@GetMapping("/viewStudents")
	public ModelAndView viewStudents(Model model, @RequestParam int id, HttpSession session,
			@RequestParam(required = false) String error) {
		ModelAndView modelAndView = new ModelAndView("course_students.html");
		Optional<Courses> courses = coursesRepository.findById(id);
		modelAndView.addObject("courses", courses.get());
		modelAndView.addObject("person", new Person());
		session.setAttribute("courses", courses.get());
		if (error != null) {
			modelAndView.addObject("errorMessage", "Invalid Email!!");
		}
		return modelAndView;
	}

	@PostMapping("/addStudentToCourse")
	public ModelAndView addStudentToCourse(Model model, @ModelAttribute("person") Person person, HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		Courses courses = (Courses) session.getAttribute("courses");
		person = personRepository.getByEmail(person.getEmail());
		if (person == null || person.getPersonId() <= 0) {
			modelAndView.setViewName("redirect:/admin/viewStudents?id=" + courses.getCourseId() + "&error=true");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/admin/viewStudents?id=" + courses.getCourseId());
		courses.getPersons().add(person);
		person.getCourses().add(courses);
		personRepository.save(person);
		session.setAttribute("courses", courses);
		return modelAndView;
	}

	@GetMapping("/deleteStudentFromCourse")
	public ModelAndView deleteStudentFromCourse(Model model, @RequestParam int personId, HttpSession session) {
		Courses courses = (Courses) session.getAttribute("courses");
		Optional<Person> person = personRepository.findById(personId);
		person.get().getCourses().remove(courses);
		courses.getPersons().remove(person);
		personRepository.save(person.get());
		session.setAttribute("courses", courses);
		ModelAndView modelAndView = new ModelAndView("redirect:/admin/viewStudents?id=" + courses.getCourseId());
		return modelAndView;
	}

}
