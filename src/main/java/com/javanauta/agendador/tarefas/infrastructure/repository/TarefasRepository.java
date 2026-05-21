package com.javanauta.agendador.tarefas.infrastructure.repository;

import com.javanauta.agendador.tarefas.infrastructure.entity.TarefasEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefasRepository extends MongoRepository<TarefasEntity, String> {
}
