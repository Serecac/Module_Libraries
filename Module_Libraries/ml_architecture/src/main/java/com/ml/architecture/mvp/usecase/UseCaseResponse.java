package com.ml.architecture.mvp.usecase;

/**
 * <p> Class UseCaseResponse </p>
 * Manage result for usecase execution
 *
 * @param <T> the type parameter
 * @author Javier Cáceres
 * @version 1.0.0
 */
public class UseCaseResponse<T> {

  private UseCaseError error;
  private T result;

  /**
   * Instantiates a new Use case response.
   *
   * @param error the error
   */
  public UseCaseResponse(UseCaseError error) {
    this.error = error;
  }

  /**
   * Instantiates a new Use case response.
   *
   * @param result the result
   */
  public UseCaseResponse(T result) {
    this.result = result;
  }

  /**
   * Gets error.
   *
   * @return the error
   */
  public UseCaseError getError() {
    return error;
  }

  /**
   * Gets result.
   *
   * @return the result
   */
  public T getResult() {
    return result;
  }

  /**
   * Has error boolean.
   *
   * @return the boolean
   */
  public boolean hasError() {
    return error != null;
  }
}
