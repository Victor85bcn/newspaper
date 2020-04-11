package com.example.fourgeeks.repository;

import com.example.fourgeeks.configuration.TestDatabaseConfiguration;
import com.example.fourgeeks.model.Comentario;
import com.example.fourgeeks.repository.impl.ComentarioRepository;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ContextConfiguration(classes = {TestDatabaseConfiguration.class})
public class ComentarioRepositoryTest {
    @Autowired
    private ComentarioRepository repository;

    @Test
    public void testA(){
        Comentario comentario = new Comentario();
        comentario.setComentario("ComentarioA");
        comentario.setIdComentario(1);
        comentario.setIdPost(3);
        comentario.setAlias("Alias1");
        comentario.setRespuesta(null);

        Assert.assertTrue(repository.save(comentario));
    }

    @Test
    public void testB(){
        Comentario comentario = new Comentario();
        comentario.setComentario("ComentarioB");
        comentario.setIdComentario(1);
        comentario.setIdPost(3);
        comentario.setAlias("Alias2");
        comentario.setRespuesta(null);

        Assert.assertTrue(repository.update(comentario));
    }

    @Test
    public void testC(){
        Assert.assertFalse(repository.findAll().isEmpty());
    }

    @Test
    public void testD(){
        Assert.assertTrue(repository.findById(1).getComentario().equalsIgnoreCase("ComentarioB"));
    }
}