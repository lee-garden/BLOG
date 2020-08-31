package garden.practice.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;

@Slf4j
public class SecondFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("SecondFilter가 생성 됩니다.");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("==========Second 필터 시작!==========");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("==========Second 필터 종료!==========");
    }

    @Override
    public void destroy() {
        log.info("SecondFilter가 사라집니다.");
    }
}
