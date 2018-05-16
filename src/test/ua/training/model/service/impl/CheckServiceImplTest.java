package ua.training.model.service.impl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.training.model.entity.Check;

import java.util.List;

import static org.junit.Assert.*;

public class CheckServiceImplTest {

    private CheckServiceImpl checkService;

    @BeforeClass
    public void init() {
        checkService = new CheckServiceImpl();
    }

    @Test
    public void getAllChecks() {
        List<Check> checks = checkService.getAllChecks();
        assertNotNull(checks);
    }

    @Test
    public void getPartOffAllChecks() {
    }

    @Test
    public void getNumberOfChecks() {
    }
}