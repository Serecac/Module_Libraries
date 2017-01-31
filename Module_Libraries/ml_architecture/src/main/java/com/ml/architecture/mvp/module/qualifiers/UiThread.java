package com.ml.architecture.mvp.module.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p> Interface annotation UiThread </p>
 *
 * @version 1.0.0
 */
@Qualifier
@Retention(RUNTIME)
public @interface UiThread {
}
