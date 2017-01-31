package com.ml.architecture.mvp.module.qualifiers;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * <p> Interface annotation PerActivity </p>
 *
 * @version 1.0.0
 */
@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}