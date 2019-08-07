package app.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@Slf4j
public class MyErrorController implements ErrorController {

	@RequestMapping("/error")
	@ResponseBody
	public ModelAndView handleError(HttpServletRequest request) {
		String err = String.valueOf(request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
		log.warn("Someone made a mistake: " + err);
		return new ModelAndView("redirect:http://www.nooooooooooooooo.com/");
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
