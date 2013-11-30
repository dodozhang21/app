package com.parents.dao;

import org.apache.commons.io.FileUtils;
import org.hibernate.SessionFactory;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-dao-layer.xml")
public class AbstractBaseDaoTest {
    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Autowired
    protected SessionFactory sessionFactory;

    protected String getFileContent(String filename) throws IOException {
        return FileUtils.readFileToString(new File(getClass().getResource(filename).getFile()));
    }

}
