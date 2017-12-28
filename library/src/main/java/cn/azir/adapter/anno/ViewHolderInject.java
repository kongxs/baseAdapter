package cn.azir.adapter.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author kongxiangshu
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
@Inherited
public @interface ViewHolderInject {
    int id();
}
