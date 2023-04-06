package cn.chenzw.spring.mvc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 过滤器
 */
public class SamplesFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(SamplesFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        logger.info("- OncePerRequestFilter doFilterInternal");

        filterChain.doFilter(request, response);
    }
}
