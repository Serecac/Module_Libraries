package com.ml.architecture.mvp.mapper;

/**
 * <p> Interface Mapper </p>
 * Used to map one type object to another, and the opposite
 *
 * @param <M> the type parameter
 * @param <P> the type parameter
 * @version 1.0.0
 */
public interface TwoWaysMapper<M, P> extends Mapper<M, P> {

      /**
       * Inverse map m.
       *
       * @param model the model
       * @return the m
       */
      M inverseMap(P model);
}