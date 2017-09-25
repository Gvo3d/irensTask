package org.yakimovdenis.multimedia;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.yakimovdenis.multimedia.TestDaoConfig;
import org.yakimovdenis.multimedia.models.DBEntity;
import org.yakimovdenis.multimedia.models.MediaType;
import org.yakimovdenis.multimedia.service.DBEntityServiceImpl;
import org.yakimovdenis.multimedia.service.DBEntitysService;


import java.util.Date;
import java.util.List;

@ContextConfiguration(classes = {TestDaoConfig.class, DBEntityServiceImpl.class})
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class})
public class DatabaseTests {
    private static final String SEPARATOR = "********************************************";

    @Autowired
    private DBEntitysService dbEntitysService;

    @Test
    public void testFindAllRewards() {
        List<DBEntity> list = dbEntitysService.getAllWithType(MediaType.BOOK.ordinal(), "id");
        System.out.println(list);
    }
}
