package me.dio.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

import java.util.List;


@Entity(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Account account;

    @OneToOne(cascade = CascadeType.ALL)
    private Card card;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//toda vez que for buscar um usuario no banco vai aparecer o que estiver marcado como eager
    private List<Feature> features;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<News> news;

    public Long getId(){return id;}

    public void setId(Long id){ this.id = id;}

    public String getName(){ return name;}

    public void setName(String name){ this.name = name;}

    public Account geAccount(){ return account;}

    public void setAccount(Account account){ this.account = account;}

    public Card getCard(){ return card;}

    public void setCard(Card card){ this.card = card;}


}
