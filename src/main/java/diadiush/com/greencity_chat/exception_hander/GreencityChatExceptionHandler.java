package diadiush.com.greencity_chat.exception_hander;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GreencityChatExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GreencityChatIncorrectData> handleException(NoSuchChatException exception) {
        GreencityChatIncorrectData data = new GreencityChatIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<GreencityChatIncorrectData> handleException(Exception exception) {
        GreencityChatIncorrectData data = new GreencityChatIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
