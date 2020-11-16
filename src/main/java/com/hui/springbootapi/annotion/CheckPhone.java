package com.hui.springbootapi.annotion;

import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.PARAMETER,ElementType.METHOD,ElementType.FIELD,ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME)
@Pattern(regexp = "1[3|4|5|6|7|8][0-9]\\d{8}")
@Null
@Constraint(validatedBy = {})
// 所有约束是AND/OR/ALL_FALSE关系。它只能标注在注解上，运用于组合注解上
@ConstraintComposition(CompositionType.OR)
// 如果@NotEmpty、@Pattern都校验失败，不添加此注解，则会生成两个校验失败的结果。
// 若添加了此注解，那错误消息以它标注的本注解的message为准
@ReportAsSingleViolation
public @interface CheckPhone {
    String message() default "手机号格式不正确";
    Class<?>[] groups() default {};
    Class<? extends Payload>[]  payload() default {};

}
