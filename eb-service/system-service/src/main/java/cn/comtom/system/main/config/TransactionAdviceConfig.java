package cn.comtom.system.main.config;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

import java.util.Collections;

/**
 * 事务配置类
 *
 * @author guomao
 */
@Aspect
@Configuration
public class TransactionAdviceConfig {
    private static final String AOP_POINTCUT_EXPRESSION = "execution (* cn.comtom.system..*.service.*.*(..))";

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public TransactionInterceptor txAdvice() {

        RuleBasedTransactionAttribute required = new RuleBasedTransactionAttribute();
        required.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        required.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);

        RuleBasedTransactionAttribute requiredReadonly = new RuleBasedTransactionAttribute();
        requiredReadonly.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        requiredReadonly.setIsolationLevel(TransactionDefinition.ISOLATION_READ_COMMITTED);
        RollbackRuleAttribute rollbackRuleAttribute = new RollbackRuleAttribute(Exception.class);
        requiredReadonly.setRollbackRules(Collections.singletonList(rollbackRuleAttribute));
        requiredReadonly.setReadOnly(true);

        NameMatchTransactionAttributeSource source = new NameMatchTransactionAttributeSource();
        source.addTransactionalMethod("add*", required);
        source.addTransactionalMethod("save*", required);
        source.addTransactionalMethod("delete*", required);
        source.addTransactionalMethod("update*", required);
        source.addTransactionalMethod("merge*", required);
        source.addTransactionalMethod("exec*", required);
        source.addTransactionalMethod("set*", required);
        source.addTransactionalMethod("get*", requiredReadonly);
        source.addTransactionalMethod("select*", requiredReadonly);
        source.addTransactionalMethod("query*", requiredReadonly);
        source.addTransactionalMethod("find*", requiredReadonly);
        source.addTransactionalMethod("list*", requiredReadonly);
        source.addTransactionalMethod("count*", requiredReadonly);
        source.addTransactionalMethod("is*", requiredReadonly);
        return new TransactionInterceptor(transactionManager, source);
    }

    @Bean
    public Advisor txAdviceAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(AOP_POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, txAdvice());
    }
}