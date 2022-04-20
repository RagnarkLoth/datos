package com.example.datos.services;

import com.example.datos.entitys.UsuarioEnity;
import com.example.datos.repositorys.UsuarioRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Collections.*;

@Service
public class UsuarioServices {

    Log log = LogFactory.getLog(getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void actualizarDatos(List<UsuarioEnity> usuarios){

        String[] alias = {"AAAA", "BBBB", "EEEE", "FFFF", "DDDD"};

        List<UsuarioEnity> usuariosAlias = new ArrayList<>();
        List<UsuarioEnity> datosNuevos = new ArrayList<>();

        int i = 0;

        try{

            do{

                for (UsuarioEnity usuario: usuarios){

                    if(alias[i].equals(usuario.getAlias())){
                        usuariosAlias.add(usuario);
                        log.info(usuario.getId());
                    }

                }

                Collections.reverse(usuariosAlias);

                for(int j = 1; j<usuariosAlias.size(); j++) {

                    int distancia = usuariosAlias.get(j).getDistance()-usuariosAlias.get(j).getDistance();

                    log.info("paso");

                    int botonIzquierdo = usuariosAlias.get(j-1).getLeftButton()-usuariosAlias.get(j).getLeftButton();

                    log.info("paso");

                    int botonDerecho = usuariosAlias.get(j-1).getRightButton()-usuariosAlias.get(j).getRightButton();

                    log.info("paso");

                    int botonMedio = usuariosAlias.get(j-1).getMiddelButton()-usuariosAlias.get(j).getMiddelButton();

                    log.info("paso");

                    int ruedaMouse = usuariosAlias.get(j-1).getMousewheelScrolls()-usuariosAlias.get(j).getMousewheelScrolls();

                    log.info("paso");

                    int dobleClick = usuariosAlias.get(j-1).getDoubleClicks()-usuariosAlias.get(j).getDoubleClicks();

                    log.info("paso");

                    int teclas = usuariosAlias.get(j-1).getKeystrokes()-usuariosAlias.get(j).getKeystrokes();

                    log.info("paso");

                    UsuarioEnity usuarioNuevo = usuarioRepository.findById(usuariosAlias.get(j).getId().intValue());

                    usuarioNuevo.setDistance(distancia);

                    usuarioNuevo.setLeftButton(botonIzquierdo);

                    usuarioNuevo.setRightButton(botonDerecho);

                    usuarioNuevo.setMiddelButton(botonMedio);

                    usuarioNuevo.setMousewheelScrolls(ruedaMouse);

                    usuarioNuevo.setDoubleClicks(dobleClick);

                    usuarioNuevo.setKeystrokes(teclas);

                    datosNuevos.add(usuarioNuevo);
                }

                i++;
            }while (i<alias.length);

            for (UsuarioEnity usuario: datosNuevos){

                usuarioRepository.save(usuario);

            }

            log.info("Se inserto correctamente todos los datos");

        }catch (Exception e){

            log.error(e.getMessage());

        }
    }

    public List<UsuarioEnity> traerDatos(){

        return usuarioRepository.findByAlias("AAAA");

    }

}
