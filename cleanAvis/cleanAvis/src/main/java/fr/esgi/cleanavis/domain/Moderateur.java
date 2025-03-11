package fr.esgi.cleanavis.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Moderateur extends Utilisateur {

    private String numeroDeTelephone;

    public Moderateur(String pseudo, String motDePasse, String mail, String numeroDeTelephone) {
        super(pseudo, motDePasse, mail);
        this.numeroDeTelephone = numeroDeTelephone;
    }
}
