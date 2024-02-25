package gkl.exercise.entities

import io.micronaut.data.annotation.MappedEntity
import jakarta.annotation.Nonnull
import jakarta.persistence.*
import java.util.*


@Entity
@Table(name="reservation")
@MappedEntity
class ReservationEntity {

    @Id
    @Nonnull
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id : Long = 0

    @Column(name = "empid")
    var empid: Long = 0

    @Column(name = "date")
    var date: Date = Date()

    constructor(empid : Long,date : Date){
        this.empid=empid
        this.date=date
    }

    constructor(){

    }

}