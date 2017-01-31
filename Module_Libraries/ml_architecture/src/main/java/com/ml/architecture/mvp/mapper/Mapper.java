package com.ml.architecture.mvp.mapper;

/**
 * <p> Interface Mapper </p>
 * Used to map one type object to another
 *
 * @param <M> the type parameter
 * @param <P> the type parameter
 * @version 1.0.0
 */
public interface Mapper<M, P> {

      /**
       * Map one type object to another
       *
       * @param model the model
       * @return the p
       */
      P map(M model);
}

