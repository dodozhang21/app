package com.parents.checklist.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.parents.checklist.dao.ChecklistDaoImpl;
import com.parents.checklist.dao.UserDaoImpl;
import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.User;

@RunWith(MockitoJUnitRunner.class)
public class ChecklistServiceTest {
	@Mock
	private UserDaoImpl userDao;
	@Mock
	private ChecklistDaoImpl checklistDao;
	
	@InjectMocks
	private ChecklistService checklistService = new ChecklistService();
	
	private User userWithLists = new User();
	
	@Before
    public void mockDao() throws IOException {
		List<Checklist> checklists = new ArrayList<Checklist>();
		Checklist checklist1 = new Checklist();
		Checklist checklist2 = new Checklist();
		checklists.add(checklist1);
		checklists.add(checklist2);
		userWithLists.setChecklists(checklists);
        
    }
	
	@Test
	public void testGetListsForUserWithList() {
		// arrange (mocked up)
		when(userDao.findByUsername("bubo")).thenReturn(userWithLists);
		
		// act
		List<Checklist> results = checklistService.getListsForUser("bubo");
		
		// assert
		assertEquals(2, results.size());
	}
	
	@Test
	public void testGetListsForNullUser() {
		// arrange (mocked up)
		when(userDao.findByUsername("bubo")).thenReturn(null);
		
		// act
		List<Checklist> results = checklistService.getListsForUser("bubo");
		
		// assert
		assertEquals(0, results.size());
	}

}
