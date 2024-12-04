package it.epicode.entity;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EventoDAO {
    private EntityManager em;

    public void save(Evento evento) {
        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();
    }

    public Evento findEventoById(Long id) {
        return em.find(Evento.class, id);
    }

    public void deleteById(Long id) {
        Evento evento = findEventoById(id);
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }

    public void delete(Evento evento) {
        em.getTransaction().begin();
        em.remove(evento);
        em.getTransaction().commit();
    }

    public void updateEvento(Evento evento) {
        em.getTransaction().begin();
        em.merge(evento);
        em.getTransaction().commit();
    }



}
