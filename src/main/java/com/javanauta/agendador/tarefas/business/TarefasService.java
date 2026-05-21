package com.javanauta.agendador.tarefas.business;

import com.javanauta.agendador.tarefas.business.dto.TarefasDTO;
import com.javanauta.agendador.tarefas.business.mapper.TarefasConverter;
import com.javanauta.agendador.tarefas.infrastructure.entity.TarefasEntity;
import com.javanauta.agendador.tarefas.infrastructure.enums.StatusNotificacaoEnum;
import com.javanauta.agendador.tarefas.infrastructure.repository.TarefasRepository;
import com.javanauta.agendador.tarefas.infrastructure.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TarefasService {

    private final TarefasRepository tarefasRepository;
    private final TarefasConverter tarefaConverter;
    private final JwtUtil jwtUtil;

    public TarefasDTO gravarTarefa(String token,TarefasDTO dto) {
        String email = jwtUtil.extractUsername(token.substring(7));
        dto.setDataCriacao(LocalDateTime.now());
        dto.setStatusNotificacaoEnum(StatusNotificacaoEnum.PENDENTE);
        dto.setEmailUsuario(email);
        TarefasEntity entity = tarefaConverter.paraTarefaEntity(dto);


        return tarefaConverter.paraTarefaDTO(
                tarefasRepository.save(entity));
    }
}
