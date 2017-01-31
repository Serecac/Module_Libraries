package com.ml.architecture.mvp.mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * <p> Class ListMapper </p>
 * Map list into another list
 *
 * @param <M> first list type
 * @param <P> second list type
 * @version 1.0.0
 */
public class ListMapper<M, P> implements Mapper<List<M>, List<P>> {

    private final Mapper<M, P> mapper;

    /**
     * Instantiates a new ListMapper.
     *
     * @param mapper the mapper
     */
    public ListMapper(Mapper<M, P> mapper) {
      this.mapper = mapper;
    }

    @Override
    public List<P> map(List<M> models) {
      ArrayList<P> persistences = new ArrayList<>();
      if (models != null && models.size() > 0) {
        for (M model : models) {
          persistences.add(mapper.map(model));
        }
      }
      return persistences;
    }
}
