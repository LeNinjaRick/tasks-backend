package br.ce.wcaquino.taskbackend.controller;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.ce.wcaquino.taskbackend.model.Task;
import br.ce.wcaquino.taskbackend.repo.TaskRepo;
import br.ce.wcaquino.taskbackend.utils.ValidationException;

public class TaskControllerTest {

	
	@Mock
	private TaskRepo taskRepo; 
	
	@InjectMocks
	private TaskController controller;
	
	@Before
	public void setup() {
	MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void retornoErroPorDescricaoVazia(){
		Task todo = new Task();
		
		todo.setDueDate(LocalDate.of(2030, 5, 12));
		
		try {
			controller.save(todo);
			Assert.fail("não deve chegar aqui!!!");
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the task description", e.getMessage());
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	@Test
	public void retornoErroPorDueDateVazio() {
	Task todo = new Task();
		todo.setTask("descricao");
		//todo.setDueDate(LocalDate.of(2030, 5, 12));
		
		try {
			controller.save(todo);
			Assert.fail("não deve chegar aqui!!!");
		} catch (ValidationException e) {
			Assert.assertEquals("Fill the due date", e.getMessage());
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	
	
	@Test
	public void retornoErroPorDueDateNoPassado() {
		Task todo = new Task();
		todo.setTask("descricao");
		todo.setDueDate(LocalDate.of(2010, 5, 12));
		
		try {
			controller.save(todo);
			Assert.fail("não deve chegar aqui!!!");
		} catch (ValidationException e) {
			Assert.assertEquals("Due date must not be in past", e.getMessage());
			System.out.println(e.getMessage());
		}
		
		
	}

	@Test
	public void retornoCertoPorFluxoCorreto() throws ValidationException {
		
		Task todo = new Task();
		todo.setTask("descricao");
		todo.setDueDate(LocalDate.of(2030, 5, 12));
		
			controller.save(todo);
			
			//verificação do mockito 
			Mockito.verify(taskRepo).save(todo);


	}
	
	
	
	
	
	
	
}
