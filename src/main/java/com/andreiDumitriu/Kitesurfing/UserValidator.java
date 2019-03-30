package com.andreiDumitriu.Kitesurfing;


import com.andreiDumitriu.Kitesurfing.model.User;
import com.andreiDumitriu.Kitesurfing.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator{

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors err){
        User user = (User) obj;

        ValidationUtils.rejectIfEmptyOrWhitespace(err,"username","NotEmpty");
        if (user.getUsername().length()<5 || user.getUsername().length()>20){
            err.rejectValue("username","Size.userForm.username");
        }
        if (userService.findByUsername(user.getUsername())!=null){
            err.rejectValue("username","Duplicate.userForm.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(err,"password","NotEmpty");
        if (user.getPassword().length()<8 || user.getPassword().length()>20){
            err.rejectValue("password","Size.userForm.password");
        }
        if(!user.getPasswordConfirmation().equals(user.getPassword())){
            err.rejectValue("passwordConfirmation","Diff.userForm.passwordConfirm");
        }

    }



}
