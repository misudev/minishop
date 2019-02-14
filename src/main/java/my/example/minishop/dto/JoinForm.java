package my.example.minishop.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class JoinForm {
    @NotNull
    @Size(min=2, max=30)
    private String name;
    @NotNull
    @Size(min=2, max=20)
    private String nickName;
    @NotNull
    @Size(min=4, max=255)
    private String email;
    @NotNull
    @Size(min=4, max=12)
    private String password1;
    @NotNull
    @Size(min=4, max=12)
    private String password2;
}