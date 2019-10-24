package com.netcracker.tc.client.validation;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.validation.client.AbstractGwtValidatorFactory;
import com.google.gwt.validation.client.GwtValidation;
import com.google.gwt.validation.client.impl.AbstractGwtValidator;
import com.google.gwt.validation.client.impl.Validation;
import com.netcracker.tc.shared.model.interview.InterviewDTO;
import com.netcracker.tc.shared.model.resume.DevResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.QAResumeDetailDTO;
import com.netcracker.tc.shared.model.resume.ResumeDTO;
import com.netcracker.tc.shared.model.user.UserDTO;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.Set;

public class ValidationFactory extends AbstractGwtValidatorFactory {

    public static <T> Set<ConstraintViolation<T>> validate(T entity, Class<?> ... groups) {
        return Validation.buildDefaultValidatorFactory().getValidator().validate(entity, groups);
    }

    @Override
    public AbstractGwtValidator createValidator() {
        return GWT.create(GwtValidator.class);
    }

    /**
     * Validator marker for the Validation Sample project. Only the classes
     * listed in the {@link com.google.gwt.validation.client.GwtValidation} annotation can be validated.
     */
    @GwtValidation(value = {UserDTO.class, ResumeDTO.class, DevResumeDetailDTO.class, QAResumeDetailDTO.class, InterviewDTO.class})
    public interface GwtValidator extends Validator {
    }
}