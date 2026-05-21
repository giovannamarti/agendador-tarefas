package com.javanauta.agendador.tarefas.controller;

import com.javanauta.agendador.tarefas.business.TarefasService;
import com.javanauta.agendador.tarefas.business.dto.TarefasDTO;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


    @RestController
    @RequestMapping("/tarefas")
    @RequiredArgsConstructor
    public class TarefasController {

        private final TarefasService tarefasService;

        @PostMapping
        public ResponseEntity<TarefasDTO> gravarTarefas(@RequestBody TarefasDTO dto,
                                                        @RequestHeader("Authorization") String token) {

            return ResponseEntity.ok(tarefasService.gravarTarefa(token,dto));

        }
    }

