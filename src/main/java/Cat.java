import org.springframework.context.annotation.Configuration;

@Configuration
public class Cat {

    private String message;

    public String getMessage(){
        return  message;
    }

    public void  setMessage(String message){
        this.message = message;
    }

}