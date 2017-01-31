package com.ml.architecture.mvp.presenter.view_injector;

/**
 * <p> Interface ViewInjector </p>
 * Usualy Used add interface custom view to Presenter
 * @see com.ml.architecture.mvp.presenter.Presenter
 *
 * @version 1.0.0
 */
public interface ViewInjector {
    /**
     * Detach view v.
     *
     * @param <V>    the type parameter
     * @param view   the view
     * @param aClass the a class
     * @return the v
     */
    <V> V detachView(V view, Class<?> aClass);

    /**
     * Inject view v.
     *
     * @param <V>    the type parameter
     * @param view   the view
     * @param aClass the a class
     * @return the v
     */
    <V> V injectView(V view, Class<?> aClass);
}
