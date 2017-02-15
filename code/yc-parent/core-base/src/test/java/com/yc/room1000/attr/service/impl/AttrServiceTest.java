package com.yc.room1000.attr.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.yc.room1000.attr.dto.AttrDto;
import com.yc.room1000.attr.service.IAttrService;
import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月11日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/EngineConfig.xml")
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class AttrServiceTest {
    
    /**
     * logger
     */
    private static Room1000Logger logger = Room1000Logger.getLogger(AttrServiceTest.class);
        
    /**
     * attrService
     */
    @Autowired
    private IAttrService attrService;
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     * @throws BaseAppException 
     *
     */
    @Test
    public void testQryAttrById() throws BaseAppException {
        logger.debug("testQryAttrById start");
        Long attrId = 1L;
        AttrDto attr = attrService.selectById(attrId);
        logger.debug("attr : " + attr);
    }

}
