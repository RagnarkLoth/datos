package com.example.datos.controllers;

import com.example.datos.entitys.UsuarioEnity;
import com.example.datos.services.UsuarioServices;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioRestController {

    Log log = LogFactory.getLog(getClass());

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping("/actualizar")
    public void actualizar(){

        try{

            usuarioServices.actualizarDatos(usuarioServices.traerDatos());

        }catch (Exception e){

           log.error(e.getMessage());

        }

    }

    @GetMapping("/traer")
    public List<UsuarioEnity> traer(){

        return usuarioServices.traerDatos();

    }

}
