package com.example.newspaper.repository;

import com.example.newspaper.mapper.GrupoPermisoMapper;
import com.example.newspaper.model.GrupoPermiso;
import com.example.newspaper.repository.GrupoPermisoRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public class GrupoPermisoRepository implements GrupoPermisoRep {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean save(GrupoPermiso object) {
        try {
            String sql = String.format("insert into grupo_permiso (IdGrupo, IdPermiso) values ('%d', '%d')",
                    object.getIdGrupo(), object.getIdPermiso());
            jdbcTemplate.execute(sql);
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(GrupoPermiso object) {
        if(object.getIdGrupo()>0) {
            String sql = String.format("update grupo_permiso set IdPermiso='%d' where IdGrupo='%d'",
                    object.getIdPermiso(), object.getIdGrupo());
            jdbcTemplate.execute(sql);
        }
        return false;
    }

    @Override
    public List<GrupoPermiso> findAll(Pageable pageable) {
        return jdbcTemplate.query("select * from grupo_permiso", new GrupoPermisoMapper());
    }

    @Override
    public GrupoPermiso findById(int Id) {
        Object[] params = new Object[] {Id};
        return jdbcTemplate.queryForObject("select * from grupo_permiso where IdGrupoPermiso = ?",
                params, new GrupoPermisoMapper());
    }
}
