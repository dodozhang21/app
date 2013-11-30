package com.parents.checklist.dao;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertNull;
import static junit.framework.Assert.assertTrue;

import java.io.IOException;

import org.hibernate.PropertyValueException;
import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.parents.checklist.model.Checklist;
import com.parents.checklist.model.Task;
import com.parents.checklist.model.User;
import com.parents.dao.AbstractBaseDaoTest;

public class ChecklistDaoTest extends AbstractBaseDaoTest {
    @Autowired
    @Qualifier("userDao")
    private UserDaoImpl userDao;

    @Autowired
    @Qualifier("checklistDao")
    private ChecklistDaoImpl checklistDao;

    // these tests are really used to test MAPPINGs!!!
    // we do not really want to re-test hibernate

    @Before
    public void insertData() throws IOException {
        String importSql = getFileContent("ChecklistDaoTest.sql");
        sessionFactory.getCurrentSession().createSQLQuery(importSql).executeUpdate();
    }

    @Test
    @Transactional
    public void testCreateSimpleUser() {
        // arrange
        User user = new User();
        user.setUsername("hellokitty");

        // act
        userDao.save(user);

        // assert
        assertNotNull(user.getId());
    }

    @Test
    @Transactional
    public void testFindUserByUsername() {
        User user = userDao.findByUsername("bubo");

        assertNotNull(user);
        assertEquals(500L, user.getId().longValue());

        User anotherUser = userDao.findByUsername("doesNotExist");
        assertNull(anotherUser);

    }

    @Test
    @Transactional
    public void testAddChecklistToExistingUser() {
        User bubo = userDao.findByUsername("bubo");

        assertNotNull(bubo);
        assertEquals(500L, bubo.getId().longValue());

        Checklist checklist = new Checklist();
        checklist.setLastUpdated(new DateTime("2013-11-22"));
        checklist.setName("bubo's checklist");
        checklist.setOwner(bubo);

        checklistDao.save(checklist);

        assertNotNull(checklist.getId());

    }

    @Test
    @Transactional
    public void testCreateChecklistWithNoUser() {
        // expect exceptions (junit enforces you to put this at the beginning, lame :/)
        expectedEx.expect(PropertyValueException.class);
        expectedEx.expectMessage("not-null property references a null or transient value: com.parents.checklist.model.Checklist.owner");

        // arrange
        Checklist emptyChecklist = new Checklist();
        emptyChecklist.setLastUpdated(new DateTime("2013-11-22"));

        // act
        checklistDao.save(emptyChecklist);
    }

    @Test
    @Transactional
    public void testExistingLists() {
        User bubo = userDao.findByUsername("bubo");

        // get check list
        assertEquals(1, bubo.getChecklists().size());
        Checklist c1 = bubo.getChecklists().get(0);
        assertEquals(600L, c1.getId().longValue());
        assertEquals("bubos existing list", c1.getName());
        assertEquals("2013-11-22", c1.getLastUpdated().toLocalDate().toString());

        // get tasks
        assertEquals(2, c1.getTasks().size());
        Task t1 = c1.getTasks().get(0);
        assertFalse(t1.isCompleted());
        assertEquals("Task 2 Not Completed", t1.getDescription());
        Task t2 = c1.getTasks().get(1);
        assertTrue(t2.isCompleted());
        assertEquals("Task 1 Completed", t2.getDescription());

    }
}
