package hui.base.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 异常页面
 *
 * @author hui
 * @date 2021-08-03 12:00:45
 */
@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar {
	@Override
	public void registerErrorPages(ErrorPageRegistry registry) {
		ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
		ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
		ErrorPage e403 = new ErrorPage(HttpStatus.FORBIDDEN, "/403");
		registry.addErrorPages(e500, e404, e403);
	}
}
