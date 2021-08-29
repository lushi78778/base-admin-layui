package hui.base.config;

import hui.base.interceptor.AuthInterceptor;
import hui.base.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hui
 * @date 2021-08-03 11:20:35
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
	public static final String[] EXCLUDES = {
			"/css/**",
			"/js/**",
			"/img/**",
			"/lib/**",
			"/login",
			"/captcha",
			"/403",
			"/404",
			"/500"
	};

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*registry.addInterceptor(new LoginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns(EXCLUDES);
		registry.addInterceptor(new AuthInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns(EXCLUDES);*/
	}
}
