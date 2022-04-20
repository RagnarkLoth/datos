package com.example.datos.services;

import com.example.datos.entitys.UsuarioEnity;
import com.example.datos.repositorys.UsuarioRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServices {

    Log log = LogFactory.getLog(getClass());

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void actualizarDatos(ArrayList<UsuarioEnity> usuarios){

        String[] alias = {"AAA", "BBB", "EEE", "FFF"};

        List<UsuarioEnity> usuariosAlias = new ArrayList<>();
        List<UsuarioEnity> datosNuevos = new ArrayList<>();

        int i = 0;

        try{

            do{

                for (UsuarioEnity usuario: usuarios){

                    if(alias[i].equals(usuario.getAlias().toString())){
                        usuariosAlias.add(usuario);
                    }

                }

                for(int j = 0; i<usuariosAlias.size(); j++){


                    int distancia = usuariosAlias.get(usuariosAlias.size()-2).getDistance() - usuariosAlias.get(usuariosAlias.size()-1).getDistance();

                    UsuarioEnity usuarioNuevo = usuarioRepository.findById(usuariosAlias.get(usuariosAlias.size()-2).getId());

                    usuarioNuevo.setDistance(distancia);

                }

                i++;
            }while (i<alias.length);

        }catch (Exception e){

        }
    }

    public List<UsuarioEnity> traerDatos(){

        return usuarioRepository.findAll();

    }

}
