package me.dio.credit.application.system.entity

import jakarta.persistence.*
import me.dio.credit.application.system.enumeration.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.*

@Entity //faz a classe vai se tornar tabela no db
//@Table(name = "Credit") //da nome as tabelas
data class Credit (
    @Column(nullable = false, unique = true) val creditCode: UUID = UUID.randomUUID(),
    @Column(nullable = false) val creditValue: BigDecimal = BigDecimal.ZERO,
    @Column(nullable = false) val dayFirstInstallment: LocalDate,
    @Column(nullable = false) val numberOfInstallment: Int = 0,
    @Enumerated val status: Status = Status.IN_PROGRESS,
    @ManyToOne val customer: Customer? = null, //muitos creditos pode pertencer a um customer
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null
)
