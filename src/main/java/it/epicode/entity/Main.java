package it.epicode.entity;

import com.github.javafaker.Faker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker(new Locale("it"));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("unit-jpa");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        Evento evento = new Evento();

        evento.setTitolo(faker.book().title());
        evento.setDataEvento(LocalDate.now());
        evento.setDescrizione(faker.lorem().paragraph());
        evento.setTipoEvento(TipoEvento.PUBBLICO);
        evento.setNumeroMassimoPartecipanti(faker.number().numberBetween(1, 500));

        eventoDAO.save(evento);
        em.close();
        emf.close();
    }
}
