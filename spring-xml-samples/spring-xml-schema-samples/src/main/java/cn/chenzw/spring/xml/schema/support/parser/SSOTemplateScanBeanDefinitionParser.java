package cn.chenzw.spring.xml.schema.support.parser;

import cn.chenzw.spring.xml.schema.support.SSO;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.StringUtils;
import org.w3c.dom.Element;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * ±êÇ©½âÎöÆ÷
 * @author chenzw
 */
public class SSOTemplateScanBeanDefinitionParser implements BeanDefinitionParser {

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        String basePackage = element.getAttribute("base-package");
        basePackage = parserContext.getReaderContext().getEnvironment().resolvePlaceholders(basePackage);
        String[] basePackages = StringUtils.tokenizeToStringArray(basePackage, ",; \t\n");

        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(SSO.class));
        Set<BeanDefinition> beans = new LinkedHashSet<BeanDefinition>();
        for (String _basePackage : basePackages) {
            beans.addAll(scanner.findCandidateComponents(_basePackage));
        }

        for (BeanDefinition bean : beans) {
            parserContext.getReaderContext().getRegistry().registerBeanDefinition(bean.getBeanClassName(), bean);
        }

        return null;
    }


}
