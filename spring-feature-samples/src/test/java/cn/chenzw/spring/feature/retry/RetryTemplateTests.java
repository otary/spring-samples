package cn.chenzw.spring.feature.retry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

/**
 * 重试模版
 */
@RunWith(JUnit4.class)
public class RetryTemplateTests {

    @Test
    public void test() throws Throwable {
        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();

        // 最多尝试次数
        simpleRetryPolicy.setMaxAttempts(5);

        // simpleRetryPolicy.registerThrowable();


        RetryTemplate retryTemplate = new RetryTemplate();
        retryTemplate.setRetryPolicy(simpleRetryPolicy);

        Boolean result = retryTemplate.execute(new RetryCallback<Boolean, Throwable>() {

            private int count = 0;

            @Override
            public Boolean doWithRetry(RetryContext retryContext) throws Throwable {
                if (count++ < 5) {
                    throw new Exception("exception happen:" + count);
                }

                return true;
            }
        });

    }
}
