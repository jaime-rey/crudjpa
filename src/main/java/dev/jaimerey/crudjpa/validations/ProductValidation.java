package dev.jaimerey.crudjpa;

import dev.jaimerey.crudjpa.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name","NotEmpty.product.name");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description", "NotBlank.product.description","desc vacio");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"price","NotNull.product.price","precio vacio");
    }
}
