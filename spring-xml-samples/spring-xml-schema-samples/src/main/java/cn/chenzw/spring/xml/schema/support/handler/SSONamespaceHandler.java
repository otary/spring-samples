package cn.chenzw.spring.xml.schema.support.handler;

import cn.chenzw.spring.xml.schema.support.parser.SSOTemplateScanBeanDefinitionParser;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * XML命名空间处理器
 * @author chenzw
 */
public class SSONamespaceHandler extends NamespaceHandlerSupport {

    public void init() {
        registerBeanDefinitionParser("template-scan", new SSOTemplateScanBeanDefinitionParser());
    }
}
