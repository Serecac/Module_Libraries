package com.ml.architecture.mvp.presenter.view_injector;

import me.panavtec.threaddecoratedview.views.ThreadSpec;
import me.panavtec.threaddecoratedview.views.qualifiers.ThreadDecoratedView;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <p> class ViewInjectorImp </p>
 * Extended implementation of ViewInjector
 * @see ViewInjector
 *
 * @version 1.0.0
 */
public class ViewInjectorImp implements ViewInjector {

    private static final String DECORATED_CLASS_PREFIX = "Decorated";
    private static final String NULL_CLASS_PREFIX = "Null";
    private ThreadSpec mThreadSpec;

    /**
     * Instantiates a new ViewInjectorImp.
     *
     * @param threadSpec the thread spec
     */
    public ViewInjectorImp(ThreadSpec threadSpec) {
        this.mThreadSpec = threadSpec;
    }

    @Override
    public <V> V detachView(V view, Class<?> aClass) {
        return nullObjectPatternView(view, aClass);
    }

    @Override
    public <V> V injectView(V view, Class<?> aClass) {
        return inject(view, mThreadSpec, aClass);
    }


    /**
     * Inject t.
     *
     * @param <T>                the type parameter
     * @param viewImplementation the view implementation
     * @param mainThreadSpec     the main thread spec
     * @param aClass             the a class
     * @return the t
     */
    public <T> T inject(T viewImplementation, ThreadSpec mainThreadSpec, Class<?> aClass) {
        try {
            Class<?> viewInterface = findThreadDecoratedView(viewImplementation.getClass(), aClass);
            Class<?> decoratedView = findViewClassWithPrefix(DECORATED_CLASS_PREFIX, viewInterface);
            Constructor<?> constructor = decoratedView.getConstructor(viewInterface, ThreadSpec.class);
            return (T) constructor.newInstance(viewImplementation, mainThreadSpec);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Null object pattern view t.
     *
     * @param <T>                the type parameter
     * @param viewImplementation the view implementation
     * @param aClass             the a class
     * @return the t
     */
    public <T> T nullObjectPatternView(T viewImplementation, Class<?> aClass) {
        try {
            Class<?> viewInterface = findThreadDecoratedView(viewImplementation.getClass(), aClass);
            Class<?> decoratedView = findViewClassWithPrefix(NULL_CLASS_PREFIX, viewInterface);
            Constructor<?> constructor = decoratedView.getConstructor();
            return (T) constructor.newInstance();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Class<?> findThreadDecoratedView(Class<?> implementedViewClass, Class<?> aClass) {
        Class<?>[] viewInterfaces = implementedViewClass.getInterfaces();
        for (Class<?> viewInterface : viewInterfaces) {
            if (viewInterface.isAnnotationPresent(ThreadDecoratedView.class) && viewInterface.isAssignableFrom(aClass)) {
                return viewInterface;
            }
        }
        if (implementedViewClass.getSuperclass() != null) {
            return findThreadDecoratedView(implementedViewClass.getSuperclass(), aClass);
        }
        throw new RuntimeException(
                "Cannot find any View annotated with @" + ThreadDecoratedView.class.getName());
    }

    private Class<?> findViewClassWithPrefix(String classPrefix, Class<?> viewInterface) {
        String packageName = viewInterface.getPackage().getName();
        String className = packageName + "." + classPrefix + viewInterface.getSimpleName();
        try {
            Class<?> decoratedViewClass = Class.forName(className);
            if (decoratedViewClass == Void.TYPE) {
                throw new RuntimeException("Can't find decoratedView class");
            }
            return decoratedViewClass;
        } catch (ClassNotFoundException e) {
            System.err.println(
                    String.format("Class %s not found. Please annotate with @%s the class %s", className,
                                  ThreadDecoratedView.class.getSimpleName(), viewInterface.getCanonicalName()));
        }
        return Void.TYPE;
    }

}
