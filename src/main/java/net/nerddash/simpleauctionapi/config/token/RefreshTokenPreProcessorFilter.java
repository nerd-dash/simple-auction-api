package net.nerddash.simpleauctionapi.config.token;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.catalina.util.ParameterMap;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RefreshTokenPreProcessorFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;

		if ("/oauth/token".equalsIgnoreCase(httpServletRequest.getRequestURI())
				&& "refresh_token".equals(httpServletRequest.getParameter("grant_type"))
				&& httpServletRequest.getCookies() != null) {
			for (Cookie cookie : httpServletRequest.getCookies()) {
				if (cookie.getName().equals("refreshToken")) {
					String refreshToken = cookie.getValue();
					httpServletRequest = new ApiServletRequestWrapper(httpServletRequest, refreshToken);
				}
			}
		}
		
		chain.doFilter(httpServletRequest, response);
	}

	static class ApiServletRequestWrapper extends HttpServletRequestWrapper {

		private String refresheToken;

		public ApiServletRequestWrapper(HttpServletRequest request, String refreshToken) {
			super(request);
			this.refresheToken = refreshToken;
		}

		@Override
		public Map<String, String[]> getParameterMap() {
			ParameterMap<String, String[]> map = new ParameterMap<>(getRequest().getParameterMap());
			map.put("refresh_token", new String[] { refresheToken });
			map.setLocked(true);
			return map;

		}

	}

}
