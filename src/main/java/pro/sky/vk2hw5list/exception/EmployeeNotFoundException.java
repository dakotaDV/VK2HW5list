package pro.sky.vk2hw5list.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundException extends Throwable {

}
