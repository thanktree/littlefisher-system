package com.yc.room1000.core.interceptor;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.yc.room1000.core.exception.BaseAppException;
import com.yc.room1000.core.exception.BaseRuntimeException;
import com.yc.room1000.core.utils.Room1000Logger;

/**
 * 
 * Description: 
 *  
 * Created on 2017年2月10日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
public class SpringTransactionInterceptor extends AbstractCommandInterceptor {

    /**
     * LOGGER
     */
    private static final Room1000Logger logger = Room1000Logger.getLogger(SpringTransactionInterceptor.class);

    /**
     * transactionManager
     */
    protected PlatformTransactionManager transactionManager;

    /**
     * SpringTransactionInterceptor
     * 
     * @param transactionManager <br>
     */
    public SpringTransactionInterceptor(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @return <br>
     * @throws BaseAppException <br>
     */
    private int getPropagation(CommandConfig config) throws BaseAppException {
        switch (config.getTransactionPropagation()) {
            case NOT_SUPPORTED:
                return TransactionTemplate.PROPAGATION_NOT_SUPPORTED;
            case REQUIRED:
                return TransactionTemplate.PROPAGATION_REQUIRED;
            case REQUIRES_NEW:
                return TransactionTemplate.PROPAGATION_REQUIRES_NEW;
            default:
                throw new BaseAppException("Unsupported transaction propagation: " + config.getTransactionPropagation());
        }
    }

    /**
     * 
     * Description: <br> 
     *  
     * @author zeng.ligeng<br>
     * @taskId <br>
     * @param config <br>
     * @param command <br>
     * @return <br>
     */
    public Object execute(final CommandConfig config, final Command command) {
        logger.debug("Running command with propagation {}", config.getTransactionPropagation());

        TransactionTemplate transactionTemplate = new TransactionTemplate(transactionManager);
        try {
            transactionTemplate.setPropagationBehavior(getPropagation(config));
        }
        catch (Exception e) {
            transactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRED);
        }

        Object result = transactionTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus status) {
                Object result;
                try {
                    result = next.execute(config, command);
                }
                catch (Exception e) {
                    throw new BaseRuntimeException("inerror", e);
                }
                return result;

            }
        });

        return result;
    }
}
