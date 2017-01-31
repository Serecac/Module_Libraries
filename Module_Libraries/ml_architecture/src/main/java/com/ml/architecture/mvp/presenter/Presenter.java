package com.ml.architecture.mvp.presenter;

import com.ml.architecture.mvp.presenter.view_injector.ViewInjector;

/**
 * <p> Class Presenter </p>
 * Used to manage interactions with ui
 *
 * @param <V> custom view type
 * @version 1.0.0
 */
public abstract class Presenter<V> {
    private final Class<V> typeView;
    private ViewInjector viewInjector;
    private V view;

    /**
     * Instantiates a new Presenter.
     *
     * @param viewInjector the view injector
     * @param typeView     the type view
     */
    public Presenter(ViewInjector viewInjector, Class<V> typeView) {
        this.viewInjector = viewInjector;
        this.typeView = typeView;
    }

    /**
     * Attach view.
     *
     * @param view the view
     */
    public void attachView(V view) {
        this.view = viewInjector.injectView(view, typeView);
        onViewAttached();
    }

    /**
     * Detach view.
     */
    public void detachView() {
        this.view = viewInjector.detachView(view, typeView);
    }

    /**
     * Gets view.
     *
     * @return the view
     */
    public V getView() {
        return view;
    }

    /**
     * On view attached.
     */
    public abstract void onViewAttached();
}
