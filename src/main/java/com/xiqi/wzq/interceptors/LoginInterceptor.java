package com.xiqi.wzq.interceptors;

import com.xiqi.wzq.entity.Token;
import com.xiqi.wzq.repo.TokenRepository;
import com.xiqi.wzq.utils.JwtUtils;
import com.xiqi.wzq.utils.SpringUtils;
import com.xiqi.wzq.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

/**
 * 登陆拦截器
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final TokenRepository tokenRepository = SpringUtils.getBean(TokenRepository.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 令牌验证
        String token = request.getHeader("Authorization");

        // 验证token
        try {
            // 从Redis中取出相同的token
            Token h2_token = tokenRepository.findByToken(token);


            if (!h2_token.isExpires()) {
                // token 已经失效
                throw new RuntimeException();
            }
            Map<String, Object> claims = JwtUtils.parseToken(token);
            // 把业务数据存储到ThreadLocal中
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        } catch (Exception e) {
            // http相应状态码为401
            response.setStatus(401);
            // 不放行
            return false;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清空缓存数据
        ThreadLocalUtil.remove();
    }
}
