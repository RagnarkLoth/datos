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

                for(int j = 0; j<usuariosAlias.size()-1; j++) {

                    int indexAntiguo = j + 1;

                    int distancia = usuariosAlias.get(j).getDistance()-usuariosAlias.get(indexAntiguo).getDistance();

                    int botonIzquierdo = usuariosAlias.get(j).getLeftButton()-usuariosAlias.get(indexAntiguo).getLeftButton();

                    int botonDerecho = usuariosAlias.get(j).getRightButton() - usuariosAlias.get(indexAntiguo).getRightButton();

                    int botonMedio = usuariosAlias.get(j).getMiddelButton()-usuariosAlias.get(indexAntiguo).getMiddelButton();

                    int ruedaMouse = usuariosAlias.get(j).getMousewheelScrolls()-usuariosAlias.get(indexAntiguo).getMousewheelScrolls();

                    int dobleClick = usuariosAlias.get(j).getDoubleClicks()-usuariosAlias.get(indexAntiguo).getDoubleClicks();

                    int teclas = usuariosAlias.get(j).getKeystrokes()-usuariosAlias.get(indexAntiguo).getKeystrokes();

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

        return usuarioRepository.findByAlias("DDDD");

    }

}
