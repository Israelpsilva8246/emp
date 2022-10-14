package com.ms.email.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_email")
public class Email implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "email", length = 100, nullable = false)
    private String email;
    @Column(name = "data_envio")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataEnvio = LocalDate.now();
}
