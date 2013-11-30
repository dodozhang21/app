package com.parents.checklist.service;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

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
	
	@Before
    public void mockDao() throws IOException {
		User user = new User();
		List<Checklist> checklists = new ArrayList<Checklist>();
		Checklist checklist1 = new Checklist();
		Checklist checklist2 = new Checklist();
		checklists.add(checklist1);
		checklists.add(checklist2);
		user.setChecklists(checklists);
		when(userDao.findByUsername("bubo")).thenReturn(user);
        
    }
	
	@Test
	public void testGetListsForUser() {
		// arrange (mocked up)
		
		// act
		List<Checklist> results = checklistService.getListsForUser("bubo");
		
		// assert
		Assert.assertEquals(2, results.size());
	}

}
