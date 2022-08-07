
// 第2章 事务的两种实现方式


package org.javaboy.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


@Component
public class UserService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    PlatformTransactionManager transactionManager;
    @Autowired
    TransactionTemplate transactionTemplate;

//    2.3 XML+配置声明式事务
    @Transactional  //2.5 Java+XML混合配置声明式事务
    public void transfer3() {
        jdbcTemplate.update("update user set money = ? where username=?", 99, "zahngsan");
        int i= 1/0;
    }

//    2.2 TransactionTemplate+实现编程式事务
    public void transfer2(){
        //配置隔离性
        transactionTemplate.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);
        transactionTemplate.setPropagationBehavior(TransactionDefinition.ISOLATION_SERIALIZABLE);   // 3.12 事务属性配置方式
        transactionTemplate.setReadOnly(true);  // 3.12 事务属性配置方式
        transactionTemplate.setTimeout(3000);   // 3.12 事务属性配置方式
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                try{
                jdbcTemplate.update("update user set money = ? where username=?", 9, "zahngsan");
                int i = 1/0; //测试用的错误
                } catch (DataAccessException e){
                    //设置当前事务回滚
                    status.setRollbackOnly();
                    e.printStackTrace();
                }
            }
        });
    }

    // 2.1 PlatformTransactionManager+实现编程式事务
    public void transfer(){
        //1. 定义默认的事务属性
        DefaultTransactionDefinition definition = new DefaultTransactionDefinition();
        definition.setIsolationLevel(TransactionDefinition.ISOLATION_SERIALIZABLE);     //隔离性
        //2. 获取 TransactionStatus
        TransactionStatus status = transactionManager.getTransaction(definition);
        try {
            jdbcTemplate.update("update user set money = ? where username=?", 9, "zahngsan");
            int i = 1/0; //测试用的错误
            //提交事务
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            e.printStackTrace();
            //回滚事务
            transactionManager.rollback(status);
        }
    }
}
