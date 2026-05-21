package com.javanauta.agendador.tarefas.business.mapper;

import com.javanauta.agendador.tarefas.business.dto.TarefasDTO;
import com.javanauta.agendador.tarefas.infrastructure.entity.TarefasEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface TarefasConverter {

    TarefasEntity paraTarefaEntity(TarefasDTO dto);

    TarefasDTO paraTarefaDTO(TarefasEntity entity);
}
