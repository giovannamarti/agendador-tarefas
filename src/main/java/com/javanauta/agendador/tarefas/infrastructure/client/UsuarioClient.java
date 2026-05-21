package com.javanauta.agendador.tarefas.infrastructure.client;

import com.javanauta.agendador.tarefas.business.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(name= "usuario",url="${usuario.url}")
    public interface UsuarioClient{

    @GetMapping
    UsuarioDTO buscaUsuarioPorEmail(@RequestParam("email") String email,
             j                       @RequestHeader("Authorization") String token);

}


