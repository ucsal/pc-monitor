package br.ucsal.pcmonitorspring.entities;

import javax.persistence.*;

@Entity
@Table(name = "pc_user")
public class PcUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @Column(nullable = false)
    private User user_id;

    @ManyToOne
    @Column(nullable = false)
    private Pc pc_id;

    public PcUser(Pc pc_id, User user_id) {
        this.pc_id = pc_id;
        this.user_id = user_id;
    }

    public PcUser() {}

    public Pc getPc_id() {
        return pc_id;
    }

    public void setPc_id(Pc pc_id) {
        this.pc_id = pc_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
