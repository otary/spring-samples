package cn.chenzw.springcloud.basic.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义zuul过滤
 */
@Component
public class MyZullFilter extends ZuulFilter {

    /**
     * 过滤器类型
     * <ul>
     * <li>pre：路由之前</li>
     * <li>routing：路由之时</li>
     * <li>post：路由之后</li>
     * <li>error：发送错误调用</li>
     * </ul>
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     *
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否过滤
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        Object accessToken = request.getParameter("token");
        if (accessToken == null) {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }
        return null;
    }

}
